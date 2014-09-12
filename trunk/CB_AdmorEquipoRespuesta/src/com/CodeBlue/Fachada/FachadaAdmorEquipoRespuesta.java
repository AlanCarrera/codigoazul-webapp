/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CodeBlue.Fachada;

import Control.Control;
import Interfaces.IDAOs;
import com.CodeBlue.Excepciones.AdmorEquipoRespuestaException;
import com.CodeBlue.Interfaces.IAdmorEquipoRespuesta;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Equipo;
import com.bluecode.businessObjects.RolPersonal;
import com.bluecode.businessObjects.Zone;
import exceptions.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laser Marker
 */
public class FachadaAdmorEquipoRespuesta implements IAdmorEquipoRespuesta {

    private IDAOs fachadaDAOs;
    private Zone zonaCodioAzul;

    public FachadaAdmorEquipoRespuesta() {
        this.fachadaDAOs = new Control();
    }

    /**
     * Este metodo sirve para formar el equipo de respuesta que atendera una
     * emergencia de codigo azul, es un algoritmo especializado el cual
     * determina con mayor eficiencia que persona puede o no atender dicha
     * alerta, ahora bien solo se necesita de la indicacion de la zona donde
     * ocurrio la alerta.
     *
     * @param zona Zona donde ocurrio la alerta de Codigo Azul.
     * @return retorna verdadero si se ha logrado formar el equipo de respuesta
     * con exito, falso en caso contrario.
     * @throws AdmorEquipoRespuestaException lanza un error ocurrido en el
     * Administrador de personal.
     */
    @Override
    public boolean formarEquipoRespuesta(Zone zona) throws AdmorEquipoRespuestaException {
        try {
            this.zonaCodioAzul = zona;
            List<RolPersonal> rolesPersonal = fachadaDAOs.getRolesEquipoCB();
            List<Equipo> baseTeam = new ArrayList<>();

            for (RolPersonal rol : rolesPersonal) {
                if (rol.getIdRol() != 0 && rol.getIdRol() != 1) {
                    Equipo equipo = metodoCualitativo(rol);
                    baseTeam.add(equipo);
                }
            }
            actualizarEquipoRespuesta(baseTeam);
            return true;
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaAdmorEquipoRespuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Este metodo regresa la lista de empleados que forman parte del equipo de
     * repsuesta aun evento de codigo azul.
     *
     * @return lista de equipo de respuesta.
     * @throws AdmorEquipoRespuestaException lanza un error ocurrido en el
     * Administrador de personal.
     */
    private Equipo metodoCualitativo(RolPersonal rolesPersonal) {
        double suma;
        double factor = 0;
        try {
            //buscar al personal calificado para determinado rol en el equipo base.
            List<Equipo> equipoBase = fachadaDAOs.getListaEquipoRol(rolesPersonal.getIdRol());
            //suma de factor para cada personal.
            List<Double> sumasList = new ArrayList<>();
            for (Equipo personal : equipoBase) {
                //determinar el factor del personal desde su ubicacion hasta la zona de alerta.
                factor = fachadaDAOs.getFactorGrafo(personal.getIdZona(), zonaCodioAzul.getId());

                if (factor == 0) {
                    factor = 1;
                }
                //calcula el grado de disponibilidad.
                suma = 0;
                suma += Factor.PROXIMITY.getValue() * factor;
                suma += Factor.RESPONSE_TEAM.getValue() * 10;
                if (personal.getDisponible() == 1) {
                    suma += Factor.AVAILABLE.getValue() * 1;
                } else if (personal.getDisponible() == 0) {
                    suma += Factor.AVAILABLE.getValue() * 0;
                }
                sumasList.add(suma);
            }
            Equipo selectedStaff = selectStaff(equipoBase, sumasList);
//            System.out.println("Rol: " + rol.getNombre() + "\nPersonal seleccionado: " + selectedStaff.getIdPersonal().getNombre());
            return selectedStaff;
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaAdmorEquipoRespuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Despues de haber calculado los factores, es posible seleccionar al mejor
     * candidato para atender la alerta por su disponibilidad.
     *
     * @param staffList lista de candidatos.
     * @param sumsList lista de la suma de sus facotres de disponibilidad.
     * @return regresa un candidato.
     */
    private Equipo selectStaff(List<Equipo> staffList, List<Double> sumsList) {
        double major = -5;
        int index = 0;

        for (int i = 0; i < sumsList.size(); i++) {
            if (sumsList.get(i) > major) {
                major = sumsList.get(i);
                index = i;
            }
        }

        return staffList.get(index);
    }

    /**
     * Este metodo actualizar la tabla de EquipoRespuesta en la base de datos.
     *
     * @param equipoRespuesta Lista del equipo de respuesta.
     */
    private void actualizarEquipoRespuesta(List<Equipo> equipoRespuesta) {
        try {
            fachadaDAOs.eliminarEquipoBase();
            fachadaDAOs.agregarEquipoRespuesta(equipoRespuesta);
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaAdmorEquipoRespuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Employe> getEquipoRespuesta() throws AdmorEquipoRespuestaException {
        try {
            return fachadaDAOs.getTeamResponse();
        } catch (PersistenciaException ex) {
            Logger.getLogger(FachadaAdmorEquipoRespuesta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
