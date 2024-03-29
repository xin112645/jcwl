package com.dww;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

public class ActiveMQUtil {
    @Test
    public void testProduceMQ() throws Exception {
        // 连接工厂
        // 使用默认用户名、密码、路径
        // 路径 tcp://host:61616
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        // 获取一个连接
        Connection connection = connectionFactory.createConnection();
        // 建立会话
        Session session = connection.createSession(true,
                Session.AUTO_ACKNOWLEDGE);
        // 创建队列或者话题对象
        Queue queue = session.createQueue("HelloWorld");
        // 创建生产者 或者 消费者
        MessageProducer producer = session.createProducer(queue);

        for (int i = 0; i < 10; i++) producer.send(session.createTextMessage("你好，activeMQ:" + i));
        // 提交操作
        session.commit();

    }



}
