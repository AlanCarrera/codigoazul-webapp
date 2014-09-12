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
public class Area {
    
    //Atributos
    private int idArea;
    private String nombre;

    public Area() {
    }

    public Area(int idArea) {
        this.idArea = idArea;
    }

    public Area(int idArea, String nombre) {
        this.idArea = idArea;
        this.nombre = nombre;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idArea;
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
        final Area other = (Area) obj;
        if (this.idArea != other.idArea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Area{" + "idArea=" + idArea + ", nombre=" + nombre + '}';
    }
    
    
    
}
