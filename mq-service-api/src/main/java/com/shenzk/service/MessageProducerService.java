package com.shenzk.service;

import com.shenzk.model.Student;

/**
 * activeMQ 发送者服务
 */
public interface MessageProducerService {
    public void sendMessage(String message);

    public void sendQueueMessage(String message);

    public void sendTopicMessage(String message);

    public void sendObjectMessage(Student student);
}
