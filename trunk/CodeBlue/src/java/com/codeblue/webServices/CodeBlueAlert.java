/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeblue.webServices;

import Control.Control;
import Interfaces.IDAOs;
import com.bluecode.businessObjects.Zone;
import exceptions.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Laser Marker
 */
@WebService(serviceName = "CodeBlueAlert")
public class CodeBlueAlert {

    @Resource(mappedName = "jms/myQueue")
    private Queue myQueue;
    @Resource(mappedName = "jms/myQueueFactory")
    private ConnectionFactory myQueueFactory;
    private String message;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "alert")
    @Oneway
    public void alert(@WebParam(name = "idPaciente") int idPaciente, @WebParam(name = "x") double x, @WebParam(name = "y") double y) {
        //TODO write your implementation code here:
        System.out.println("Entrooo Alerta!");
        try {
//            System.out.println("id: " + id + ",x: " + x + ",y: " + y);
            IDAOs idao = new Control();
            List<Zone> zones = idao.getZoneAll();
//            for (Zone z: zones){
//                System.out.println(z.toString());
//            }
            //checar en que zona se enceuntra
            for (Zone z : zones) {
                if (z.getXesi() <= x && x <= z.getXeid()) {//Verificar si se encuentra dentro de X
                    if (z.getYesi() <= y && y <= z.getYeid()) {
                        System.out.println("idPaciente: " + idPaciente + "; zone: " + z.getName());
//                        idao.updateCharacterOnZone(idPaciente, z.getId());
//                        alertSimulator(z.getId());
                        sendJMSMessageToMyQueue(z.getId());
                        System.out.println("ajuaa!");
                        break;
                    }
//                    System.out.println("No");
                }
            }
//            System.out.println("finish");
        } catch (PersistenciaException ex) {
            Logger.getLogger(CharacterPointsWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JMSException ex) {
            Logger.getLogger(CodeBlueAlert.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    private void sendJMSMessageToMyQueue(String messageData) {
//        context.createProducer().send(myQueue, messageData);
//    }
    private Message createJMSMessageForjmsMyQueue(Session session, Object messageData) throws JMSException {
        // TODO create and populate message to send
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData.toString());
        return tm;
    }

    private void sendJMSMessageToMyQueue(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = myQueueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(myQueue);
            messageProducer.send(createJMSMessageForjmsMyQueue(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    Logger.getLogger(this.getClass().getName()).log(Level.WARNING, "Cannot close session", e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
