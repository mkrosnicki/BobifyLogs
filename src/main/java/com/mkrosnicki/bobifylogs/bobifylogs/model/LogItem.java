package com.mkrosnicki.bobifylogs.bobifylogs.model;

import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
//@Document("logItems") // todo
public class LogItem {

    @Id
    private String id;

    private LocalDateTime timestamp;
    private String userName;
    private String className;
    private String methodName;
    private String arguments;
    private long duration;
    private int queryCount;
    private String error;


}