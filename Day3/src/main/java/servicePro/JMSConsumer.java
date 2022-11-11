package servicePro;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author LiGuanda
 * @date 2022/11/11 下午 5:20:59
 * @description no description right now...
 * @filename JMSConsumer.java
 */


public class JMSConsumer {


    public static final String URL = "tcp://192.168.16.131:61616";
    public static final String TOPIC = "JuJingyi";


    public static void main(String[] args) throws JMSException, IOException {


        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC);
        MessageConsumer consumer = session.createConsumer(topic);
        System.out.println("No.4 consumer for topic is working...");
        consumer.setMessageListener(message -> {

            if (message != null && message instanceof TextMessage) {

                try {

                    System.out.println("RecProMax-->" + ((TextMessage) message).getText());

                } catch (JMSException e) {

                    throw new RuntimeException(e);

                }

            }


        });
        System.in.read();

        consumer.close();
        session.close();
        connection.close();

    }


}
