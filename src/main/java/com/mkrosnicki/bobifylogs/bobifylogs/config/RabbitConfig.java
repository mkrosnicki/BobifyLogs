package com.mkrosnicki.bobifylogs.bobifylogs.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  public static final String LOG_QUEUE_NAME = "bobifylogs"; // todo move to properties!
  public static final String NOTIFICATIONS_QUEUE_NAME = "bobifynotifications"; // todo move to properties!

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
