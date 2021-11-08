package io.lightfeather.springtemplate.util;

import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import io.lightfeather.springtemplate.constants.RegexPatterns;
import io.lightfeather.springtemplate.constants.Validations;
import io.lightfeather.springtemplate.model.User;

/**
 * UserValidator is a validation class used to check if the requestBody of api/submit contains any errors
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		if (clazz.isInstance(User.class)) {

			return true;
		}

		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.USER_FIRST_NAME,
				Validations.USER_FIRST_NAME_ERROR_CODE, Validations.USER_FIRST_NAME_DEFAULT_MESSAGE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.USER_LAST_NAME,
				Validations.USER_LAST_NAME_ERROR_CODE, Validations.USER_LAST_NAME_DEFAULT_MESSAGE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.USER_SUPERVISOR,
				Validations.USER_SUPERVISOR_ERROR_CODE, Validations.USER_SUPERVISOR_DEFAULT_MESSAGE);

		if (!errors.hasFieldErrors(Validations.USER_SUPERVISOR)) {
			
			/*
			 * Since firstName, lastName, and jurisdiction are required for Supervisor model, 
			 * I transfered the requirements to the User model when submitting a POST request for personal information
			 * 
			 * As of now id, identificationNumber, and phone are not required so I will not validate it
			 */

			ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.SUPERVISOR_FIRST_NAME,
					Validations.SUPERVISOR_FIRST_NAME_ERROR_CODE, Validations.SUPERVISOR_FIRST_NAME_DEFAULT_MESSAGE);
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.SUPERVISOR_LAST_NAME,
					Validations.SUPERVISOR_LAST_NAME_ERROR_CODE, Validations.SUPERVISOR_LAST_NAME_DEFAULT_MESSAGE);
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, Validations.SUPERVISOR_JURISDICTION,
					Validations.SUPERVISOR_JURISDICTION_ERROR_CODE, Validations.SUPERVISOR_JURISDICTION_DEFAULT_MESSAGE);

			if (!Strings.isBlank(user.getSupervisor().getPhone()))
				if (!user.getSupervisor().getPhone().matches(RegexPatterns.USA_VALID_PHONE_NUMBER_FORMAT)) {

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
				
				errors.rejectValue(Validations.SUPERVISOR_PHONE_NUMBER, HttpStatus.BAD_REQUEST.toString(),
						Validations.SUPERVISOR_PHONE_NUMBER_DEFAULT_MESSAGE);
			}
		}

		if (!Strings.isBlank(user.getPhoneNumber())) {
			if (!user.getPhoneNumber().matches(RegexPatterns.USA_VALID_PHONE_NUMBER_FORMAT)) {

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
		
		if (!Strings.isBlank(user.getEmail())) {			
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
