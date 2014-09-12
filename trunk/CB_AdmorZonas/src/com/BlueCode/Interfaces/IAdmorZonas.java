/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.BlueCode.Interfaces;

import com.BlueCode.Excepciones.AdmorZonasException;
import com.bluecode.businessObjects.Zone;
import java.util.List;

/**
 * Esta interfas especifica que es lo que realiza el administrador de zonas, ademas de
 * encapsular dicho comportamiento de las clases que la implementan.
 * 
 * @author Jesus Quintero Gutierrez 
 * @proyecto Codigo Azul
 * @asesor M. en C. Manuel Domitsu Kono 
 */
public interface IAdmorZonas {
    
    /**
     * Este metodo devuelve una Zona del plano del hospital correspondiente
     * al identificador que se le asigna como parametro.
     * 
     * @param idZona identificador de la Zona a consultar.
     * @return retorna la Zona correspondiente con la Zona del parametro, null en caso contrario.
     * @throws AdmorZonasException lanza un error si este ocurrio en el administrador de zonas.
     */
    public Zone getZona(int idZona) throws AdmorZonasException;
    
    /**
     * Este metodo devuelve la zona donde se encuentra un determiando personal, 
     * correspondiente al identificado que se le asigna como aprametro.
     * 
     * @param idPersonal identificador del Personal a consultar.
     * @return retorna la Zona correspondiente con el Personal, null en caso contrario.
     * @throws AdmorZonasException lanza un error si este ocurrio en el administrador de zonas.
     */
    public Zone getZonaPersonal(int idPersonal) throws AdmorZonasException;
    
    /**
     * Este metodo devuelve todas las zonas.
     * 
     * @return devuelve la lista de zonas, null en caso contrario.
     * @throws AdmorZonasException lanza un error si este ocurrio en el administrador de zonas.
     */
    public List<Zone> getZonas() throws AdmorZonasException;
    
    /**
     * Este metodo devuelve todas las zonas de determianda area.
     * 
     * @param area area padre de las zonas.
     * @return devuelve la lista de las zonas pertenecientes al area, null en caso contrario.
     * @throws AdmorZonasException  lanza un error si este ocurrio en el administrador de zonas.
     */
    public List<Zone> getZonasArea(String area) throws AdmorZonasException;
    
}
