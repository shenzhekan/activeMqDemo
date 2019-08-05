package com.shenzk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * 监听工厂累配置
 */
@Configuration
@EnableJms
public class ActiveMqConfig {

    /**
     * 队列监听工厂类
     * @param connectionFactory
     * @return
     */
    @Bean("queueListenerFactory")
    public JmsListenerContainerFactory queueListenerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        factory.setConcurrency("5");
        return factory;
    }

    /**
     * 主题监听工厂类
     * @param connectionFactory
     * @return
     */
    @Bean("topicListenerFactory")
    public JmsListenerContainerFactory topicListenerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
