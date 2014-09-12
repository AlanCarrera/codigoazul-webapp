/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.BlueCode.Excepciones;

/**
 * Esta clase representa a las excepciones lanzadas por las
 * clases FachadaAdmorPlanos y envuelve a las excepciones lanzadas por
 * las clases que encapsulan los DAOs.
 *
 * @author mdomitsu
 */
public class AdmorPlanosException extends RuntimeException {

  /**
   * Constructor por omision. Construye una excepcion con un mensaje de error
   * nulo.
   */
  public AdmorPlanosException() {
  }

  /**
   * Construye una excepcion con el mensaje de error del parametro.
   * @param msj Mensaje de error.
   */
  public AdmorPlanosException(String msj) {
    super(msj);
  }

  /**
   * Construye una excepcion con el mensaje de error del parametro y la causa
   * original del error.
   * @param msj Mensaje de error.
   * @param causa Causa original del error.
   */
  public AdmorPlanosException(String msj, Throwable causa) {
    super(msj, causa);
  }

  /**
   * Construye una excepcion la causa original del error.
   * @param causa Causa original del error.
   */
  public AdmorPlanosException(Throwable causa) {
    super(causa);
  }
}
