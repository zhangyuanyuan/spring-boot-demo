package com.kg.ws.domain.security;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by quanquan on 2017/6/21.
 */
@Data
@Entity
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
