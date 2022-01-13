package com.mkrosnicki.bobifylogs.bobifylogs.transport.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor(onConstructor = @__(@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)))
public class LogDto {

  private LocalDateTime timestamp;
  private String userName;
  private String className;
  private String methodName;
  private String arguments;
  private Long duration;
  private long queryCount;
  private String errorMessage;
  private String stackTrace;

}
