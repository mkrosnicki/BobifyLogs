package com.mkrosnicki.bobifylogs.repositories;

import com.mkrosnicki.bobifylogs.model.LogItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogItemsRepository extends MongoRepository<LogItem, String> {

}