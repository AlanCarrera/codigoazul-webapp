package messageBean;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import jpa.entities.Zonas;
import methodology.RoleAssignerFacade;

@MessageDriven(mappedName = "jms/zoneQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jms/zoneQueue")
})
public class TeamReadyMDB implements MessageListener {

    public TeamReadyMDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;

            RoleAssignerFacade roleA = new RoleAssignerFacade(tm.getText());
            roleA.formResponseTeam();

            System.out.println("Consumed message: " + tm.getText());
        } catch (JMSException jex) {
            System.out.println("Exception: " + jex);
        }
    }
}
