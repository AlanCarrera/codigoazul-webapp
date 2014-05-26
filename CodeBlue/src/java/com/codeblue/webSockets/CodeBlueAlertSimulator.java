/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codeblue.webSockets;

import Control.Control;
import Interfaces.IDAOs;
import Tests.CodeBlueAlertTest;
import com.bluecode.businessObjects.Zone;
import exceptions.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Laser Marker
 */
@ServerEndpoint("/endpoint/codeBlueAlertSimulator")
public class CodeBlueAlertSimulator {

    @OnMessage
    public void onMessage(String message) {
        try {
            System.out.println(message);
            IDAOs daos = new Control();
            Zone zone = daos.getZoneById(Integer.valueOf(message));
            
//            CodeBlueAlertTest alertTest = new CodeBlueAlertTest(
//                    zone.getId(),
//                    (zone.getXesi() + 5),
//                    zone.getYeid() - 5);
            
        } catch (Exception ex) {
            Logger.getLogger(CodeBlueAlertSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
