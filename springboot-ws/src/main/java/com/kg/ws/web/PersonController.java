package com.kg.ws.web;

import com.kg.ws.domain.Person;
import com.kg.ws.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by quanquan on 2017/6/21.
 */
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping("/search")
    public Person search(String personName) {
        return new Person(1L, personName, 22, "nanjing");
    }

    @RequestMapping("/data/rollback")
    public Person rollback(Person p) {
        return personService.savePersonWithRollBack(p);
    }

    @RequestMapping("/data/norollback")
    public Person norollback(Person p) {
        return personService.savePersonWithNoRollBack(p);
    }

}
