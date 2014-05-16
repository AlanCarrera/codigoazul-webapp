/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

//import enums.EnumUser;
import exceptions.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import objetosNegocio.*;

/**
 *
 * @author QUINTERO
 */
public class Schedules extends Table{

    public Schedules() {
    }
    
//    public List<Schedule> searchSchedulesByBillboard(int billboard) throws PersistenciaException {
//        List<Schedule> list = new ArrayList();
//        ResultSet renglon;
//        String sql = "{ call searchSchedulesByBillboard (?) }";
//        System.out.println(sql);
//        try {
//            initSearch(sql);
//            sentence.setInt("id", billboard);
//            executeSearch();
//            while ((renglon = obtenRenglon()) != null) {
////                   ((int id, Movie movie, String type, List<String> schedules, String language, int room)
//                List<String> hoursList = new ArrayList<>();
//                String hours[] = renglon.getString(4).split(",");
//                hoursList.addAll(Arrays.asList(hours));
//                Schedule schedule = new Schedule(
//                        renglon.getInt(1), 
//                        new Movie(renglon.getInt(2)), 
//                        renglon.getString(3), 
//                        hoursList, 
//                        renglon.getString(5), 
//                        renglon.getInt(6));
//                list.add(schedule);
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
