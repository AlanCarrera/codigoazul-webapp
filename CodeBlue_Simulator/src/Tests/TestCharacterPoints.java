/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tests;

import static java.lang.Thread.sleep;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laser Marker
 */
public class TestCharacterPoints {
    public static void main(String[] args) {
        characterPoints();
    }

    private static void characterPoints() {
        com.codeblue.webservices.CharacterPointsWS_Service service = new com.codeblue.webservices.CharacterPointsWS_Service();
        com.codeblue.webservices.CharacterPointsWS port = service.getCharacterPointsWSPort();
        DecimalFormat df = new DecimalFormat("#.####");
        while (true) {
            try {
                for(int i = 0; i <= 6;i++){
                    //People walk aprox. 2 to 5 meters every 2 seconds
                    double walkx = 8 + (Math.random() * ((22 - 8) + 1));
                    double walky = 62 + (Math.random() * ((88 - 62) + 1));
                    System.out.println("x: " + walkx + ", y: " + walky);
                    port.characterPoints(i, Double.parseDouble(df.format(walkx)), Double.parseDouble(df.format(walky)));
                }
//                for(int i = 0; i <= 6;i++){
//                    
//                }
                sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TestCharacterPoints.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
