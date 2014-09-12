/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.CodeBlue.Excepciones;

/**
 * Esta clase representa a las excepciones lanzadas por las
 * clases FachadaAdmorPersonal y envuelve a las excepciones lanzadas por
 * las clases que encapsulan los DAOs.
 *
 * @author mdomitsu
 */
public class AdmorPersonalException extends RuntimeException {

  /**
   * Constructor por omision. Construye una excepcion con un mensaje de error
   * nulo.
   */
  public AdmorPersonalException() {
  }

  /**
   * Construye una excepcion con el mensaje de error del parametro.
   * @param msj Mensaje de error.
   */
  public AdmorPersonalException(String msj) {
    super(msj);
  }

  /**
   * Construye una excepcion con el mensaje de error del parametro y la causa
   * original del error.
   * @param msj Mensaje de error.
   * @param causa Causa original del error.
   */
  public AdmorPersonalException(String msj, Throwable causa) {
    super(msj, causa);
  }

  /**
   * Construye una excepcion la causa original del error.
   * @param causa Causa original del error.
   */
  public AdmorPersonalException(Throwable causa) {
    super(causa);
  }
}

