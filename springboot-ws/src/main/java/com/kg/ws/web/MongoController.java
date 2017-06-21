package com.kg.ws.web;

import com.kg.ws.dao.PersonMongoRepository;
import com.kg.ws.domain.doc.Location;
import com.kg.ws.domain.doc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by quanquan on 2017/6/21.
 */
@RestController
@RequestMapping("/data/mongo")
public class MongoController {

    @Autowired
    PersonMongoRepository personMongoRepository;

    @RequestMapping("/save")
    public Person save(String name, Integer age, String address) {
        Person p = new Person("wfy", 22);
        Collection locations = new LinkedHashSet();
        Location l1 = new Location("shanghai", "2014");
        Location l2 = new Location("beijing", "2015");
        Location l3 = new Location("guangzhou", "2016");
        Location l4 = new Location("shenzhen", "2017");
        locations.add(l1);
        locations.add(l2);
        locations.add(l3);
        locations.add(l4);
        p.setLocations(locations);
        return personMongoRepository.save(p);
    }

    @RequestMapping("/find1")
    public List<Person> findByAddress(Integer age) {
        List<Person> p = personMongoRepository.withQueryFindByage(age);
        return p;
    }

    @RequestMapping("/find2")
    public Person findByName(String name) {
        Person p = personMongoRepository.findByName(name);
        return p;
    }

}
