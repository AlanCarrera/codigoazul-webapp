/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import com.bluecode.businessObjects.Position;
import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.MapCoords;
import exceptions.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laser Marker
 */
public class Employes extends Table {

    public Employes() {
        super();
    }

    public List<Employe> getEmployeAll() throws PersistenciaException {
        List<Employe> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_searchEmployesAll ();";
        try {
            consulta(sql);
            //int id, String nombre, int dispositivo, Zone zone, Position position, Role role
            while ((renglon = obtenRenglon()) != null) {
                Employe employe;
                employe = new Employe(
                        renglon.getInt(1), 
                        renglon.getString(2),
                        renglon.getString(3),
                        null,
                        new Position(renglon.getInt(4)),
                        null
                );
                listResult.add(employe);

            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }
    
       public List<Employe> getTeamResponse() throws PersistenciaException {
        List<Employe> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_getTeamResponse ();";
        try {
            consulta(sql);
            //int id, String nombre, int dispositivo, Zone zone, Position position, Role role
            while ((renglon = obtenRenglon()) != null) {
                Employe employe;
                employe = new Employe(
                        renglon.getInt(2), 
                        null,
                        null,
                        null,
                        new Position(renglon.getInt(4)),
                        null
                );
                listResult.add(employe);

            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }
    
}
