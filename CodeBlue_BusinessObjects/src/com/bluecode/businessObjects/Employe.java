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
public class Employe {
    
    private int id;
    private String nombre;
    private int dispositivo;
    private Zone zone;
    private Position position;
    private Role role;

    public Employe() {
    }

    public Employe(int id) {
        this.id = id;
    }

    public Employe(int id, String nombre, int dispositivo, Zone zone, Position position, Role role) {
        this.id = id;
        this.nombre = nombre;
        this.dispositivo = dispositivo;
        this.zone = zone;
        this.position = position;
        this.role = role;
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

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Employe other = (Employe) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nombre=" + nombre + ", dispositivo=" + dispositivo + ", zone=" + zone + ", position=" + position + ", role=" + role + '}';
    }
    
}
