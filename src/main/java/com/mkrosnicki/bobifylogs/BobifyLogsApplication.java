package com.mkrosnicki.bobifylogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories // todo
public class BobifyLogsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BobifyLogsApplication.class, args);
    }

}
