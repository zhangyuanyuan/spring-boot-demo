package com.kg.ws.domain.redis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by quanquan on 2017/6/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {

    private String id;

    private String name;

    private Integer age;
}
