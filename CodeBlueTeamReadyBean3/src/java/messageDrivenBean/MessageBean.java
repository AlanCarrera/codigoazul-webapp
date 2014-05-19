package messageDrivenBean;


import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.TextMessage;
import methodology.MethodologyApplier;

@MessageDriven(mappedName = "jms/zoneQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jms/zoneQueue")
})
public class MessageBean implements MessageListener {
    @Resource(mappedName = "jms/teamReadyQueue")
    private Queue teamReadyQueue;
    @Inject
    @JMSConnectionFactory("jms/myQueueFactory")
    private JMSContext context;
    


    public MessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage tm = (TextMessage) message;
            
            System.out.println("Código azul en área " + tm.getText() + "! Formando equipo de respuesta...");

            MethodologyApplier methodology = new MethodologyApplier(tm.getText());
            methodology.formResponseTeam();
            
            System.out.println("Equipo creado. Enviando notificaciones...");
            
            //send notice
            sendJMSMessageToTeamReadyQueue(tm.getText());
        } catch (JMSException jex) {
            System.out.println("Exception: " + jex);
        }
    }

    private void sendJMSMessageToTeamReadyQueue(String messageData) {
        context.createProducer().send(teamReadyQueue, messageData);
    }
}
