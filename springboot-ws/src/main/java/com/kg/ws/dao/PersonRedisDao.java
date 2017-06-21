package com.kg.ws.dao;

import com.kg.ws.domain.redis.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by quanquan on 2017/6/21.
 */
@Repository
public class PersonRedisDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name="redisTemplate")
    ValueOperations<Object, Object> valOps;

    public void saveStr() {
        valOpsStr.set("qq", "quanquan");
    }

    public void saveObject(Person p) {
        valOps.set(p.getId(), p);
    }

    public String getString() {
        return valOpsStr.get("qq");
    }

    public Person getPerson() {
        return (Person) valOps.get("1");
    }
}
