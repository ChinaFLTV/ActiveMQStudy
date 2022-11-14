package service;

import org.apache.activemq.broker.BrokerService;

/**
 * @author LiGuanda
 * @date 2022/11/14 上午 9:01:14
 * @description no description right now...
 * @filename Server.java
 */


public class Server {


    public static void main(String[] args) throws Exception {

        BrokerService brokerService = new BrokerService();
        brokerService.setUseJmx(true);
        brokerService.addConnector("tcp://127.0.0.1:61616");
        brokerService.start();
        System.in.read();

    }


}