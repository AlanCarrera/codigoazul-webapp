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
public class Zones extends Table {

    public Zones() {
        super();
    }

    public List<Zone> getZoneAll() throws PersistenciaException {
        List<Zone> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_getZoneAll ();";
        try {
            consulta(sql);
            while ((renglon = obtenRenglon()) != null) {
//                (int id, int area, String name, double xesi, double yesi, double xeid, double yeid)
                Zone zone = new Zone(
                        renglon.getInt(1), 
                        renglon.getInt(2), 
                        renglon.getString(3),
                        renglon.getDouble(4),
                        renglon.getDouble(5),
                        renglon.getDouble(6),
                        renglon.getDouble(7)
                );
                listResult.add(zone);
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }
    
        public Zone getZoneByEmploye(int idEmploye) throws PersistenciaException {
        Zone zone = null;
        ResultSet renglon;
        String sql = "call sp_getZoneByEmploye (" + idEmploye + ");";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
//                (int id, int area, String name, double xesi, double yesi, double xeid, double yeid)
                zone = new Zone(
                        renglon.getInt(1), 
                        renglon.getInt(2), 
                        renglon.getString(3),
                        renglon.getDouble(4),
                        renglon.getDouble(5),
                        renglon.getDouble(6),
                        renglon.getDouble(7)
                );
                close();
                return zone;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return zone;
    }
    
}
