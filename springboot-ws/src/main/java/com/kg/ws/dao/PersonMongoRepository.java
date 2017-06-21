package com.kg.ws.dao;

import com.kg.ws.domain.doc.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by quanquan on 2017/6/21.
 */
public interface PersonMongoRepository extends MongoRepository<Person, String> {

    Person findByName(String name);

    @Query("{'age': ?0}")
    List<Person> withQueryFindByage(Integer age);
}
