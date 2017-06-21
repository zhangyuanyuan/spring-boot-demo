package com.kg.ws.web;

import com.kg.ws.dao.PersonRedisDao;
import com.kg.ws.domain.redis.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by quanquan on 2017/6/21.
 */
@RestController
@RequestMapping("/data/redis")
public class RedisController {

    @Autowired
    PersonRedisDao personRedisDao;

    @RequestMapping("/set")
    public void set() {
        Person person = new Person("1", "xxx", 32);
        personRedisDao.saveObject(person);
        personRedisDao.saveStr();
    }

    @RequestMapping("/getStr")
    public String getStr() {
        return personRedisDao.getString();
    }

    @RequestMapping("/getPerson")
    public Person getPerson() {
        return personRedisDao.getPerson();
    }

}
