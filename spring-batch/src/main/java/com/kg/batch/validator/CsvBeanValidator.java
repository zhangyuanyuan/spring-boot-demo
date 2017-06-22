package com.kg.batch.validator;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.InitializingBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by quanquan on 2017/6/21.
 */
public class CsvBeanValidator<T> implements Validator<T>, InitializingBean {

    private javax.validation.Validator validator;

    @Override
    public void validate(T t) throws ValidationException {
        Set<ConstraintViolation<T>> validate = validator.validate(t);
        if (validate.size() > 0) {
            StringBuilder sb = new StringBuilder();
            validate.forEach((v) -> sb.append(v.getMessage()+"\n"));
            throw new ValidationException(sb.toString());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.usingContext().getValidator();
    }
}
