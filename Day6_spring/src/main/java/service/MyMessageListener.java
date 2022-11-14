package service;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author LiGuanda
 * @date 2022/11/14 下午 5:59:05
 * @description no description right now...
 * @filename MyMessageListener.java
 */

@Component
public class MyMessageListener implements MessageListener {


    @Override
    public void onMessage(Message message) {

        if (message instanceof TextMessage) {

            try {

                System.out.println("Listener Rec--> " + ((TextMessage) message).getText());

            } catch (JMSException e) {

                throw new RuntimeException(e);

            }

        }

    }


}
