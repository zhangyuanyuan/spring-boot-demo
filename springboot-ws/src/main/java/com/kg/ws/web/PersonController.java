package com.kg.ws.web;

import com.kg.ws.domain.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by quanquan on 2017/6/21.
 */
@RestController
public class PersonController {

    @RequestMapping("/search")
    public Person search(String personName) {
        return new Person(personName, 22, "nanjing");
    }
}
