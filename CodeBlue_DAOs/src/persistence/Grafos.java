/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.bluecode.businessObjects.Grafo;
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
public class Grafos extends Table {

    public Grafos() {
        super();
    }

    public double getFactorGrafo(int idZonaOrig, int idZonaDest) throws PersistenciaException {
        double factor = 0;
        ResultSet renglon;
        String sql = "call sp_getFactorGrafo (" + idZonaOrig + "," + idZonaDest + ");";
        try {
            consulta(sql);
            if ((renglon = obtenRenglon()) != null) {
                factor = renglon.getDouble(5);
                close();
                return factor;
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return factor;
    }
    
     public List<Grafo> getListaGrafos() throws PersistenciaException {
        List<Grafo> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_getListaGrafos ();";
        try {
            consulta(sql);
            while ((renglon = obtenRenglon()) != null) {
//                (int idGrafo, int idZonaOrig, int idZonaDest, double distancia, double factor, int adyacencia)
                Grafo grafo = new Grafo(
                        renglon.getInt(1),
                        renglon.getInt(2),
                        renglon.getInt(3),
                        renglon.getDouble(4),
                        renglon.getDouble(5),
                        renglon.getInt(6)
                );
                listResult.add(grafo);
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }


}
