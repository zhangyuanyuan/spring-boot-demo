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
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    PersonService personService;

    @RequestMapping("/put")
    public Person save(Person person) {
        return personService.save(person);
    }

    @RequestMapping("/able")
    public Person findOne(Person person) {
        return personService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id) {
        personService.remove(id);
        return "ok";
    }

}
