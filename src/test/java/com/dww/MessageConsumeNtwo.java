package com.dww;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumeNtwo {

    private Logger logger = LoggerFactory.getLogger(MessageConsumeNtwo.class);

    /**
     * 使用JmsListener配置消费者监听的队列
     *
     * @param text 接收到的消息
     */
    @JmsListener(destination = "suimh_queue")
    @SendTo("out.queue")
    public String receiveQueue(String text) {
        logger.info("MessageConsumeNtwo : 收到的报文为:" + text);
        logger.info("MessageConsumeNtwo : 收到的报文为:返回数据到out.queue");
        return text;
    }

}