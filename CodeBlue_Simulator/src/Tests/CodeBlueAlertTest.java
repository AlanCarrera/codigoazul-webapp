/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tests;

/**
 *
 * @author Laser Marker
 */
public class CodeBlueAlertTest {

//    public CodeBlueAlertTest(int idPaciente, double x, double y) {
//        alert(idPaciente, x, y);
//    }
    
    public static void main(String[] args) {
        alert(1,15.16,81.59);
    }

    private static void alert(int idPaciente, double x, double y) {
        System.out.println("hii");        
        com.codeblue.webservices.CodeBlueAlert_Service service = new com.codeblue.webservices.CodeBlueAlert_Service();
        com.codeblue.webservices.CodeBlueAlert port = service.getCodeBlueAlertPort();
        port.alert(idPaciente, x, y);
    }


}
