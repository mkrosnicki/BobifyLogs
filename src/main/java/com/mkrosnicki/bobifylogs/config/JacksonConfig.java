package com.mkrosnicki.bobifylogs.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfig {

  @Bean
  public ObjectMapper objectMapper() {
    final JavaTimeModule module = new JavaTimeModule();
    final LocalDateTimeDeserializer localDateTimeDeserializer = new LocalDateTimeDeserializer(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//    module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);
    return Jackson2ObjectMapperBuilder.json().modules(new JavaTimeModule(), new ParameterNamesModule()).featuresToDisable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS).build();
  }

}
