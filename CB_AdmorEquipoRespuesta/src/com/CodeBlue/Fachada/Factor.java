/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CodeBlue.Fachada;

/**
 *
 * @author Ithzell
 */
public enum Factor {
    PROXIMITY ("Proximidad al área de emergencia", 0.5),
    RESPONSE_TEAM ("Pertenece al equipo base", 0.1),
    AVAILABLE ("Está disponible", 0.4);
    
    private String description;
    private double value;
    
    private Factor(String description, double value){
        this.description = description;
        this.value = value;
    }
    
    public String getDescription(){
        return description;
    }
    
    public double getValue(){
        return value;
    }
    
}
