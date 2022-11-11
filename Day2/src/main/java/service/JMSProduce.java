package service;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author LiGuanda
 * @date 2022/11/8 下午 7:25:12
 * @description no description right now...
 * @filename JMSProduceTest.java
 */


public class JMSProduce {


    public static final String URL = "tcp://192.168.16.131:61616";
    public static final String QUEUE = "IU";

    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(QUEUE);
        MessageProducer producer = session.createProducer(queue);
        TextMessage message1 = session.createTextMessage("Iu loves Dage");
        TextMessage message2 = session.createTextMessage("JuJingyi likes Dage");
        producer.send(message1);
        producer.send(message2);

        producer.close();
        session.close();
        connection.close();


    }


}
