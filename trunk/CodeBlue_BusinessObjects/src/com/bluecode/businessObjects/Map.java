/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bluecode.businessObjects;

import java.util.List;

/**
 *
 * @author QUINTERO
 */
public class Map {
    
    private int id;
    private String nombre;
    private List<MapCoords> coordenadas;

    public Map() {
    }

    public Map(int id) {
        this.id = id;
    }

    public Map(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Map(int id, String nombre, List<MapCoords> coordenadas) {
        this.id = id;
        this.nombre = nombre;
        this.coordenadas = coordenadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<MapCoords> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<MapCoords> coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
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
        final Map other = (Map) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Map{" + "id=" + id + ", nombre=" + nombre + ", coordenadas=" + coordenadas + '}';
    }
    
}
