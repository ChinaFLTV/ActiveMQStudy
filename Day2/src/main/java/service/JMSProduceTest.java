package service;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;

/**
 * @author LiGuanda
 * @date 2022/11/8 下午 7:25:12
 * @description no description right now...
 * @filename JMSProduceTest.java
 */


public class JMSProduceTest {


    public static final String URL = "tcp://192.168.16.131.8161:61616";
    public static final String QUEUE = "IU";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE);


    }


}
