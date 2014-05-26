/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeblue.webSockets;

import Control.Control;
import Interfaces.IDAOs;
import com.bluecode.businessObjects.Zone;
import com.google.gson.Gson;
import exceptions.PersistenciaException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Laser Marker
 */
@ServerEndpoint("/endpoint/loadZones")
public class LoadZones {

    @OnMessage
    public String onMessage(String message) {
        return null;
    }

    @OnOpen
    public void open(Session session, EndpointConfig conf) {
        System.out.println("Se abrio una nueva conexion, session: " + session.getId() + ", config: " + conf.toString());
//        queue.add(session);
        try {
            IDAOs daos = new Control();
            List<Zone> zones = daos.getZoneAll();
            Gson gson = new Gson();
//            for (int i = 0; i < maps.size(); i++) {
//                for (int j = 0; j < maps.get(i).getCoordenadas().size(); j++) {
//                    maps.get(i).getCoordenadas().get(j).setX((maps.get(i).getCoordenadas().get(j).getX() * 6));
//                    System.out.println(maps.get(i).getCoordenadas().get(j).getX() * 6);
//                    maps.get(i).getCoordenadas().get(j).setY((maps.get(i).getCoordenadas().get(j).getY() * 6));
//                    System.out.println(maps.get(i).getCoordenadas().get(j).getY() * 6);
//                }
//            }
//            List<Object> jsonMap = new ArrayList<Object>();
//            jsonMap.add(new Object(){ String nombre = "map";});
//            jsonMap.addAll(maps);
            String zonesJson = gson.toJson(zones);
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
            String txt = String.valueOf(zonesJson);
            System.out.println("texto:" + txt);
            //Al abrir una nueva conexion, el servidor responde!
            session.getBasicRemote().sendText(String.valueOf(txt));
//            session.getBasicRemote().sendText(msg);
        } catch (IOException | PersistenciaException ex) {
            Logger.getLogger(LoadZones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
