package messageBean;

import bean.MessageProducerBean;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import methodology.MethodologyApplier;

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

            MethodologyApplier methodology = new MethodologyApplier(tm.getText());
            methodology.formResponseTeam();
            
            MessageProducerBean messageProducerBean = new MessageProducerBean();
            
            //send notice
            messageProducerBean.setMessage(tm.getText());            
            messageProducerBean.send();

            System.out.println("Consumed message: " + tm.getText());
        } catch (JMSException jex) {
            System.out.println("Exception: " + jex);
        }
    }
}
