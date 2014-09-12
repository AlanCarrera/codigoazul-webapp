/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CodeBlue.Interfaces;

import com.CodeBlue.Excepciones.AdmorPersonalException;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Position;
import com.bluecode.businessObjects.Role;
import com.bluecode.businessObjects.Zone;
import java.util.List;

/**
 *Esta interfas especifica que es lo que realiza el administrador de personal, ademas de
 * encapsular dicho comportamiento de las clases que la implementan.
 * 
 * @author Jesus Quintero Gutierrez 
 * @proyecto Codigo Azul
 * @asesor M. en C. Manuel Domitsu Kono 
 */
public interface IAdmorPersonal {
    
    /**
     * Este metodo devuelve la lista completa del personal en el hospital.
     * 
     * @return Lista de tipo Personal, null en caso contrario.
     * @throws AdmorPersonalException lanza  un error ocurrido en el Administrador de personal.
     */
    public List<Employe> getPersonalLista() throws AdmorPersonalException;
    
    /**
     * Este metodo devuelve un objeto tipo Personal.
     * 
     * @param idPersonal identificador del personal solicitado.
     * @return devuelve un objeto tipo Personal, null en caso contrario.
     * @throws AdmorPersonalException lanza  un error ocurrido en el Administrador de personal.
     */
    public Employe getPersonal(int idPersonal) throws AdmorPersonalException;
    
    /**
     * Este metodo devuelve un objeto de tipo Role relacionado con el personal.
     * 
     * @param idRol identificador del personal.
     * @return devuelve un objeto tipo Role, null en caso contrario.
     * @throws AdmorPersonalException lanza  un error ocurrido en el Administrador de personal.
     */
    public Role getRole(int idRol) throws AdmorPersonalException;
    
    /**
     * Este metodo devuelve un objeto de tipo Puesto elacionado con el personal.
     * 
     * @param idPuesto identificador del personal.
     * @return devuelve un objeto tipo Puesto, null en caso contrario.
     * @throws AdmorPersonalException lanza  un error ocurrido en el Administrador de personal.
     */
    public Position getPuesto(int idPuesto) throws AdmorPersonalException;
    
}
