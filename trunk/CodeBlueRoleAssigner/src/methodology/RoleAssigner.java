/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodology;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import jpa.controller.EquipoRespuestaJpaController;
import jpa.controller.RolesJpaController;
import jpa.entities.EquipoBase;
import jpa.entities.EquipoRespuesta;
import jpa.entities.Roles;
import jpa.entities.Zonas;

/**
 *
 * @author Ithzell
 */
public class RoleAssigner {

    private Zonas codeBlueLocation;
    private EntityManagerFactory objFactory;
    private EntityManager manager;

    public RoleAssigner(Zonas codeBlueLocation) {
        this.codeBlueLocation = codeBlueLocation;

        objFactory = Persistence.createEntityManagerFactory("CodeBluePU");
        manager = objFactory.createEntityManager();
    }

    public Zonas getCodeBlueLocation() {
        return codeBlueLocation;
    }

    public void setCodeBlueLocation(Zonas codeBlueLocation) {
        this.codeBlueLocation = codeBlueLocation;
    }

    public EntityManagerFactory getObjFactory() {
        return objFactory;
    }

    protected List<Roles> getRoles() {
        RolesJpaController rolesController = new RolesJpaController(objFactory);
        List<Roles> roles = rolesController.findRolesEntities();
        return roles;
    }

    private List<EquipoBase> getEquipoBase(Roles rol) {
        Query query = manager.createNamedQuery("EquipoBase.findByRol").setParameter("rolesIdrol", rol);
        List<EquipoBase> equipoBase = query.getResultList();
        return equipoBase;
    }

    protected EquipoBase qualitativeMethod(Roles rol) {
        //search for qualifying staff
        List<EquipoBase> equipoBase = getEquipoBase(rol);

        //sums for each staff
        List<Double> sumsList = new ArrayList<>();

        //temporary sum
        double sum;
        //temporary query
        Query query;
        //temporary factor
        double factor = 0;

        for (EquipoBase personal : equipoBase) {
            query = manager.createNamedQuery("Grafos.findByFactor").setParameter("idzonaOrig", personal.getIdZona()).setParameter("idzonaDest", codeBlueLocation);
            factor = (double) query.getSingleResult();
            
            if (factor == 0){
                factor = 1;
            }

            sum = 0;

            sum += Factor.PROXIMITY.getValue() * factor;
            sum += Factor.RESPONSE_TEAM.getValue() * 10;
            if (personal.getDisponible() == true) {
                sum += Factor.AVAILABLE.getValue() * 1;
            } else if (personal.getDisponible() == false) {
                sum += Factor.AVAILABLE.getValue() * 0;
            }

            sumsList.add(sum);
        }

        EquipoBase selectedStaff = selectStaff(equipoBase, sumsList);
        System.out.println("Rol: " + rol.getNombre() + "\nPersonal seleccionado: " + selectedStaff.getIdPersonal().getNombre());

        return selectedStaff;
    }

    private EquipoBase selectStaff(List<EquipoBase> staffList, List<Double> sumsList) {
        double major = -5;
        int index = 0;

        for (int i = 0; i < sumsList.size(); i++) {
            if (sumsList.get(i) > major) {
                major = sumsList.get(i);
                index = i;
            }
        }

        return staffList.get(index);
    }

}
