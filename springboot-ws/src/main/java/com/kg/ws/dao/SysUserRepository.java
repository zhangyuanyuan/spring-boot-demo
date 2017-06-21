package com.kg.ws.dao;

import com.kg.ws.domain.security.SysUser;
import com.kg.ws.support.CustomerRepository;

/**
 * Created by quanquan on 2017/6/21.
 */
public interface SysUserRepository extends CustomerRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
