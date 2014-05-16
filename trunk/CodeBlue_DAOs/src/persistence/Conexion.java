/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author AlanCarrera
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan
 */
public class Conexion {
    
 
    private Connection conexion;
    
    
    public Conexion(String url, String usuario,String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            conexion = (Connection) DriverManager.getConnection(url, usuario, password);
            
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    public Connection getConexion() {
        return conexion;
    }
    
    protected void close() {
        try {
            conexion.close();
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
