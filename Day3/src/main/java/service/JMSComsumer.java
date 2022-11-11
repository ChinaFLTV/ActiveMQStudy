package service;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

/**
 * @author LiGuanda
 * @date 2022/11/11 下午 4:06:09
 * @description no description right now...
 * @filename service.JMSComsumer.java
 */


public class JMSComsumer {


    public static final String URL = "tcp://192.168.16.131:61616";
    public static final String QUEUE = "IU";


    public static void main(String[] args) throws JMSException, IOException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE);
        MessageConsumer consumer = session.createConsumer(queue);
        System.out.println("NO.2 consumer start receiving...");
        while (true) {

            TextMessage message = (TextMessage) consumer.receive();
            if (message != null) {

                System.out.println("Rec-->" + message.getText());

            } else {

                break;

            }

        }

        /*consumer.setMessageListener(message -> {

            if (message != null && message instanceof TextMessage) {

                try {

                    System.out.println("RecPro-->" + ((TextMessage) message).getText());

                } catch (JMSException e) {

                    throw new RuntimeException(e);

                }
            }


        });
        System.in.read();*/

        consumer.close();
        session.close();
        connection.close();

    }


}
