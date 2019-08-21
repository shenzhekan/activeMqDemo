package com.shenzk.mqmodel;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
@EnableJms
public class QueueMq {

    @Value("${mq.queue}")
    private String queue;

    @Value("${mq.topic}")
    private String topic;

    @Value("${mq.objQueue}")
    private String objQueue;

    @Bean("queue")
    public Queue queue(){
        return new ActiveMQQueue(queue);
    }

    @Bean("topic")
    public Topic topic(){
        return new ActiveMQTopic(topic);
    }

    @Bean("objQueue")
    public Queue objQueue(){
        return new ActiveMQQueue(objQueue);
    }
}
