package com.shenzk.test;

import com.shenzk.service.MessageProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {

    @Resource
    MessageProducerService messageProducerService;

    @Test
    public void activeMQSendMessageTest(){
        messageProducerService.sendMessage("text");

        messageProducerService.sendQueueMessage("send queue message");

        messageProducerService.sendTopicMessage("send topic message");
    }
}
