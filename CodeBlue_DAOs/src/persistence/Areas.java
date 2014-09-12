/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import com.bluecode.businessObjects.Area;
import com.bluecode.businessObjects.Zone;
import exceptions.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laser Marker
 */
public class Areas extends Table{
    
    public Areas(){
        super();
    }
    
    /**
     * Este metodo devuelve el Area a partir del nombre del Area.
     * 
     * @param nombreArea nombre del Area
     * @return devuelve un Area, null en caso contrario.
     * @throws PersistenciaException lanza  un error ocurrido en los DAOs.
     */
    public Area getAreaNombre(String nombreArea) throws PersistenciaException {
        Area area = null;
        ResultSet renglon;
        String sql = "call sp_getAreaNombre ('" + nombreArea + "');";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
                area = new Area(
                        renglon.getInt(1),
                        renglon.getString(2)
                );
                close();
                return area;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return area;
    }
}
