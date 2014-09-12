/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CodeBlue.Interfaces;

import com.CodeBlue.Excepciones.AdmorEquipoRespuestaException;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Zone;
import java.util.List;

/**
 *
 * @author Laser Marker
 */
public interface IAdmorEquipoRespuesta {
    
        
    /**
     * Este metodo sirve para formar el equipo de respuesta que atendera una
     * emergencia de codigo azul, es un algoritmo especializado el cual
     * determina con mayor eficiencia que persona puede o no atender dicha
     * alerta, ahora bien solo se necesita de la indicacion de la zona donde
     * ocurrio la alerta.
     * 
     * @param zona Zona donde ocurrio la alerta de Codigo Azul.
     * @return retorna verdadero si se ha logrado formar el equipo de respuesta con exito, falso en
     * caso contrario.
     * @throws AdmorEquipoRespuestaException  lanza  un error ocurrido en el Administrador de personal.
     */
    public boolean formarEquipoRespuesta(Zone zona) throws AdmorEquipoRespuestaException;
    
    /**
     * Este metodo regresa la lista de empleados que forman parte del equipo de
     * repsuesta aun evento de codigo azul.
     * 
     * @return lista de equipo de respuesta.
     * @throws AdmorEquipoRespuestaException  lanza  un error ocurrido en el Administrador de personal.
     */
    public List<Employe> getEquipoRespuesta() throws AdmorEquipoRespuestaException;
    
}
