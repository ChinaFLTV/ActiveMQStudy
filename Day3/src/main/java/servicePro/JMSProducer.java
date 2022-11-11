package servicePro;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author LiGuanda
 * @date 2022/11/11 下午 5:13:44
 * @description no description right now...
 * @filename JMSProducer.java
 */


public class JMSProducer {


    public static final String URL = "tcp://192.168.16.131:61616";
    public static final String TOPIC = "JuJingyi";


    public static void main(String[] args) throws JMSException {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC);
        MessageProducer producer = session.createProducer(topic);
        TextMessage message1 = session.createTextMessage("Dage loves JuJingyi");
        TextMessage message2 = session.createTextMessage("Dage also likes IU");
        producer.send(message1);
        producer.send(message2);

        producer.close();
        session.close();
        connection.close();

    }


}
