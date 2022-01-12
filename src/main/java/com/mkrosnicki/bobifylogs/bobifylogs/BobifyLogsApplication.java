package com.mkrosnicki.bobifylogs.bobifylogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class BobifyLogsApplication {

  public static void main(String[] args) {
    SpringApplication.run(BobifyLogsApplication.class, args);
  }

}
