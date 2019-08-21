package com.shenzk.test;

import com.shenzk.model.Student;
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

        Student student = new Student();
        student.setName("shenzk");
        student.setAge(23);
        messageProducerService.sendObjectMessage(student);
    }
}
