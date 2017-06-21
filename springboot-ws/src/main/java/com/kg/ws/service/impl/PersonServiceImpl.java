package com.kg.ws.service.impl;

import com.kg.ws.dao.PersonRepository;
import com.kg.ws.domain.Person;
import com.kg.ws.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by quanquan on 2017/6/21.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("save为"+p.getId() +"数据做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")
    public void remove(Long id) {
        System.out.println("delete删除"+id +"数据做了缓存");
        //personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people", key = "#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("find为"+p.getId() +"数据做了缓存");
        return p;
    }

    @Override
    @Transactional(rollbackFor = IllegalArgumentException.class)
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        if (p.getName().equals("zzz")) {
            throw new IllegalArgumentException("非法参数添加");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public Person savePersonWithNoRollBack(Person person) {
        Person p = personRepository.save(person);
        if (p.getName().equals("zzz")) {
            throw new IllegalArgumentException("非法参数添加,但不会回滚");
        }
        return p;
    }
}
