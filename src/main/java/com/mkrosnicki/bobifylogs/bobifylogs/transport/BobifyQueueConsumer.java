package com.mkrosnicki.bobifylogs.bobifylogs.transport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkrosnicki.bobifylogs.bobifylogs.config.RabbitConfig;
import com.mkrosnicki.bobifylogs.bobifylogs.transport.dto.LogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BobifyQueueConsumer {

  private final ObjectMapper objectMapper;

  @RabbitListener(queues = RabbitConfig.LOG_QUEUE_NAME)
  public void receiveLog(@Payload Object object) {
    if (object instanceof Message) {
      final Optional<String> messageBody = getMessageBodyAsString((Message) object);
      if (messageBody.isPresent()) {
        try {
          final LogDto logDto = objectMapper.readValue(messageBody.get(), LogDto.class);
        } catch (Exception e) {

        }
      }
    }
  }

  @RabbitListener(queues = RabbitConfig.NOTIFICATIONS_QUEUE_NAME)
  public void receiveNotification(@Payload Object object) {
    if (object instanceof Message) {
      final Optional<String> messageBody = getMessageBodyAsString((Message) object);
      if (messageBody.isPresent()) {
        try {
          final LogDto logDto = objectMapper.readValue(messageBody.get(), LogDto.class);
        } catch (Exception e) {

        }
      }
    }
  }

  private Optional<String> getMessageBodyAsString(final Message object) {
    final Message message = object;
    byte[] body = message.getBody();
    return Objects.nonNull(body) ? Optional.of(new String(body)) : Optional.empty();
  }

}
