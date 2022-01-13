package com.mkrosnicki.bobifylogs.bobifylogs.transport;

import com.mkrosnicki.bobifylogs.bobifylogs.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
public class BobifyQueueConsumer {

    @RabbitHandler
    public void receive(@Payload String fileBody) {
        System.out.println(fileBody);
    }

}
