/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.itson.codeblue.alertsender;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Darío Lumbreras
 */
@MessageDriven(mappedName = "jms/alertSenderQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jms/alertSenderQueue")
})
public class AlertSenderQueue implements MessageListener {
    
    public AlertSenderQueue() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            URL url = new URL("http://localhost:3000/bluecode");
            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            
            System.out.println("Sending Bluecode Alert");
            System.out.println("Response Code: " + connection.getResponseCode());
        } catch (MalformedURLException ex) {
            Logger.getLogger(AlertSenderQueue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlertSenderQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
