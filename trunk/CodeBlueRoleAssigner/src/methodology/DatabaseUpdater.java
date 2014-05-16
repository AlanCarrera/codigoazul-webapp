/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodology;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import jpa.controller.EquipoRespuestaJpaController;
import jpa.entities.EquipoBase;
import jpa.entities.EquipoRespuesta;

/**
 *
 * @author Adrian
 */
public class DatabaseUpdater {
    
    private EntityManagerFactory objFactory;
    
    public DatabaseUpdater(EntityManagerFactory objFactory){
        this.objFactory = objFactory;
    }

    protected EquipoRespuesta convertToEquipoRespuesta(EquipoBase selectedStaff, int id) {
        EquipoRespuesta equipoRespuesta = new EquipoRespuesta();
        equipoRespuesta.setIdEquipoRespuesta(id);
        equipoRespuesta.setIdPersonal(selectedStaff.getIdPersonal());
        equipoRespuesta.setIdRol(selectedStaff.getIdRol());
        equipoRespuesta.setIdZona(selectedStaff.getIdZona());

        return equipoRespuesta;
    }

    protected void updateDatabase(EquipoRespuesta selectedStaff) {        
        EquipoRespuestaJpaController equipoRespuestaController = new EquipoRespuestaJpaController(objFactory);
        try {
            equipoRespuestaController.create(selectedStaff);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
