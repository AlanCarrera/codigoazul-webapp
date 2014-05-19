/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package methodology;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpa.entities.EquipoBase;
import jpa.entities.EquipoRespuesta;
import jpa.entities.Roles;
import jpa.entities.Zonas;

/**
 *
 * @author Ithzell
 */
public class MethodologyApplier {
    
    private Zonas codeBlueLocation;
    private RoleAssigner roleAssigner;
    private DatabaseUpdater databaseUpdater;
    
    public MethodologyApplier(String zone){
        int idZone = Integer.parseInt(zone);
        codeBlueLocation = new Zonas();
        codeBlueLocation.setIdZona(idZone);
        
        roleAssigner = new RoleAssigner(codeBlueLocation);
        databaseUpdater = new DatabaseUpdater(roleAssigner.getObjFactory());
        
    }
    
    public MethodologyApplier(Zonas zone){
        codeBlueLocation = zone;
        roleAssigner = new RoleAssigner(codeBlueLocation);
        databaseUpdater = new DatabaseUpdater(roleAssigner.getObjFactory());
    }
    
    public List<EquipoBase> formResponseTeam(){
        List<Roles> roleList = roleAssigner.getRoles();
        List<EquipoBase> baseTeam = new ArrayList<>();
        
        for (Roles rol : roleList) {
            baseTeam.add(roleAssigner.qualitativeMethod(rol));            
        }
        
        updateDatabase(baseTeam);
        
        return baseTeam;
    }
    
    public List<EquipoRespuesta> convertToResponseTeam(List<EquipoBase> baseTeam){
        int id = 0;
        List<EquipoRespuesta> responseTeam = new ArrayList<>();
        
        for (EquipoBase staff : baseTeam) {
            responseTeam.add(databaseUpdater.convertToResponseTeam(staff, id));
            id++;
        }
        
        return responseTeam;
    }
    
    public void updateDatabase(List<EquipoBase> baseTeam){        
        databaseUpdater.deleteResponseTeam();
        
        List<EquipoRespuesta> responseTeam = convertToResponseTeam(baseTeam);
        
        for (EquipoRespuesta staff : responseTeam) {
            databaseUpdater.updateDatabase(staff);
        }
    }
}
