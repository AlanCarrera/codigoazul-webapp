/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.BlueCode.Interfaces;

import com.BlueCode.Excepciones.AdmorPlanosException;
import com.bluecode.businessObjects.Map;
import java.util.List;

/**
 * Esta interfas especifica que es lo que realiza el administrador de planos, ademas de
 * encapsular dicho comportamiento de las clases que la implementan.
 * 
 * @author Jesus Quintero Gutierrez 
 * @proyecto Codigo Azul
 * @asesor M. en C. Manuel Domitsu Kono 
 */
public interface IAdmorPlanos {
    
    /**
     * Este metedo devuelve todos los planos del hospital.
     * 
     * @return la lista de planos, null en caso contrario.
     * @throws AdmorPlanosException lanza un error ocurrido en el Administrador de planos.
     */
    public List<Map> getPlanos() throws AdmorPlanosException;
    
    /**
     * Este metodo devuelve todos los planos del hospital con las dimensiones de sus corrdenadas modificadas,
     * es decir, podemos modificar la dimension de sus coordenadas asignadole algun valor, ya que las dimensiones
     * establecidas en la base de datos estan en METROS, con este metodo podemos hacer la converison a cualquier
     * otro.
     * 
     * @param dimension mayor a cero, 1 mantendra la dimension sin modificar, menor que 1 reduciremos la dimension
     *                  y mayor a 1 aumentaremos la dimension de los planos.
     * @return devuelve la lista de los planos, null en caso contraio.
     * @throws AdmorPlanosException lanza un error ocurrido en el Administrador de planos.
     */
    public List<Map> setPlanosDomensionCoordendas(double dimension) throws AdmorPlanosException;
    
}
