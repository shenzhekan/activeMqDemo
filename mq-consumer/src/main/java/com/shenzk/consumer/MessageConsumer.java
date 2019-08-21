package com.shenzk.consumer;

import com.shenzk.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Service
public class MessageConsumer {

    private static final Logger log = LoggerFactory.getLogger(MessageConsumer.class);

    /**
     * 消费queue数据
     * @param message
     */
    @JmsListener(destination="shenzk.queue", containerFactory = "queueListenerFactory")
    public void consumQueue(String message){
        System.err.println("【*** 接收Queue消息 ***】" + message);
    }

    /**
     * 消费topic数据
     * @param message
     */
    @JmsListener(destination="shenzk.topic", containerFactory = "topicListenerFactory")
    public void consumTopic(String message){
        System.err.println("【*** 接受Topic消息 ***】" + message);
    }

    /**
     * 消费queue中的对象
     * @param msg
     * @throws JMSException
     */
    @JmsListener(destination = "shenzk.objQueue", containerFactory = "queueListenerFactory")
    public void consumObjectMsg(ObjectMessage msg) throws JMSException {
        log.info("接收的对象数据："+msg.toString());
        Student student = new Student();
        BeanUtils.copyProperties(msg.getObject(), student);
        System.out.println(student.getName()+" -- "+student.getAge());
    }
}
