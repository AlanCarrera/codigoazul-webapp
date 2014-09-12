/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codeblue.webSockets;

import Control.Control;
import Interfaces.IDAOs;
import Tests.CodeBlueAlertTest;
//import com.BlueCode.Control.FachadaAdmorZonas;
//import com.BlueCode.Interfaces.IAdmorZonas;
import com.BlueCode.Fachada.FachadaAdmorZonas;
import com.BlueCode.Interfaces.IAdmorZonas;
import com.bluecode.businessObjects.MensajeJSON;
import com.bluecode.businessObjects.Zone;
import com.google.gson.Gson;
import exceptions.PersistenciaException;
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
@ServerEndpoint("/endpoint/codeBlueAlertSimulator")
public class CodeBlueAlertSimulator {

    //Conexion Administradores
//    private final IAdmorPlanos fachadaAdmorPlanos = new FachadaAdmorPlanos();
//    private static IAdmorPersonal fachadaAdmorPersonal = new FachadaAdmorPersonal();
    private static IAdmorZonas fachadaAdmorZonas = new FachadaAdmorZonas();

    //queue publisher thread of connected clients
    private static Queue<Session> queue = new ConcurrentLinkedQueue<>();

    @OnMessage
    public String onMessage(String message) {
        try{
//        System.out.println("entro al mensajeeeeee jajajajja");
        Gson gson = new Gson();
        MensajeJSON msjJSON = gson.fromJson(message, MensajeJSON.class);
//        System.out.println(msjJSON.getNombreMensaje());
        if(msjJSON.getNombreMensaje().endsWith("setAlertaCodigoAzul")){
            if(msjJSON.getMensaje().equals("apagarAlerta")){
                apagarAlertaCodigoAzul();
            } else if (msjJSON.getMensaje().equals("encenderAlerta")){
//                encenderAlertaCodigoAzul(msjJSON.getIdZona());
            }
        } else {
            return null;
        }
        } catch (Exception e){
            Logger.getLogger(AdmorDatosWS.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
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

    private static void sendAll(MensajeJSON msjRetorno) {
        try {
            ArrayList<Session> closedSessions = new ArrayList<>();
            for (Session session : queue) {
                if (!session.isOpen()) {
                    closedSessions.add(session);
                } else {
                    Gson gson = new Gson();
                    session.getBasicRemote().sendText(gson.toJson(msjRetorno));
                }
            }
            queue.removeAll(closedSessions);
            System.out.println("Sening to " + queue.size() + " clients.");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    
    /**
     * Este metodo consulta la Zona por su ID y notifica a todoas las conexiones.
     * 
     * @param zona Identificador de la Zona.
     */
    public void encenderAlertaCodigoAzul(Zone zona){
//        Zone zona = fachadaAdmorZonas.getZona(idZona);
        MensajeJSON msjRetorno = new MensajeJSON("encenderAlerta", null, zona);
        sendAll(msjRetorno);
    }
    
    private void apagarAlertaCodigoAzul(){
        MensajeJSON msjRetorno = new MensajeJSON("apagarAlerta", "");
        sendAll(msjRetorno);
    }

    
}
