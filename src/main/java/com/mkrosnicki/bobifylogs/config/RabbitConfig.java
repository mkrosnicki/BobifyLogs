package com.mkrosnicki.bobifylogs.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "bobifylogs"; // todo move to properties!

//    @Bean
//    public Queue queue() {
//        return new Queue(QUEUE_NAME, false);
//    }

//    @Bean // todo what for?
//    TopicExchange exchange() {
//        return new TopicExchange();
//    }

//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
//    }

}
