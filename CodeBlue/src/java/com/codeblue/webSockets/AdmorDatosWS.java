/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codeblue.webSockets;

import com.BlueCode.Fachada.FachadaAdmorZonas;
import com.BlueCode.Interfaces.IAdmorZonas;
import com.CodeBlue.Fachada.FachadaAdmorPersonal;
import com.CodeBlue.Interfaces.IAdmorPersonal;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.MensajeJSON;
import com.bluecode.businessObjects.Position;
import com.bluecode.businessObjects.Role;
import com.bluecode.businessObjects.Zone;
import com.google.gson.Gson;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Laser Marker
 */
@ServerEndpoint("/endpoint/AdmorDatosWS")
public class AdmorDatosWS {
    
    //Atributos
    private final IAdmorZonas fachadaAdmorZonas = new FachadaAdmorZonas();
    private final IAdmorPersonal fachadaAdmorPersonal = new FachadaAdmorPersonal();

    @OnMessage
    public String onMessage(String message) {
        try{
//        System.out.println("entro al mensajeeeeee jajajajja");
        Gson gson = new Gson();
        MensajeJSON msjJSON = gson.fromJson(message, MensajeJSON.class);
        System.out.println(msjJSON.getNombreMensaje());
        if(msjJSON.getNombreMensaje().endsWith("getZonasArea")){
            String nombreArea = msjJSON.getMensaje();
            List<Zone> zonas = fachadaAdmorZonas.getZonasArea(nombreArea);
            MensajeJSON msjReturn = new MensajeJSON("getZonasArea", null, zonas);
            String zonasJSON = gson.toJson(msjReturn);
            return zonasJSON;
        } else if(msjJSON.getNombreMensaje().endsWith("getDetallePersonal")) {
            int idPersonal = Integer.parseInt(msjJSON.getMensaje());
            Employe personal = fachadaAdmorPersonal.getPersonal(idPersonal);
            Zone zona = fachadaAdmorZonas.getZonaPersonal(idPersonal);
            Position puestoPersonal = fachadaAdmorPersonal.getPuesto(personal.getPosition().getId());
            Role rolPersonal = fachadaAdmorPersonal.getRole(personal.getId());
            personal.setRole(rolPersonal);
            personal.setZone(zona);
            personal.setPosition(puestoPersonal);
            MensajeJSON msjReturn = new MensajeJSON("getDetallePersonal", personal);
            String personalJSON = gson.toJson(msjReturn);
            return personalJSON;
        } else {
            
        }
        } catch (Exception e){
            Logger.getLogger(AdmorDatosWS.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    } 
}
