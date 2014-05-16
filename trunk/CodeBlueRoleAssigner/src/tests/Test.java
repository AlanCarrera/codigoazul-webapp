/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tests;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jpa.controller.AreasJpaController;
import jpa.entities.Areas;

/**
 *
 * @author Ithzell
 */
public class Test {
    public static void main (String args[]){
        EntityManagerFactory objFactory = Persistence.createEntityManagerFactory("JavaApplication7PU");
        EntityManager manager = objFactory.createEntityManager();
        
        AreasJpaController areasController = new AreasJpaController(objFactory);
        
        Areas areas = new Areas(2);
        
        try {
            areasController.create(areas);
            System.out.println("Created areas. Mapa count : " + areasController.getAreasCount());
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Areas> areasList = areasController.findAreasEntities();
        
        for (Areas map : areasList) {
            System.out.println(map.toString());
        }        
    }
}
