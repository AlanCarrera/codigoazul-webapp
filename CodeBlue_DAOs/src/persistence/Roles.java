/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persistence;

import com.bluecode.businessObjects.Employe;
import com.bluecode.businessObjects.Position;
import com.bluecode.businessObjects.RolPersonal;
import com.bluecode.businessObjects.Role;
import exceptions.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laser Marker
 */
public class Roles extends Table{
    
    public Roles(){
        super();
    }
    
    public List<RolPersonal> getListaRolesPersonal() throws PersistenciaException {
        List<RolPersonal> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_getListaRolesPersonal ();";
        try {
            consulta(sql);
            //int id, String nombre, int dispositivo, Zone zone, Position position, Role role
            while ((renglon = obtenRenglon()) != null) {
                RolPersonal rolPersonal = new RolPersonal(
                        renglon.getInt(1),
                        renglon.getInt(2)
                );
                listResult.add(rolPersonal);

            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }
    
    public List<RolPersonal> getRolesEquipoCB() throws PersistenciaException {
        List<RolPersonal> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_getRolesEquipoCB ();";
        try {
            consulta(sql);
            //int id, String nombre, int dispositivo, Zone zone, Position position, Role role
            while ((renglon = obtenRenglon()) != null) {
                RolPersonal rolPersonal = new RolPersonal(
                        renglon.getInt(1),
                        renglon.getString(2)
                );
                listResult.add(rolPersonal);

            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }
    
}
