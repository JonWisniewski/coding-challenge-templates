package io.lightfeather.springtemplate.constants;

/**
 * A class that is used for Regex Pattern Constants
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

public class RegexPatterns {

	public final static String USA_VALID_PHONE_NUMBER_FORMAT = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$";
	public final static String VALID_EMAIL_FORMAT = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	public final static String FIND_DIGITS  = ".*\\d.*";
}
