package com.shenzk.service;

/**
 * activeMQ 发送者服务
 */
public interface MessageProducerService {
    public void sendMessage(String message);

    public void sendQueueMessage(String message);

    public void sendTopicMessage(String message);
}
