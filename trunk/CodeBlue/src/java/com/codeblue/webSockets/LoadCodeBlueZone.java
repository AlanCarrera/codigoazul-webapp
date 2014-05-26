/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codeblue.webSockets;

import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Zone;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
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
@ServerEndpoint("/endpoint/loadCodeBlueZone")
public class LoadCodeBlueZone {
//queue publisher thread of connected clients
    private static Queue<Session> queue = new ConcurrentLinkedQueue<Session>();
//    private static Thread thread;
//
//    static {
//        thread = new Thread() {
//            public void run() {
//                while (true) {
//
//                    if (queue != null) {
//                        try {
//                            IDAOs daos = new Control();
//                            List<Employe> employeList = daos.getEmployeAll();
//                            for (int i = 0; i < employeList.size(); i++) {
//                                Zone zone = daos.getZoneByEmploye(employeList.get(i).getId());
//                                if (zone != null) {
//                                    employeList.get(i).setZone(zone);
//                                }
//                            }
//                            sendAll(employeList);
//                        } catch (PersistenciaException ex) {
//                            Logger.getLogger(LoadHospital.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//
//                    try {
//                        sleep(2000);
//                    } catch (InterruptedException ie) {
//
//                    }
//                }
//            }
//        };
//        thread.start();
//    }

    @OnMessage
    public String onMessage(String message) {

        return message;
    }

    @OnOpen
    public void open(Session session, EndpointConfig conf) {
        System.out.println("Se abrio una nueva conexion, session: " + session.getId() + ", config: " + conf.toString());
        queue.add(session);
//        try {
//            IDAOs daos = new Control();
//            List<Map> maps = daos.getMapAll();
//            Gson gson = new Gson();
//            for (int i = 0; i < maps.size(); i++) {
//                for (int j = 0; j < maps.get(i).getCoordenadas().size(); j++) {
//                    maps.get(i).getCoordenadas().get(j).setX((maps.get(i).getCoordenadas().get(j).getX() * 6));
//                    System.out.println(maps.get(i).getCoordenadas().get(j).getX() * 6);
//                    maps.get(i).getCoordenadas().get(j).setY((maps.get(i).getCoordenadas().get(j).getY() * 6));
//                    System.out.println(maps.get(i).getCoordenadas().get(j).getY() * 6);
//                }
//            }
//            List<Object> jsonMap = new ArrayList<Object>();
//            jsonMap.addAll(maps);
//            String MapsJson = gson.toJson(jsonMap);
//            String msg = null;
//
//            String txt = String.valueOf(MapsJson);
//            System.out.println("texto:" + txt);
//            //Al abrir una nueva conexion, el servidor responde!
//            session.getBasicRemote().sendText(String.valueOf(txt));
//        } catch (IOException ex) {
//            Logger.getLogger(LoadHospital.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (PersistenciaException ex) {
//            Logger.getLogger(LoadHospital.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
    
    /**
     *
     * @param list
     */
    public void broadcastCodeBlueZone(Zone zone){
        System.out.println("Entro jiji!");
        sendAll(zone);
        
    }

    private static void sendAll(Zone zone) {
        try {
            ArrayList<Session> closedSessions = new ArrayList<Session>();
            for (Session session : queue) {
                if (!session.isOpen()) {
                    closedSessions.add(session);
                } else {
                    Gson gson = new Gson();
//                    List<Object> jsonMap = new ArrayList<>();
//                    employes.add(new Employe(5));
//                    jsonMap.addAll(employes);
                    session.getBasicRemote().sendText(gson.toJson(zone));
                }
            }
            queue.removeAll(closedSessions);
            System.out.println("Sening to " + queue.size() + " clients.");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
