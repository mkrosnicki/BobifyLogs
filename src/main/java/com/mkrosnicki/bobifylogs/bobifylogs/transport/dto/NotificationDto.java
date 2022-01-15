package com.mkrosnicki.bobifylogs.bobifylogs.transport.dto;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Value
public class NotificationDto {

  private UUID id;
  private UUID receiverId;
  private UUID firstIssuerId;
  private UUID lastIssuerId;
  private LocalDateTime firstIssuedAt;
  private LocalDateTime lastIssuedAt;
  private Map<NotificationProperty, String> details;


}
