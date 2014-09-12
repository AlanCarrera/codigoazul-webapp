/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bluecode.businessObjects;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Laser Marker
 */
public class MensajeJSON {
    
    private String nombreMensaje;
    private String mensaje;
    private List<Zone> listaZona;
    private int idZona;
    private Zone zonaAlerta;
    private Employe personal;

    public MensajeJSON() {
    }
    
    public MensajeJSON(String nombreMensaje, String mensaje) {
        this.nombreMensaje = nombreMensaje;
        this.mensaje = mensaje;
    }

    public MensajeJSON(String nombreMensaje, String mensaje, List<Zone> listaZona) {
        this.nombreMensaje = nombreMensaje;
        this.mensaje = mensaje;
        this.listaZona = listaZona;
    }

    public MensajeJSON(String nombreMensaje, String mensaje, int idZona) {
        this.nombreMensaje = nombreMensaje;
        this.mensaje = mensaje;
        this.idZona = idZona;
    }

    public MensajeJSON(String nombreMensaje, String mensaje, Zone zonaAlerta) {
        this.nombreMensaje = nombreMensaje;
        this.mensaje = mensaje;
        this.zonaAlerta = zonaAlerta;
    }

    public MensajeJSON(String nombreMensaje, Employe personal) {
        this.nombreMensaje = nombreMensaje;
        this.personal = personal;
    }

    public Employe getPersonal() {
        return personal;
    }

    public void setPersonal(Employe personal) {
        this.personal = personal;
    }
    
    

    public Zone getZonaAlerta() {
        return zonaAlerta;
    }

    public void setZonaAlerta(Zone zonaAlerta) {
        this.zonaAlerta = zonaAlerta;
    }

    public List<Zone> getListaZona() {
        return listaZona;
    }

    public void setListaZona(List<Zone> listaZona) {
        this.listaZona = listaZona;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreMensaje() {
        return nombreMensaje;
    }

    public void setNombreMensaje(String nombreMensaje) {
        this.nombreMensaje = nombreMensaje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nombreMensaje);
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
        final MensajeJSON other = (MensajeJSON) obj;
        if (!Objects.equals(this.nombreMensaje, other.nombreMensaje)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MensajeJSON{" + "nombreMensaje=" + nombreMensaje + ", mensaje=" + mensaje + '}';
    }
    
    

}
