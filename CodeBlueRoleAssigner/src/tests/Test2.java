/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import jpa.entities.Zonas;
import methodology.RoleAssignerFacade;

/**
 *
 * @author Ithzell
 */
public class Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RoleAssignerFacade roleA = new RoleAssignerFacade(new Zonas(1));

        roleA.formResponseTeam();

    }

}
