/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.bluecode.businessObjects.Equipo;
import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.MapCoords;
import com.bluecode.businessObjects.RolPersonal;
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
public class Teams extends Table {

    public Teams() {
        super();
    }

    public void updateCharacterOnZone(int idemploye, int idzona) throws PersistenciaException {
        List<Map> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_updateCharacterOnZone (" + idemploye + "," + idzona + ");";
        try {
            consulta(sql);
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
    }

    public int getIdZoneByEmploye(int idEmploye) throws PersistenciaException {
        int id = -1;
        ResultSet renglon;
        String sql = "call sp_getIdZoneByEmploye (" + idEmploye + ");";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
                id = renglon.getInt(1);
                close();
                return id;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return id;
    }

    public List<Equipo> getListaEquipoRol(int idRol) throws PersistenciaException {
        List<Equipo> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_getListaEquipoRol (" + idRol + ");";
        try {
            consulta(sql);
            //int id, String nombre, int dispositivo, Zone zone, Position position, Role role
            while ((renglon = obtenRenglon()) != null) {
                Equipo equipo = new Equipo(
                        renglon.getInt(1),
                        renglon.getInt(2),
                        renglon.getInt(3),
                        renglon.getInt(4),
                        renglon.getInt(5)
                );
                listResult.add(equipo);

            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }

    public void eliminarEquipoBase() throws PersistenciaException {
        String sql = "call sp_eliminarEquipoBase ();";
        try {
            consulta(sql);
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
    }

    public boolean agregarEquipoRespuesta(List<Equipo> equipoBase) throws PersistenciaException {
        int index = -1;
        try {
            for (Equipo personal : equipoBase) {
                String sql = "call sp_agregarEquipoRespuesta ("
                        + (index++) + ","
                        + personal.getIdPersonal() + ","
                        + personal.getIdRol() +","
                        + personal.getIdZona() +");";
                consulta(sql);
            }
            close();
            return true;
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
    }

}
