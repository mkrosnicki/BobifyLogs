package com.mkrosnicki.bobifylogs.bobifylogs.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper() {
    final JavaTimeModule module = new JavaTimeModule();
    final LocalDateTimeSerializer localDateTimeSerializer = new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    module.addSerializer(localDateTimeSerializer);
    final ObjectMapper objectMapper = new ObjectMapper();
    return Jackson2ObjectMapperBuilder.json().modules(module).featuresToDisable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS).build();
  }

}
