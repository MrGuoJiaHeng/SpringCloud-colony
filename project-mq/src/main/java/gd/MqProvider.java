package gd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.jms.*;

@SpringBootApplication
@EnableScheduling
public class MqProvider {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private JmsTemplate jmsTemplate;
//    @Autowired
//    private Queue queue;

    public void send() {
        String result = System.currentTimeMillis() + "-------------------存入";
        System.out.println(result);
//        jmsMessagingTemplate.convertAndSend(queue,result );
        jmsTemplate.send("q1", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(result);
                return textMessage;
            }
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(MqProvider.class, args);
    }
}
