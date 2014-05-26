/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeblue.massageDrivenBeans;

import Control.Control;
import Interfaces.IDAOs;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Zone;
import com.codeblue.displays.EmployesResponse;
import com.codeblue.webSockets.LoadTeamResponse;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Laser Marker
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/teamReadyQueue")
})
public class TeamReadyMDB implements MessageListener {
    
//    @Inject
//    @com.codeblue.webSockets.EmployesRsponse
//    Event<EmployesResponse> teamReady;

    public TeamReadyMDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            System.out.println("Mesnaje=" + tm.getText());
            com.codeblue.webSockets.LoadTeamResponse f = new LoadTeamResponse();
            IDAOs daos = new Control();
            List<Employe> lista = daos.getTeamResponse();
            f.broadcastTeamReady(lista);
            
//            teamReady.fire(new EmployesResponse(lista));
        } catch (Exception e) {
            System.out.println("Error=" + e);
        }

    }

}
