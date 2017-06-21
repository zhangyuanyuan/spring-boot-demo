package com.kg.ws.dao;

import com.kg.ws.domain.Person;
import com.kg.ws.support.CustomerRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by quanquan on 2017/6/21.
 */
public interface PersonRepository extends CustomerRepository<Person, Long> {
    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name, String address);

    @Query("select p from Person p where p.address=:address and p.name=:name")
    Person withNameAndAddress(@Param("name") String name, @Param("address") String address);

    List<Person> withNameAndAddressNameQuery(String name, String address);
}
