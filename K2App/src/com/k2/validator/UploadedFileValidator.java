package com.k2.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.k2.entity.UploadedFile;

public class UploadedFileValidator implements org.springframework.validation.Validator {

	public UploadedFileValidator(){
		// TODO Auto-generated constructor stub
	}


	//is used to check if the validator can validate instances of the paramClass
	@Override
	public boolean supports(Class<?> paramclass) {
		return UploadedFile.class.equals(paramclass);
	}

	/* a methods to check the fields of the object. All error messages are passed 
	in the error object. A properties file with error messages can be used here */
	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "NotEmpty.upFile.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataCaricamento", "NotEmpty.upFile.dataCaricamento");
	}

}
