/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.MapCoords;
import com.bluecode.businessObjects.Position;
import com.bluecode.businessObjects.Role;
import com.bluecode.businessObjects.Zone;
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
                        new Zone(renglon.getInt(4)),
                        null,
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

    public Employe getPersonal(int idPersonal) throws PersistenciaException {
        Employe employe = null;
        ResultSet renglon;
        String sql = "call sp_getPersonalById (" + idPersonal + ");";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
//                (int id, String nombre, String dispositivo, Zone zone, Position position, Role role)
                employe = new Employe(
                        renglon.getInt(1),
                        renglon.getString(2),
                        renglon.getString(3),
                        null,
                        new Position(renglon.getInt(4)),
                        null
                );
                close();
                return employe;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return employe;
    }
    
        public int getRolPersonal(int idPersonal) throws PersistenciaException {
        int rol = 0;
        ResultSet renglon;
        String sql = "call sp_getRolPersonal (" + idPersonal + ");";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
//                (int id, String nombre, String dispositivo, Zone zone, Position position, Role role)
//                role = new Role(
//                        renglon.getInt(1),
//                        renglon.getString(2),
//                        ""
//                );
                close();
                rol = renglon.getInt(2);
                return rol;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return rol;
    }

    public Role getRol(int idRol) throws PersistenciaException {
        Role role = null;
        ResultSet renglon;
        String sql = "call sp_getRol (" + idRol + ");";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
//                (int id, String nombre, String dispositivo, Zone zone, Position position, Role role)
                role = new Role(
                        renglon.getInt(1),
                        renglon.getString(2),
                        ""
                );
                close();
                return role;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return role;
    }

    public Position getPuesto(int idPuesto) throws PersistenciaException {
        Position position = null;
        ResultSet renglon;
        String sql = "call sp_getPosition (" + idPuesto + ");";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
//                (int id, String nombre, String dispositivo, Zone zone, Position position, Role role)
                position = new Position(
                        renglon.getInt(1),
                        renglon.getString(2),
                        renglon.getString(2)
                );
                close();
                return position;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return position;
    }

}
