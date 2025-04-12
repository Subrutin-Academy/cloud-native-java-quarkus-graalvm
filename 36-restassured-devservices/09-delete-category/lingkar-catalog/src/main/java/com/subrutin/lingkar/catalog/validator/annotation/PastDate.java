package com.subrutin.lingkar.catalog.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.subrutin.lingkar.catalog.validator.PastDateValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = PastDateValidator.class)
public @interface PastDate {

    String message() default "date must be past";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
