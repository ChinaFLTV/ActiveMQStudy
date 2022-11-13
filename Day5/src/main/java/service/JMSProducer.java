package service;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author LiGuanda
 * @date 2022/11/13 上午 8:40:53
 * @description no description right now...
 * @filename JMSProducer.java
 */


public class JMSProducer {


    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.16.131:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue dage = session.createQueue("Dage");
        MessageProducer producer = session.createProducer(dage);

        //producer.setDeliveryMode(DeliveryMode.PERSISTENT);


        TextMessage heiheihei = session.createTextMessage("heiheihei");
        TextMessage hehehe = session.createTextMessage("hehehe");
        producer.send(heiheihei);
        producer.send(hehehe);


        producer.close();

        //session.commit();
        session.close();
        connection.close();

    }


}
