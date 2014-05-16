/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import com.bluecode.businessObjects.Map;
import com.bluecode.businessObjects.MapCoords;
import exceptions.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QUINTERO
 */
public class Maps extends Table {

    public Maps() {
        super();
    }

    public List<Map> getMapsAll() throws PersistenciaException {
        List<Map> listResult = new ArrayList<>();
        ResultSet renglon;
        String sql = "call sp_searchMapsAll ();";
        try {
            consulta(sql);
            while ((renglon = obtenRenglon()) != null) {
                Map map = new Map(
                        renglon.getInt(1), 
                        renglon.getString(2), 
                        null
                );
                listResult.add(map);

            }
            //
            for (int i = 0; i < listResult.size(); i++) {
                List<MapCoords> listCoords = new ArrayList<>();
                sql = "{ call sp_searchMapPointsAll(?) }";
                initSearch(sql);
                sentence.setInt("idm", listResult.get(i).getId());
                executeSearch();
                while ((renglon = obtenRenglon()) != null) {
                    MapCoords mapCoords = new MapCoords(
                            renglon.getDouble(3),
                            renglon.getDouble(4)
                    );
                    listCoords.add(mapCoords);
                }
                listResult.get(i).setCoordenadas(listCoords);
            }
            close();
        } catch (SQLException e) {
            close();
            throw new PersistenciaException("Error de conexion de base de datos", e.getCause());
        }
        return listResult;
    }

}
