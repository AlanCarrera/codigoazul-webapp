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
import javax.xml.ws.WebServiceRef;
import services.BlueCodeAlertSimulator_Service;

/**
 *
 * @author Laser Marker
 */
@WebService(serviceName = "CodeBlueAlert")
public class CodeBlueAlert {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/BlueCode_TeamGenerator_Simulator/BlueCodeAlertSimulator.wsdl")
    private BlueCodeAlertSimulator_Service service;

//    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CodeBlue_TeamGenerator_Simulator/CodeBlueAlertSimulator.wsdl")
//    private CodeBlueAlertSimulator_Service service;

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
                        alertSimulator(z.getId());
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

//    private void alertSimulator(int idZone) {
//        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
//        // If the calling of port operations may lead to race condition some synchronization is required.
////        services.CodeBlueAlertSimulator_Service service = new services.CodeBlueAlertSimulator_Service();
//        services.CodeBlueAlertSimulator port = service.getCodeBlueAlertSimulatorPort();
////        services.CodeBlueAlertSimulator port = service.getCodeBlueAlertSimulatorPort();
//        port.alertSimulator(idZone);
//        System.out.println("ahora si!");
//    }

    private void alertSimulator(int idZone) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.BlueCodeAlertSimulator port = service.getBlueCodeAlertSimulatorPort();
        port.alertSimulator(idZone);
    }

}
