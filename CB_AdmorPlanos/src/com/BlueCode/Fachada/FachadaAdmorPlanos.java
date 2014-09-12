/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BlueCode.Fachada;

import Control.Control;
import Interfaces.IDAOs;
import com.BlueCode.Excepciones.AdmorPlanosException;
import com.BlueCode.Interfaces.IAdmorPlanos;
import com.bluecode.businessObjects.Map;
import exceptions.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase es la responsalbe en administrar todas las transacciones
 * relacionadas con los planos del hospital y ademas contiene la logica del
 * negocio.
 *
 * @author Jesus Quintero Gutierrez
 * @proyecto Codigo Azul
 * @asesor M. en C. Manuel Domitsu Kono
 */
public class FachadaAdmorPlanos implements IAdmorPlanos {

    //Atributos
    private IDAOs fachadaDAOs;

    public FachadaAdmorPlanos() {
        this.fachadaDAOs = new Control();
    }

    /**
     * Este metedo devuelve todos los planos del hospital.
     *
     * @return la lista de planos, null en caso contrario.
     * @throws AdmorPlanosException lanza un error ocurrido en el Administrador
     * de planos.
     */
    @Override
    public List<Map> getPlanos() throws AdmorPlanosException {
        try {
            return fachadaDAOs.getMapAll();
        } catch (PersistenciaException ex) {
            System.err.println("Error: No se puede obtener la lista de planos, "
                    + " FachadaaAdmorPlanos.getPlanos()");
            Logger.getLogger(FachadaAdmorPlanos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Map> setPlanosDomensionCoordendas(double dimension) throws AdmorPlanosException {
        List<Map> maps = getPlanos();
        if (dimension <= 0) {
            throw new AdmorPlanosException("Error: No se puede dimensionr el plano, la dimension debe ser mayor a 0,"
                    + " no se permiten numeros negativos.");
        }
        for (int i = 0; i < maps.size(); i++) {
                for (int j = 0; j < maps.get(i).getCoordenadas().size(); j++) {
                    maps.get(i).getCoordenadas().get(j).setX((maps.get(i).getCoordenadas().get(j).getX() * dimension));
                    System.out.println(maps.get(i).getCoordenadas().get(j).getX() * dimension);
                    maps.get(i).getCoordenadas().get(j).setY((maps.get(i).getCoordenadas().get(j).getY() * dimension));
                    System.out.println(maps.get(i).getCoordenadas().get(j).getY() * dimension);
                }
            }
        return maps;
    }

}
