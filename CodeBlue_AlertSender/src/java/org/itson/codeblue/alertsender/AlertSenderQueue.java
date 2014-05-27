/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itson.codeblue.alertsender;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import jpa.entities.EquipoBase;
import methodology.MethodologyApplier;

/**
 *
 * @author Darío Lumbreras
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/alertSenderQueue")
})
public class AlertSenderQueue implements MessageListener {

    public AlertSenderQueue() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            List<EquipoBase> team = formResponseTeam(tm);
            String json = serializeResponseTeam(team);
            System.out.println(json);
            connectToAlertServer(json);
        } catch (JMSException ex) {
            Logger.getLogger(AlertSenderQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private List<EquipoBase> formResponseTeam(TextMessage message) throws JMSException {
        MethodologyApplier methodology = new MethodologyApplier(message.getText());
        List<EquipoBase> team = methodology.formResponseTeam();
        return team;
    }
    
    private String serializeResponseTeam(List<EquipoBase> team) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<EquipoBase>>() {}.getType();
        String json = gson.toJson(team, type);
        return json;
    }

    private void connectToAlertServer(String json) {
        try {
            URL url = new URL("http://localhost:3000/bluecode");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            
            try (OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream())) {
                out.write(json);
                out.flush();
            }

            System.out.println("Sending Bluecode Alert");
            System.out.println("Response Code: " + connection.getResponseCode());
        } catch (MalformedURLException ex) {
            Logger.getLogger(AlertSenderQueue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AlertSenderQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
