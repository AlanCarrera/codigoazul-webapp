/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bluecode.businessObjects;

/**
 *
 * @author Laser Marker
 */
public class Equipo {
    
    private int idEquipo;
    private int idPersonal;
    private int idRol;
    private int idZona;
    private int disponible;

    public Equipo() {
    }
    
    /**
     * Constructor para hacer referencia al objeto EquipoRespuesta, es decir, no contiene
     * el atributo disponible, lo que detemrina si el personal esta disponible o no
     * para atender una alerta.
     * 
     * @param idEquipo identificador del objeto.
     * @param idPersonal identificador de la persona.
     * @param idRol identificador del rol que toma en juego en una alerta.
     * @param idZona  identificador de la zona donde se encuentra el personal.
     */
    public Equipo(int idEquipo, int idPersonal, int idRol, int idZona) {
        this.idEquipo = idEquipo;
        this.idPersonal = idPersonal;
        this.idRol = idRol;
        this.idZona = idZona;
    }

    /**
     * Constructor para hacer referencia al objeto EquipoBase, es decir, contiene
     * un atributo llamado disponible, el cual detemrina si el personal esta disponible o no,
     * o puede ser un cierto grado de dispnibilidad.
     * 
     * @param idEquipo identificador del objeto.
     * @param idPersonal identificador de la persona.
     * @param idRol identificador del rol que toma en juego en una alerta.
     * @param idZona  identificador de la zona donde se encuentra el personal.
     * @param disponible grado de disponibilidad de la persona.
     */
    public Equipo(int idEquipo, int idPersonal, int idRol, int idZona, int disponible) {
        this.idEquipo = idEquipo;
        this.idPersonal = idPersonal;
        this.idRol = idRol;
        this.idZona = idZona;
        this.disponible = disponible;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.idEquipo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipo other = (Equipo) obj;
        if (this.idEquipo != other.idEquipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", idPersonal=" + idPersonal + ", idRol=" + idRol + ", idZona=" + idZona + ", disponible=" + disponible + '}';
    }
    
    
    
    
    
}
