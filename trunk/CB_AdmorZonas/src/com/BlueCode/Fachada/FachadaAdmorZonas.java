/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BlueCode.Fachada;

import Control.Control;
import Interfaces.IDAOs;
import com.BlueCode.Excepciones.AdmorZonasException;
import com.BlueCode.Interfaces.IAdmorZonas;
import com.bluecode.businessObjects.Area;
import com.bluecode.businessObjects.Zone;
import exceptions.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es la responsalbe en administrar todas las transacciones
 * relacionadas con las zonas del plano del hospital y ademas contiene la logica
 * del negocio.
 *
 * @author Jesus Quintero Gutierrez
 * @proyecto Codigo Azul
 * @asesor M. en C. Manuel Domitsu Kono
 */
public class FachadaAdmorZonas implements IAdmorZonas {

    //Atributos de la fachada.
    private IDAOs fachadaDAOs;

    /**
     * Constructor de la fachada que inicializa la conexion a los DAOs.
     */
    public FachadaAdmorZonas() {
        this.fachadaDAOs = new Control();
    }

    /**
     * Este metodo devuelve una Zona del plano del hospital correspondiente al
     * id que se le esta madando de parametro.
     *
     * @param idZona identificador de la zona que se requiere.
     * @return objeto Zona de retorno correspondiente al idZona del parametro,
     * null en caso contrario.
     * @throws AdmorZonasException retorna un error si este ocurrio en el
     * administrador de zonas.
     */
    @Override
    public Zone getZona(int idZona) throws AdmorZonasException {
        try {
            return fachadaDAOs.getZoneById(idZona);
        } catch (PersistenciaException ex) {
            System.err.println("Error: No se pudo obtener la zona solicitada,"
                    + " FachadaAdmorZonas.getZona();");
            Logger.getLogger(FachadaAdmorZonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Este metodo devuelve la zona donde se encuentra un determiando personal,
     * correspondiente al identificado que se le asigna como aprametro.
     *
     * @param idPersonal identificador del Personal a consultar.
     * @return retorna la Zona correspondiente con el Personal, null en caso
     * contrario.
     * @throws AdmorZonasException lanza un error si este ocurrio en el
     * administrador de zonas.
     */
    @Override
    public Zone getZonaPersonal(int idPersonal) throws AdmorZonasException {
        try {
            return fachadaDAOs.getZoneByEmploye(idPersonal);
        } catch (PersistenciaException ex) {
            System.err.println("Error: No se pudo obtener la zona solicitada,"
                    + " FachadaAdmorZonas.getZonaPersonal(idPrsonal);");
            Logger.getLogger(FachadaAdmorZonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Este metodo devuelve todas las zonas.
     *
     * @return devuelve la lista de zonas, null en caso contrario.
     * @throws AdmorZonasException lanza un error si este ocurrio en el
     * administrador de zonas.
     */
    @Override
    public List<Zone> getZonas() throws AdmorZonasException {
        try {
            return fachadaDAOs.getZoneAll();
        } catch (PersistenciaException ex) {
            System.err.println("Error: No se pudo obtener la lista de zonas,"
                    + " FachadaAdmorZonas.getZonas();");
            Logger.getLogger(FachadaAdmorZonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Este metodo devuelve todas las zonas de determianda area.
     * 
     * @param nombreArea area padre de las zonas.
     * @return devuelve la lista de las zonas pertenecientes al area, null en caso contrario.
     * @throws AdmorZonasException  lanza un error si este ocurrio en el administrador de zonas.
     */
    @Override
    public List<Zone> getZonasArea(String nombreArea) throws AdmorZonasException {
        try {
            Area area = fachadaDAOs.getAreaNombre(nombreArea);
            List<Zone> zonas = fachadaDAOs.getZonaArea(area.getIdArea());
            return zonas;
        } catch (PersistenciaException ex) {
            System.err.println("Error: No se pudo obtener la lista de zonas por area,"
                    + " FachadaAdmorZonas.getZonasArea();");
            Logger.getLogger(FachadaAdmorZonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
