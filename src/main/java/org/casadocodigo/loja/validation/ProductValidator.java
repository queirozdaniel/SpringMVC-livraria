package org.casadocodigo.loja.validation;

import org.casadocodigo.loja.models.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return false;
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
		Product product = (Product) object;
		if (product.getPages() == 0) {
			errors.rejectValue("pages", "field.required");
		}
	}

}
