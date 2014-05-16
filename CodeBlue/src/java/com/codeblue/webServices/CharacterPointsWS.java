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
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Laser Marker
 */
@WebService(serviceName = "CharacterPointsWS")
public class CharacterPointsWS {

    @WebMethod(operationName = "characterPoints")
    @Oneway
    public void characterPoints(@WebParam(name = "id") int id, @WebParam(name = "x") double x, @WebParam(name = "y") double y) {
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
                        System.out.println("id: " + id + "; zone: " + z.getName());
                        idao.updateCharacterOnZone(id, z.getId());
                        break;
                    }
//                    System.out.println("No");
                }
            }
//            System.out.println("finish");
        } catch (PersistenciaException ex) {
            Logger.getLogger(CharacterPointsWS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
