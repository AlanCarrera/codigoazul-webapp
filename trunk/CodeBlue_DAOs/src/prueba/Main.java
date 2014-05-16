/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

import Control.Control;
import Interfaces.IDAOs;
import com.bluecode.businessObjects.Map;
import exceptions.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import objetosNegocio.BillBoard;
//import objetosNegocio.City;
import persistence.BillBoards;
import persistence.Conexion;

/**
 *
 * @author labcisco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
//                        Conexion conexion = new Conexion("jdbc:mysql://10.1.4.33:3306/codigo_azul", "userCodigoAzul", "codigoazul");
//                        Maps maps =
//                        bbs.setConnection(conexion.getConexion());
                    
                        IDAOs daos = new Control();
                        List<Map> ciudades = daos.getMapAll();
                        for(Map city: ciudades){
                            System.out.println(city.toString());
                        }
        } catch (PersistenciaException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
