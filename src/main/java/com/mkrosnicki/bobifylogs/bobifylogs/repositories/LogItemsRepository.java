package com.mkrosnicki.bobifylogs.bobifylogs.repositories;

import com.mkrosnicki.bobifylogs.bobifylogs.model.LogItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogItemsRepository extends MongoRepository<LogItem, String> {

}