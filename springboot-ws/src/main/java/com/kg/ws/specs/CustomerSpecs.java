package com.kg.ws.specs;

import com.google.common.collect.Iterables;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quanquan on 2017/6/21.
 */
public class CustomerSpecs {

    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T target) {
        final Class<T> type = (Class<T>) target.getClass();
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            EntityType<T> entity = entityManager.getMetamodel().entity(type);
            for (Attribute<T, ?> attr : entity.getDeclaredAttributes()) {
                Object attrValue = getValue(target, attr);
                if (attrValue != null) {
                    if (attr.getJavaType() == String.class) {
                        if (!StringUtils.isEmpty(attrValue)) {
                            predicates.add(cb.like(root.get(attribute(entity, attr.getName(), String.class))
                                    , partten((String) attrValue)));
                        }
                    } else {
                        predicates.add(cb.equal(root.get(attribute(entity, attr.getName(), attr.getClass()))
                                , attrValue));
                    }
                }
            }
            return predicates.isEmpty() ? cb.conjunction() : cb.and(Iterables.toArray(predicates, Predicate.class));
        };
    }

    private static <T> Object getValue(T target, Attribute<T, ?> attr) {
        return ReflectionUtils.getField((Field) attr.getJavaMember(), target);
    }

    private static <E, T> SingularAttribute<T, E> attribute(EntityType<T> entityType, String fieldName, Class<E> fieldClass) {
        return entityType.getDeclaredSingularAttribute(fieldName, fieldClass);
    }

    private static String partten(String p) {
        return "%" + p + "%";
    }
}
