package io.lightfeather.springtemplate.util;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import io.lightfeather.springtemplate.constants.RegexPatterns;
import io.lightfeather.springtemplate.constants.Validations;
import io.lightfeather.springtemplate.model.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		if(clazz.isInstance(User.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.USER_FIRST_NAME, Validations.USER_FIRST_NAME_ERROR_CODE, Validations.USER_FIRST_NAME_DEFAULT_MESSAGE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.USER_LAST_NAME, Validations.USER_LAST_NAME_ERROR_CODE, Validations.USER_LAST_NAME_DEFAULT_MESSAGE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.USER_SUPERVISOR, Validations.USER_SUPERVISOR_ERROR_CODE, Validations.USER_PHONE_NUMBER_DEFAULT_MESSAGE);
		
		User user = (User) target;
		if (!Strings.isEmpty(user.getPhoneNumber())) {
			if(!user.getPhoneNumber().matches(RegexPatterns.USA_VALID_PHONE_NUMBER_FORMAT)) {
				
				/*
				 * Valid Phone Numbers:
				 * 
				 *  123-456-7890
				 *	(123) 456-7890
				 *	123 456 7890
				 *	123.456.7890
				 *	+1 (123) 456-7890
				 *
				 * source: https://stackoverflow.com/questions/16699007/regular-expression-to-match-standard-10-digit-phone-number
				 */
				
				errors.rejectValue(Validations.USER_PHONE_NUMBER, HttpStatus.BAD_REQUEST.toString(), Validations.USER_PHONE_NUMBER_DEFAULT_MESSAGE);
			}
		}
		
		if (!Strings.isEmpty(user.getEmail())) {
			if(!user.getEmail().matches(RegexPatterns.VALID_EMAIL_FORMAT)) {
				
				/*
				 * Email Rules:
				 * 
				 * It allows numeric values from 0 to 9
				 * Both uppercase and lowercase letters from a to z are allowed
				 * Allowed are underscore "_", hyphen "-" and dot "."
				 * Dot isn't allowed at the start and end of the local-part
				 * Consecutive dots aren't allowed
				 * For the local part, a maximum of 64 characters are allowed
				 * It allows numeric values from 0 to 9
				 * We allow both uppercase and lowercase letters from a to z
				 * Hyphen "-" and dot "." isn't allowed at the start and end of the domain-part
				 * No consecutive dots
				 * 
				 * Source: https://www.baeldung.com/java-email-validation-regex
				 * 
				 */
				
				errors.rejectValue(Validations.USER_EMAIL, HttpStatus.BAD_REQUEST.toString(), Validations.USER_EMAIL_DEFAULT_MESSAGE);
			}
		}
	}
}
