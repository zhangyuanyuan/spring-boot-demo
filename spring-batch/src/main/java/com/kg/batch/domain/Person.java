package com.kg.batch.domain;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Created by quanquan on 2017/6/21.
 */
@Data
public class Person {

    @Size(max = 4, min = 2)
    private String name;
    private int age;
    private String nation;
    private String address;

}
