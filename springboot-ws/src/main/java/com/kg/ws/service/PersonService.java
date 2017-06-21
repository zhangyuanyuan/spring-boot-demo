package com.kg.ws.service;

import com.kg.ws.domain.Person;

/**
 * Created by quanquan on 2017/6/21.
 */
public interface PersonService {

    Person save(Person person);

    void remove(Long id);

    Person findOne(Person person);

    Person savePersonWithRollBack(Person person);

    Person savePersonWithNoRollBack(Person person);

}
