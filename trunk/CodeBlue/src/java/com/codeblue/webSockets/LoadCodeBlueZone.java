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
    private static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    @OnMessage
    public String onMessage(String message) {
        return message;
    }

    @OnOpen
    public void open(Session session, EndpointConfig conf) {
        System.out.println("Se abrio una nueva conexion, session: " + session.getId() + ", config: " + conf.toString());
        queue.add(session);
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
