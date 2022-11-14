package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author LiGuanda
 * @date 2022/11/14 下午 5:16:06
 * @description no description right now...
 * @filename JmsProducer.java
 */


@Service
public class JmsProducer {


    @Autowired
    private JmsTemplate jmsTemplate;


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        JmsProducer producer = (JmsProducer) context.getBean("jmsProducer");
        producer.jmsTemplate.send(session -> session.createTextMessage("Break News! IU also fell in love with Dage!!!"));

    }


}
