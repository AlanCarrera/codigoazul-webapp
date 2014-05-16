/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.MapCoords;
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

}
