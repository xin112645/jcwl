package com.dww;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * 测试消息 生成者
 */

@Service("messageProduce")
public class MessageProduce {

    private Logger logger = LoggerFactory.getLogger(MessageProduce.class);

    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 发送消息
     *
     * @param destination
     *            发送到的队列
     * @param message
     *            待发送的消息
     */
    public void convertAndSend(Destination destination, final String message) {
        jmsTemplate.convertAndSend(destination, message);
        logger.info("消息发送成功！");
    }
}
