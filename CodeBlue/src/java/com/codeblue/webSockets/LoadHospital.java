/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codeblue.webSockets;

import Control.Control;
import Interfaces.IDAOs;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.Zone;
import com.google.gson.Gson;
import exceptions.PersistenciaException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Laser Marker
 */
@ServerEndpoint("/endPoint/loadHospital")
public class LoadHospital {
   //queue publisher thread of connected clients
    private static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
    private static Thread thread;

    static {
        thread = new Thread() {
            public void run() {
                while (true) {

                    if (queue != null) {
                        try {
                            IDAOs daos = new Control();
                            List<Employe> employeList = daos.getEmployeAll();
                            for (int i = 0; i < employeList.size(); i++) {
                                Zone zone = daos.getZoneByEmploye(employeList.get(i).getId());
                                if (zone != null) {
                                    employeList.get(i).setZone(zone);
                                }
                            }
                            sendAll(employeList);
                        } catch (PersistenciaException ex) {
                            Logger.getLogger(LoadHospital.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    try {
                        sleep(2000);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        };
        thread.start();
    }

    @OnMessage
    public String onMessage(String message) {

        return message;
    }

    @OnOpen
    public void open(Session session, EndpointConfig conf) {
        System.out.println("Se abrio una nueva conexion, session: " + session.getId() + ", config: " + conf.toString());
        queue.add(session);
        try {
            IDAOs daos = new Control();
            List<Map> maps = daos.getMapAll();
            Gson gson = new Gson();
            for (int i = 0; i < maps.size(); i++) {
                for (int j = 0; j < maps.get(i).getCoordenadas().size(); j++) {
                    maps.get(i).getCoordenadas().get(j).setX((maps.get(i).getCoordenadas().get(j).getX() * 6));
                    System.out.println(maps.get(i).getCoordenadas().get(j).getX() * 6);
                    maps.get(i).getCoordenadas().get(j).setY((maps.get(i).getCoordenadas().get(j).getY() * 6));
                    System.out.println(maps.get(i).getCoordenadas().get(j).getY() * 6);
                }
            }
            List<Object> jsonMap = new ArrayList<Object>();
//            jsonMap.add(new Object(){ String nombre = "map";});
            jsonMap.addAll(maps);
            String MapsJson = gson.toJson(jsonMap);
//            Zone zone1 = new Zone(1, "Medicina interna A", 7.4545, 0, 14.9282, 12.9417);
            String msg = null;
//            msg += "<g transform=\"scale(6)\">";
//            msg += "<rect class='zone' x='26.727 y='0' stroke='#333333' stroke-width='1.4173' stroke-linecap='round' stroke-linejoin='round' stroke-miterlimit='10' width='44.8662' height='77.6502'/>";
//            msg += "</g>";

            //EJB
//            List<Mapa> i = mapaFacade.findAll();
//            for(Mapa m: i){
//                System.out.println(m.getIdmapa() + ", " + m.getNombre() + ", " + m.getPuntosMapa().size());
//            }
            String txt = String.valueOf(MapsJson);
            System.out.println("texto:" + txt);
            //Al abrir una nueva conexion, el servidor responde!
            session.getBasicRemote().sendText(String.valueOf(txt));
//            session.getBasicRemote().sendText(msg);
        } catch (IOException ex) {
            Logger.getLogger(LoadHospital.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(LoadHospital.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnError
    public void error(Session session, Throwable t) {
        queue.remove(session);
        System.err.println("Error on session: " + session.getId());
    }

    @OnClose
    public void closedConnection(Session session) {
        queue.remove(session);
        System.out.println("Session closed: " + session.getId());
    }

    private static void sendAll(List<Employe> employes) {
        try {
            ArrayList<Session> closedSessions = new ArrayList<Session>();
            for (Session session : queue) {
                if (!session.isOpen()) {
                    closedSessions.add(session);
                } else {
                    Gson gson = new Gson();
                    List<Object> jsonMap = new ArrayList<Object>();
                    jsonMap.addAll(employes);
                    session.getBasicRemote().sendText(gson.toJson(jsonMap));
                }
            }
            queue.removeAll(closedSessions);
            System.out.println("Sening to " + queue.size() + " clients.");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
}
