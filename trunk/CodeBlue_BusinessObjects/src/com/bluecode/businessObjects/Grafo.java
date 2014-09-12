/*
 * Grafo.java
 */

package com.bluecode.businessObjects;

/**
 *
 * @author Manuel Domitsu
 */
public class Grafo {
    private int idGrafo;
    private int idZonaOrig;
    private int idZonaDest;
    private int adyacencia;
    private double distancia;
    private double factor;

    public Grafo(int idGrafo, int idZonaOrig, int idZonaDest, double distancia, double factor, int adyacencia) {
        this.idGrafo = idGrafo;
        this.idZonaOrig = idZonaOrig;
        this.idZonaDest = idZonaDest;
        this.distancia = distancia;
        this.factor = factor;
        this.adyacencia = adyacencia;
    }

    public int getIdGrafo() {
        return idGrafo;
    }

    public void setIdGrafo(int idGrafo) {
        this.idGrafo = idGrafo;
    }

    public int getIdZonaOrig() {
        return idZonaOrig;
    }

    public void setIdZonaOrig(int idZonaOrig) {
        this.idZonaOrig = idZonaOrig;
    }

    public int getIdZonaDest() {
        return idZonaDest;
    }

    public void setIdZonaDest(int idZonaDest) {
        this.idZonaDest = idZonaDest;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idGrafo;
        return hash;
    }

    public int getAdyacencia() {
        return adyacencia;
    }

    public void setAdyacencia(int adyacencia) {
        this.adyacencia = adyacencia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grafo other = (Grafo) obj;
        return this.idGrafo == other.idGrafo;
    }

    @Override
    public String toString() {
        return "GrafoZonas{" + idGrafo + ", " + idZonaOrig + ", " 
                + idZonaDest + ", " + distancia + ", " + factor + '}';
    }
    
    
}
