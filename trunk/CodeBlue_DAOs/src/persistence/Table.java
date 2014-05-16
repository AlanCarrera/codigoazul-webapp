/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import exceptions.PersistenciaException;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan
 */
public class Table {

    protected Connection connection;
    protected CallableStatement sentence;
    private ResultSet response;

    public Table() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public void initSearch(String sql) throws PersistenciaException, SQLException {
        try {
            sentence = (CallableStatement) connection.prepareCall(sql);
        } catch (SQLException se) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, se);
            throw new PersistenciaException("no se pudo consultar la BD", se);
        }

    }
    
    public void executeSearch() throws PersistenciaException, SQLException {
        try {
            response = sentence.executeQuery();
        } catch (SQLException se) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, se);
            System.out.println(se.getMessage());
            throw new PersistenciaException("no se pudo consultar la BD", se);
            
        }

    }

    protected void consulta(String sql) throws PersistenciaException, SQLException {
        try {
            sentence = (CallableStatement) connection.prepareCall(sql);
            response = sentence.executeQuery(sql);
        } catch (SQLException se) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, se);
            throw new PersistenciaException("no se pudo consultar la BD", se);
        }

    }

    protected ResultSet obtenRenglon() throws PersistenciaException {
        try {
            if (response.next()) {
                return response;
            } else {
                response.close();
                sentence.close();
                return null;
            }
        } catch (SQLException se) {
            throw new PersistenciaException("no se pudo consultar la base de datos", se);
        }
    }

    protected void actualiza(String sql) throws PersistenciaException {
        try {
            sentence = (CallableStatement) connection.prepareCall(sql);
            int i = sentence.executeUpdate(sql);
//            sentence.close();
        } catch (SQLException se) {
            throw new PersistenciaException("no se pudo consultar la base de datos", se);
        }
    }

    protected void close() throws PersistenciaException {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
