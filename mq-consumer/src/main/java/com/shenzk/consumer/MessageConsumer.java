package com.shenzk.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @JmsListener(destination="shenzk.queue", containerFactory = "queueListenerFactory")
    public void consumQueue(String message){
        System.err.println("【*** 接收Queue消息 ***】" + message);
    }

    @JmsListener(destination="shenzk.topic", containerFactory = "topicListenerFactory")
    public void consumTopic(String message){
        System.err.println("【*** 接受Topic消息 ***】" + message);
    }
}
