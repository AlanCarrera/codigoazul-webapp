/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodology;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import jpa.controller.EquipoRespuestaJpaController;
import jpa.controller.exceptions.NonexistentEntityException;
import jpa.entities.EquipoBase;
import jpa.entities.EquipoRespuesta;

/**
 *
 * @author Adrian
 */
public class DatabaseUpdater {

    private EntityManagerFactory objFactory;
    private EquipoRespuestaJpaController responseTeamController;

    public DatabaseUpdater(EntityManagerFactory objFactory) {
        this.objFactory = objFactory;
        responseTeamController = new EquipoRespuestaJpaController(objFactory);
    }

    protected EquipoRespuesta convertToResponseTeam(EquipoBase selectedStaff, int id) {
        EquipoRespuesta equipoRespuesta = new EquipoRespuesta();
        equipoRespuesta.setIdEquipoRespuesta(id);
        equipoRespuesta.setIdPersonal(selectedStaff.getIdPersonal());
        equipoRespuesta.setIdRol(selectedStaff.getIdRol());
        equipoRespuesta.setIdZona(selectedStaff.getIdZona());

        return equipoRespuesta;
    }

    protected void updateDatabase(EquipoRespuesta selectedStaff) {
        try {
            responseTeamController.create(selectedStaff);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void deleteResponseTeam() {
        List<EquipoRespuesta> responseTeamList = responseTeamController.findEquipoRespuestaEntities();
        
        for (EquipoRespuesta staff : responseTeamList) {
            try {
                responseTeamController.destroy(staff.getIdEquipoRespuesta());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(DatabaseUpdater.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
