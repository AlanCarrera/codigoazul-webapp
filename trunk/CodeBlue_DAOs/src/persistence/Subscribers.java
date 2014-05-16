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
import java.util.logging.Level;
import java.util.logging.Logger;
//import objetosNegocio.City;
//import objetosNegocio.Subscriber;

/**
 *
 * @author QUINTERO
 */
public class Subscribers extends Table {

    public Subscribers() {
        super();
    }

//    public Subscriber searchSubscriber() throws PersistenciaException{
//       Subscriber subs = null;
//       ResultSet renglon;
//       String sql = "call sp_searchSubscriber();";
//       try{
//       consulta(sql);
//       }catch(SQLException e){
//           throw new PersistenciaException("Error al iniciar la consulta: ",e.getCause());
//       }
//       if((renglon= obtenRenglon())!= null){
//           try {
//                    subs = new Subscriber(renglon.getInt(1),renglon.getString(2),renglon.getString(3));
//           return subs;
//           } catch (SQLException sqle) {
//               throw new PersistenciaException("no se pudo obtener usuario de la BD",sqle);
//           }
//       }
//       return subs;
//    }
//    public List<Subscriber> searchSubscribersByCity(int city) throws PersistenciaException {
//        List<Subscriber> list = new ArrayList();
//        ResultSet renglon;
//        String sql = "{ call sp_searchSubscribersByCity (?) }";
//        System.out.println(sql);
//        try {
//            initSearch(sql);
//            sentence.setInt("id", city);
//            executeSearch();
//            while ((renglon = obtenRenglon()) != null) {
////                   (int id, String firstName, String secondName, String email, 
////                    String address, String cityHall, City city, String phone, 
////                   String type, int status, String company, List<Location> locations)
//                Subscriber ciudades = new Subscriber(
//                        renglon.getInt(1),
//                        renglon.getString(2),
//                        renglon.getString(3),
//                        renglon.getString(4),
//                        renglon.getString(5),
//                        renglon.getString(6),
//                        new City(renglon.getInt(7), ""),
//                        renglon.getString(8),
//                        renglon.getString(9),
//                        renglon.getInt(11),
//                        renglon.getString(10),
//                        null);
//                list.add(ciudades);
//            }
//            close();
//        } catch (SQLException e) {
//            close();
//            Logger.getLogger(Subscribers.class.getName()).log(Level.SEVERE, null, e);
//            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
//        }
//        return list;
//    }
}
