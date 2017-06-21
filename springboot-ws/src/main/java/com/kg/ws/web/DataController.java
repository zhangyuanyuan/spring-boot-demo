package com.kg.ws.web;

import com.kg.ws.dao.PersonRepository;
import com.kg.ws.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by quanquan on 2017/6/21.
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public Person save(String name, Integer age, String address) {
        Person p = personRepository.save(new Person(null, name, age, address));
        return p;
    }

    @RequestMapping("/find1")
    public List<Person> findByAddress(String address) {
        List<Person> p = personRepository.findByAddress(address);
        return p;
    }

    @RequestMapping("/find2")
    public Person findByNameAndAddress(String name, String address) {
        Person p = personRepository.findByNameAndAddress(name, address);
        return p;
    }

    @RequestMapping("/find3")
    public Person withNameAndAddress(String name, String address) {
        Person p = personRepository.withNameAndAddress(name, address);
        return p;
    }

    @RequestMapping("/find4")
    public List<Person> withNameAndAddressNameQuery(String name, String address) {
        List<Person> p = personRepository.withNameAndAddressNameQuery(name, address);
        return p;
    }

    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> p = personRepository.findAll(new Sort(Sort.Direction.DESC, "age"));
        return p;
    }

    @RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> p = personRepository.findAll(new PageRequest(1,2));
        return p;
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person) {
        Page<Person> p = personRepository.findByAuto(person, new PageRequest(0,10));
        return p;
    }
}
