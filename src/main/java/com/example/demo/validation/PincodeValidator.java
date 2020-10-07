package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PincodeValidator implements ConstraintValidator<CheckPincode, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		try{
			Long x = Long.parseLong(value);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
