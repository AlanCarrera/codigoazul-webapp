/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeblue.webServices;

import Control.Control;
import Interfaces.IDAOs;
import com.CodeBlue.Fachada.FachadaAdmorEquipoRespuesta;
import com.CodeBlue.Fachada.FachadaAdmorPersonal;
import com.CodeBlue.Interfaces.IAdmorEquipoRespuesta;
import com.CodeBlue.Interfaces.IAdmorPersonal;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Zone;
import com.codeblue.webSockets.CodeBlueAlertSimulator;
import com.codeblue.webSockets.LoadCodeBlueZone;
import com.codeblue.webSockets.LoadTeamResponse;
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

    @Resource(mappedName = "jms/zoneQueue")
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
        try {
            IDAOs idao = new Control();
            List<Zone> zones = idao.getZoneAll();
            IAdmorEquipoRespuesta fachadaEquipoRespuesta = new FachadaAdmorEquipoRespuesta();
            //buscar en que zona se enceuntra
            for (Zone z : zones) {
                if (z.getXesi() <= x && x <= z.getXeid()) {//Verificar si se encuentra dentro de X
                    if (z.getYesi() <= y && y <= z.getYeid()) {//Verificar si se encuentra dentro de Y
                        System.out.println("Entro el sweb, " + z.getName());
//                        sendJMSMessageToMyQueue(z.getId());
                        //Formar euipo de respuesta.
                        fachadaEquipoRespuesta.formarEquipoRespuesta(z);
                        //enviar alerta a todos los usuarios.
                        com.codeblue.webSockets.CodeBlueAlertSimulator ws = new CodeBlueAlertSimulator();
                        ws.encenderAlertaCodigoAzul(z); //trasmite la alerta a todas las conexiones.
                        //enviar a todos los usuarios el equipo de respuesta.
                        com.codeblue.webSockets.LoadTeamResponse teamResponse = new LoadTeamResponse();
                        teamResponse.broadcastTeamReady(fachadaEquipoRespuesta.getEquipoRespuesta());
                        break;
                    }
                }
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(CharacterPointsWS.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (JMSException ex) {
//            Logger.getLogger(CodeBlueAlert.class.getName()).log(Level.SEVERE, null, ex);
//        }

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
