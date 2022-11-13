package service;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author LiGuanda
 * @date 2022/11/13 上午 8:44:56
 * @description no description right now...
 * @filename JMSConsumer.java
 */


public class JMSConsumer {


    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.16.131:61616");
        Connection connection = connectionFactory.createConnection();
        //connection.setClientID("xixi");
        connection.start();

        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Queue dage = session.createQueue("Dage");
        MessageConsumer consumer = session.createConsumer(dage);
        //TopicSubscriber topicSubscriber = session.createDurableSubscriber(dage, "hahaha");

        consumer.setMessageListener(message -> {

            if (message instanceof TextMessage) {

                try {

                    System.out.println("Day5Rec--> " + ((TextMessage) message).getText());

                } catch (JMSException e) {

                    throw new RuntimeException(e);

                }

            }

        });

        /*consumer.close();
        session.close();
        connection.close();*/


    }


}
