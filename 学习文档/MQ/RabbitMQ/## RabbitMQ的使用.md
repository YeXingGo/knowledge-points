## RabbitMQ的使用
```
1. 订阅模式
	1. 发送对象 AmqpTemplate
		1.调用方法    amqpTemplate.convertAndSend("QLTeaHouse_notice_1" , message.toJSONString()); 	
	2.  消费者
		1. @RabbitListener(queues = TopicRabbitConfig.ONE)
        public void receiveOne(String message){
            logger.info("one接受到的消息："+message);
        }		
```