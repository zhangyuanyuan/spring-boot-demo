package com.kg.ws.domain.doc;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;


/**
 * Created by quanquan on 2017/6/21.
 */
@Data
@Document
public class Person {

    @Id
    private String id;

    private String name;

    private Integer age;

    @Field("locs")
    private Collection<Location> locations = new LinkedHashSet<>();

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
