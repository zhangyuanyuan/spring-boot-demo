package com.kg.ws.support.impl;

import com.kg.ws.support.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

import static com.kg.ws.specs.CustomerSpecs.byAuto;

/**
 * Created by quanquan on 2017/6/21.
 */
public class CustomerRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomerRepository<T, ID> {

    private final EntityManager entityManager;

    public CustomerRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public Page<T> findByAuto(T target, Pageable pageable) {
        return findAll(byAuto(entityManager, target), pageable);
    }
}
