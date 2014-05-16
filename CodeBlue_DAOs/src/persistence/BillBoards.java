/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import exceptions.PersistenciaException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import objetosNegocio.BillBoard;
//import objetosNegocio.City;
//import objetosNegocio.Location;
//import objetosNegocio.Schedule;

/**
 *
 * @author QUINTERO
 */
public class BillBoards extends Table {

    public BillBoards() {
        super();
    }

//    public void addBillBoard(BillBoard billBoard, Location location) throws PersistenciaException {
//        String sql = "call sp_addBillBoard ("
//                + billBoard.getId() + ", "
//                + billBoard.getDate().toString() + ", "
//                + billBoard.getStatus() + ", "
//                + location.getId() + ");";
//        System.out.println(sql);
//        try {
//            consulta(sql);
//        } catch (SQLException e) {
//            close();
//            throw new PersistenciaException("Error al agregar nuevo elemento", e.getCause());
//        }
//        close();
//    }
//
//    public void updateBillBoard(BillBoard billBoard, Location location) throws PersistenciaException {
//        String sql = "call sp_updateBillBoard ("
//                + billBoard.getId() + ", "
//                + billBoard.getDate().toString() + ", "
//                + billBoard.getStatus() + ", "
//                + location.getId() + ");";
//        System.out.println(sql);
//        try {
//            consulta(sql);
//        } catch (SQLException e) {
//            throw new PersistenciaException("Error al agregar nuevo elemento", e.getCause());
//        }
//    }
//
//    public void deleteBillBoard(BillBoard billBoard) throws PersistenciaException {
//        String sql = "call sp_deleteBillBoard ("
//                + billBoard.getId() + ");";
//        System.out.println(sql);
//        try {
//            consulta(sql);
//        } catch (SQLException e) {
//            throw new PersistenciaException("Error al agregar nuevo elemento", e.getCause());
//        }
//    }
//
//    public BillBoard searchBillboardByLocation(int location) throws PersistenciaException {
//        BillBoard bb = null;
//        ResultSet renglon;
//        String sql = "{ call sp_serachBillBoardByLocation (?) }";
//        try {
//            //BillBoard
//            initSearch(sql);
//            sentence.setInt("id", location);
//            executeSearch();
//            if ((renglon = obtenRenglon()) != null) {
//                bb = new BillBoard(
//                        renglon.getInt(1),
//                        null,
//                        renglon.getDate(2),
//                        renglon.getInt(3));
//                return bb;
//            }
//        } catch (SQLException sqle) {
//            close();
//            throw new PersistenciaException("no se pudo obtener usuario de la BD", sqle);
//        }
//        close();
//        return bb;
//    }
}
