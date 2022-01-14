package com.mkrosnicki.bobifylogs.transport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkrosnicki.bobifylogs.config.RabbitConfig;
import com.mkrosnicki.bobifylogs.model.LogItem;
import com.mkrosnicki.bobifylogs.repositories.LogItemsRepository;
import com.mkrosnicki.bobifylogs.transport.dto.LogDto;
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
  private final LogItemsRepository logItemsRepository;

  @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
  public void receive(@Payload Object object) {
    if (object instanceof Message) {
      final Optional<String> messageBody = getMessageBodyAsString((Message) object);
      if (messageBody.isPresent()) {
        try {
          final LogDto logDto = objectMapper.readValue(messageBody.get(), LogDto.class);
          LogItem saved = logItemsRepository.save(map(logDto));
          System.out.println(saved);
        } catch (Exception e) {
          // do nothing
        }
      }
    }
  }

  private Optional<String> getMessageBodyAsString(final Message object) {
    final Message message = object;
    byte[] body = message.getBody();
    return Objects.nonNull(body) ? Optional.of(new String(body)) : Optional.empty();
  }

  private LogItem map(final LogDto logDto) {
    return new LogItem(null,
            logDto.getTimestamp(),
            logDto.getUserName(),
            logDto.getClassName(),
            logDto.getMethodName(),
            logDto.getArguments(),
            logDto.getDuration(),
            logDto.getQueryCount(),
            logDto.getErrorMessage(),
            logDto.getStackTrace());
  }

}
