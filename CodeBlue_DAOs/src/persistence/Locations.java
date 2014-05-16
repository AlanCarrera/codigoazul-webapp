/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import displays.Subscriber_Locations;
import exceptions.PersistenciaException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import objetosNegocio.BillBoard;
//import objetosNegocio.Location;
//import objetosNegocio.City;
//import objetosNegocio.Subscriber;

/**
 *
 * @author QUINTERO
 */
public class Locations extends Table {

    public Locations() {
        super();
    }

//    public List<Location> searchLocationsByCity(int subscriber, int city) throws PersistenciaException {
//        List<Location> list = new ArrayList();
//        ResultSet renglon;
//        String sql = "{ call sp_searchLocationsByUserAndCity(?, ?) }";
//        try {
//            initSearch(sql);
//            sentence.setInt("ids", subscriber);
//            sentence.setInt("idc", city);
//            executeSearch();
//            while ((renglon = obtenRenglon()) != null) {
//                Location location = new Location(
//                        renglon.getInt(1),
//                        renglon.getString(2),
//                        renglon.getString(3),
//                        renglon.getString(4),
//                        new City(renglon.getInt(5)),
//                        new BillBoard(renglon.getInt(7)));
//                list.add(location);
//
//            }
//            close();
//
//        } catch (SQLException e) {
//            close();
//            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
//        }
//        return list;
//    }
//    
//    public List<Subscriber_Locations> searchSubscriberLocations(int subscriber) throws PersistenciaException {
//        List<Subscriber_Locations> list = new ArrayList();
//        ResultSet renglon;
//        String sql = "{ call sp_searchLocationsByUser(?) }";
//        try {
//            initSearch(sql);
//            sentence.setInt("ids", subscriber);
//            executeSearch();
//            while ((renglon = obtenRenglon()) != null) {
//                Subscriber_Locations location = new Subscriber_Locations(
//                        renglon.getInt(1),
//                        renglon.getInt(2));
//                list.add(location);
//
//            }
//            close();
//
//        } catch (SQLException e) {
//            close();
//            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
//        }
//        return list;
//    }
}
