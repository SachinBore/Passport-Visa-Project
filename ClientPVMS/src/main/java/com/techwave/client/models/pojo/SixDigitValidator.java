package com.techwave.client.models.pojo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SixDigitValidator implements ConstraintValidator<pin, String> {

	

	 @Override
	  public boolean isValid(String value, ConstraintValidatorContext context) {
	    return value != null && value.length() == 6;
	  }
}