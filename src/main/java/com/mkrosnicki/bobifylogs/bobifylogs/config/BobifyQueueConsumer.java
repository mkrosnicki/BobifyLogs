package com.mkrosnicki.bobifylogs.bobifylogs.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class BobifyQueueConsumer {

//  @RabbitListener(queues = {}) // todo
  public void receive(@Payload String fileBody) {
    System.out.println(fileBody);
  }

}
