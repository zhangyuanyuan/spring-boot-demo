package com.kg.ws.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * Created by quanquan on 2017/6/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name="Person.withNameAndAddressNameQuery",
        query = "select p from Person p where p.name=?1 and p.address=?2")
public class Person  {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String address;
}
