/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

//import enums.EnumClass;
import exceptions.PersistenciaException;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import objetosNegocio.*;
//import enums.*;

/**
 *
 * @author QUINTERO
 */
public class Movies extends Table {

    public Movies() {
        super();
    }

//    public Movie searchMovie(int movie) throws PersistenciaException {
//        Movie result = null;
//        ResultSet renglon;
//        String sql = "{ call sp_searchMovie (?) }";
////        Image image = null;
//        try {
//            initSearch(sql);
//            sentence.setInt("idm", movie);
//            executeSearch();
//            if ((renglon = obtenRenglon()) != null) {
//                result = new Movie(
//                        renglon.getInt(1),
//                        renglon.getString(2),
//                        renglon.getString(3),
//                        renglon.getString(4),
//                        renglon.getDate(5),
//                        renglon.getString(6),
//                        renglon.getString(7),
//                        renglon.getString(8),
//                        renglon.getString(9),
//                        renglon.getString(10),
//                        renglon.getInt(12));
//            }
//
//            close();
//        } catch (PersistenciaException | SQLException ex) {
//            Logger.getLogger(Movies.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
}
