package com.dww;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumeNone {

    private Logger logger = LoggerFactory.getLogger(MessageConsumeNone.class);

    /**
     * 使用JmsListener配置消费者监听的队列
     *
     * @param text
     *            接收到的消息
     */
    @JmsListener(destination = "suimh_queue")
    public void receiveQueue(String text) {
        logger.info("MessageConsumeNone : 收到的报文为:" + text);
    }

}
