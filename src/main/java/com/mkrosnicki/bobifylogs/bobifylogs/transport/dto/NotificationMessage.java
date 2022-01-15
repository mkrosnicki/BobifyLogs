package com.mkrosnicki.bobifylogs.bobifylogs.transport.dto;

import lombok.Value;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Value
public class NotificationMessage {

  private UUID id;
  private UUID receiverId;
  private UUID issuerId;
  private LocalDateTime issuedAt;
  private final Map<NotificationProperty, String> details = new HashMap<>();

  public void addProperty(final NotificationProperty property, final String value) {
    details.put(property, value);
  }


}
