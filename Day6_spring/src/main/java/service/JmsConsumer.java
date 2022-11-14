package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author LiGuanda
 * @date 2022/11/14 下午 5:37:57
 * @description no description right now...
 * @filename JmsConsumer.java
 */

@Service
public class JmsConsumer {


    @Autowired
    private JmsTemplate jmsTemplate;


    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
        JmsConsumer consumer = (JmsConsumer) context.getBean("jmsConsumer");
        String message = (String) consumer.jmsTemplate.receiveAndConvert();
        System.out.println("SpringRec--> " + message);

    }


}
