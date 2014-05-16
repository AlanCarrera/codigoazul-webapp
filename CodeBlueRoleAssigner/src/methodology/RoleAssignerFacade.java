/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package methodology;

import java.util.ArrayList;
import java.util.List;
import jpa.entities.EquipoBase;
import jpa.entities.Roles;
import jpa.entities.Zonas;

/**
 *
 * @author Ithzell
 */
public class RoleAssignerFacade {
    
    private Zonas codeBlueLocation;
    private RoleAssigner roleAssigner;
    
    public RoleAssignerFacade(Zonas zone){
        codeBlueLocation = zone;
        roleAssigner = new RoleAssigner(zone);
    }
    
    public List<EquipoBase> formResponseTeam(){
        List<Roles> roleList = roleAssigner.getRoles();
        List<EquipoBase> responseTeam = new ArrayList<>();
        
        for (Roles rol : roleList) {
            responseTeam.add(roleAssigner.qualitativeMethod(rol));            
        }
        
        return responseTeam;
    }
}
