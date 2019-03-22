package gd.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Queue;

@RestController
public class mqDemo {

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("/seedMsg")
    public void seedMsg(String msgCount, String msg) {
        jmsTemplate.send(msgCount, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(msg);
                return textMessage;
            }
        });
    }

    @JmsListener(destination = "${queue}")
    public void reMsg(String msgCount) {
        System.out.println("q1输出: ======= " + msgCount);
    }
}
