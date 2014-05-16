/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codeblue.webServices;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Laser Marker
 */
@WebService(serviceName = "TeamReadyToCodeBlu")
public class TeamReadyToCodeBlu {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "readyTeam")
    @Oneway
    public void readyTeam(@WebParam(name = "msg") String msg) {
        //TODO write your implementation code here:
        System.out.println("Mensaje de Team Generator: " + msg);
    }
}
