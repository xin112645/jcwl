package com.dww;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jms.Destination;

/**
 * 接收消费者 返回数据
 */
@Component
public class RxCousResultProduce {

    private Logger logger = LoggerFactory.getLogger(RxCousResultProduce.class);

    /**
     * 使用JmsListener配置消费者监听的队列
     *
     * @param text
     *            接收到的消息
     */
    @JmsListener(destination = "out.queue")
    public void consumerMessage(String text) {
        logger.info("RxCousResultProduce : 从out.queue队列收到的回复报文为:" + text);
    }
    @Autowired
    MessageProduce messageProduce;

    @GetMapping(value = "/activeMqSendMes")
    @ResponseBody
    public String activeMqSendMes() {
        int num = 10;
        try {
            //ActiveMQQueue 队列模式
            //ActiveMQTopic 订阅模式
            Destination destinationQueue = new ActiveMQQueue("suimh_queue");
            for (int i = 1; i <= num; i++) { messageProduce.convertAndSend(destinationQueue, "这是queueProducer发送的第" + i + "个消息！");
            }
            return "activeMQ生产成功！";
        } catch (Exception e) {
            return "activeMQ生产失败！";
        }
    }
}

