package com.shenzk.test;

import com.shenzk.service.MessageProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {

    @Resource
    MessageProducerService messageProducerService;


    /**
     * 关于为什么要在此处测试发送消息：
     * 应用启动后会同时启动MesssageConsumer中的监听程序，
     * 测试启动之后，发送数据到MQ中，监听程序直接就能监听到
     */
    @Test
    public void activeMQSendMessageTest(){
        messageProducerService.sendMessage("text");

        messageProducerService.sendQueueMessage("send queue message");

        messageProducerService.sendTopicMessage("send topic message");
    }
}
