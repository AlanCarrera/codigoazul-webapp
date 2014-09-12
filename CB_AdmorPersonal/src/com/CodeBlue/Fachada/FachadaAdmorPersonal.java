/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CodeBlue.Fachada;

import Control.Control;
import Interfaces.IDAOs;
import com.CodeBlue.Excepciones.AdmorPersonalException;
import com.CodeBlue.Interfaces.IAdmorPersonal;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Position;
import com.bluecode.businessObjects.Role;
import com.bluecode.businessObjects.Zone;
import exceptions.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es la responsalbe en administrar todas las transacciones
 * relacionadas con el personal del hospital y ademas contiene la logica del
 * negocio.
 *
 * @author Jesus Quintero Gutierrez
 * @proyecto Codigo Azul
 * @asesor M. en C. Manuel Domitsu Kono
 */
public class FachadaAdmorPersonal implements IAdmorPersonal {

    //Atributos
    private IDAOs fachadaDAOs;

    public FachadaAdmorPersonal() {
        this.fachadaDAOs = new Control();
    }

    /**
     * Este metodo retorna la lista completa del personal en el hospital.
     *
     * @return Lista de tipo Personal, null en caso contrario.
     * @throws AdmorPersonalException Si ha ocurrido un error en el
     * Administrador de personal.
     */
    @Override
    public List<Employe> getPersonalLista() throws AdmorPersonalException {
        try {
            return fachadaDAOs.getEmployeAll();
        } catch (PersistenciaException ex) {
            System.err.println("Error: No se pudo obtener la lista de personal,"
                    + " FachadaAdmorPersonal.getPersonalLista();");
            Logger.getLogger(FachadaAdmorPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Este metodo devuelve un objeto tipo Personal.
     *
     * @param idPersonal identificador del personal solicitado.
     * @return devuelve un objeto tipo Personal, null en caso contrario.
     * @throws AdmorPersonalException lanza un error ocurrido en el
     * Administrador de personal.
     */
    @Override
    public Employe getPersonal(int idPersonal) throws AdmorPersonalException {
        try {
            Employe personal = fachadaDAOs.getPersonal(idPersonal);
            return personal;
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaAdmorPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Este metodo devuelve un objeto de tipo Role relacionado con el personal.
     *
     * @param idRol identificador del personal.
     * @return devuelve un objeto tipo Role, null en caso contrario.
     * @throws AdmorPersonalException lanza un error ocurrido en el
     * Administrador de personal.
     */
    @Override
    public Role getRole(int idRol) throws AdmorPersonalException {
        try {
            Role rol = fachadaDAOs.getRol(idRol);
            return rol;
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaAdmorPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Este metodo devuelve un objeto de tipo Puesto elacionado con el personal.
     *
     * @param idPuesto identificador del personal.
     * @return devuelve un objeto tipo Puesto, null en caso contrario.
     * @throws AdmorPersonalException lanza un error ocurrido en el
     * Administrador de personal.
     */
    @Override
    public Position getPuesto(int idPuesto) throws AdmorPersonalException {
        try {
            Position puesto = fachadaDAOs.getPuesto(idPuesto);
            return puesto;
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaAdmorPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
