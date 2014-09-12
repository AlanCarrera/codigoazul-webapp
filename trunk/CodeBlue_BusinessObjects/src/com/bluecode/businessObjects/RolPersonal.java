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
public class RolPersonal {
    
    private int idPersonal;
    private int idRol;
    private String nombreRol;

    public RolPersonal() {
    }

    public RolPersonal(int idPersonal, int idRol) {
        this.idPersonal = idPersonal;
        this.idRol = idRol;
    }

    public RolPersonal(int idRol, String nombreRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
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

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idPersonal;
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
        final RolPersonal other = (RolPersonal) obj;
        if (this.idPersonal != other.idPersonal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolPersonal{" + "idPersonal=" + idPersonal + ", idRol=" + idRol + '}';
    }
    
    
    
}
