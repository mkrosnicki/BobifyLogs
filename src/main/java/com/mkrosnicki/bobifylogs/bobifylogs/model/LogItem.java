package com.mkrosnicki.bobifylogs.bobifylogs.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("logItems")
@AllArgsConstructor
public class LogItem {

    @Id
    private String id;
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