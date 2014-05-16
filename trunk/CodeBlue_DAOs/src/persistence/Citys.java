/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import exceptions.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import objetosNegocio.City;

/**
 *
 * @author QUINTERO
 */
public class Citys extends Table {

    public Citys() {
        super();
    }

//    public City buscaCiudad(int ciudad) throws PersistenciaException {
//        City city = null;
//        ResultSet renglon;
//        String sql = "call sp_searchCityById(" + ciudad + ");";
//        try {
//            consulta(sql);
//            if ((renglon = obtenRenglon()) != null) {
//                city = new City(renglon.getInt(1), renglon.getString(2));
//                return city;
//            }
//        } catch (SQLException sqle) {
//            close();
//            throw new PersistenciaException("no se pudo obtener usuario de la BD", sqle);
//        }
//        close();
//        return city;
//    }

//    public List<City> searchCitys() throws PersistenciaException {
//        List<City> list = new ArrayList();
//        ResultSet renglon;
//        String sql = "call sp_searchCitys ();";
//        try {
//            consulta(sql);
//            while ((renglon = obtenRenglon()) != null) {
//                    City ciudad = new City(
//                            renglon.getInt(1),
//                            renglon.getString(2));
//                    list.add(ciudad);
//                
//            }
//            close();
//        } catch (SQLException e) {
//            close();
//            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
//        }
//        return list;
//    }
}
