package com.lindec.springboot.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lindec on 2016/3/9.
 */
public interface PersonRepository extends MongoRepository<Person, ObjectId> {
}
