package com.shenzk.service.impl;

import com.shenzk.model.Student;
import com.shenzk.service.MessageProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.Serializable;

@Service
public class MessageProducerServiceImpl implements MessageProducerService {

    @Resource
    JmsMessagingTemplate jmsMessagingTemplate;

    @Resource(name="queue")
    Queue queue;

    @Resource(name="topic")
    Topic topic;

    @Resource(name="objQueue")
    Queue objQueue;


    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue("shenzk.queue"), message);
    }

    /**
     * 发送队列消息
     * @param message
     */
    @Override
    public void sendQueueMessage(String message){
        jmsMessagingTemplate.convertAndSend(queue, message);
    }

    /**
     * 发送主题消息
     * @param message
     */
    @Override
    public void sendTopicMessage(String message){
        jmsMessagingTemplate.convertAndSend(topic, message);
    }

    /**
     * 传输对象
     * @param student
     */
    @Override
    public void sendObjectMessage(Student student) {
        jmsMessagingTemplate.convertAndSend(objQueue, (Serializable)student);
    }
}
