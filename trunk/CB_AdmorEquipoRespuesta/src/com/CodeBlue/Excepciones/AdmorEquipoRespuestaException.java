/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CodeBlue.Excepciones;

/**
 *
 * @author Laser Marker
 */
public class AdmorEquipoRespuestaException extends RuntimeException {

  /**
   * Constructor por omision. Construye una excepcion con un mensaje de error
   * nulo.
   */
  public AdmorEquipoRespuestaException() {
  }

  /**
   * Construye una excepcion con el mensaje de error del parametro.
   * @param msj Mensaje de error.
   */
  public AdmorEquipoRespuestaException(String msj) {
    super(msj);
  }

  /**
   * Construye una excepcion con el mensaje de error del parametro y la causa
   * original del error.
   * @param msj Mensaje de error.
   * @param causa Causa original del error.
   */
  public AdmorEquipoRespuestaException(String msj, Throwable causa) {
    super(msj, causa);
  }

  /**
   * Construye una excepcion la causa original del error.
   * @param causa Causa original del error.
   */
  public AdmorEquipoRespuestaException(Throwable causa) {
    super(causa);
  }
    
}
