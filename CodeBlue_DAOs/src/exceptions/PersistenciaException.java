/*
 * PersistenciaException.java
 */
package exceptions;

/**
 * clase de Excepcion. Clase que representa un error en la capa de datos.
 * @author Alan
 */
public class PersistenciaException extends Exception{
    /**
     * Constructor vacio. incia la clase padre
     */
    public PersistenciaException(){
        super();
    }
    /**
     * Constructor. recibe un mensaje de error
     * @param msj el mensaje de error
     */
    public PersistenciaException(String msj){
        super(msj);
    }
    /**
     * Constructor. recibe un mensaje de error y la causa del error.
     * @param msj el mensaje de error
     * @param causa la causa del error
     */
    public PersistenciaException(String msj, Throwable causa) {
        super(msj,causa);
    }
/**
 * Constructor. recibe una causa del error.
 * @param causa la causa del error.
 */
    public PersistenciaException(Throwable causa) {
        super(causa);
    }
}
