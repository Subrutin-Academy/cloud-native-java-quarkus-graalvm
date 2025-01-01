package com.subrutin.lingkar.catalog.validator;

import java.time.LocalDate;

import com.subrutin.lingkar.catalog.validator.annotation.PastDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PastDateValidator implements ConstraintValidator<PastDate, Long> {

    @Override
    public boolean isValid(Long epochDate, ConstraintValidatorContext context) {
        return LocalDate.now().isAfter(LocalDate.ofEpochDay(epochDate));

    }

}
