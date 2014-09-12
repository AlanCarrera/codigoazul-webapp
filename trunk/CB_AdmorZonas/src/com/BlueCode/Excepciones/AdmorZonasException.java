/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.BlueCode.Excepciones;

/**
 * Esta clase representa a las excepciones lanzadas por las
 * clases FachadaAdmorZonas y envuelve a las excepciones lanzadas por
 * las clases que encapsulan los DAOs.
 *
 * @author mdomitsu
 */
public class AdmorZonasException extends RuntimeException {

  /**
   * Constructor por omision. Construye una excepcion con un mensaje de error
   * nulo.
   */
  public AdmorZonasException() {
  }

  /**
   * Construye una excepcion con el mensaje de error del par�metro.
   * @param msj Mensaje de error.
   */
  public AdmorZonasException(String msj) {
    super(msj);
  }

  /**
   * Construye una excepcion con el mensaje de error del parametro y la causa
   * original del error.
   * @param msj Mensaje de error.
   * @param causa Causa original del error.
   */
  public AdmorZonasException(String msj, Throwable causa) {
    super(msj, causa);
  }

  /**
   * Construye una excepcion la causa original del error.
   * @param causa Causa original del error.
   */
  public AdmorZonasException(Throwable causa) {
    super(causa);
  }
}
