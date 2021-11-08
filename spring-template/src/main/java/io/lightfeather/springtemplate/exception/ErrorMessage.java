package io.lightfeather.springtemplate.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * ErrorMessage is the response body that is used for errors
 * 
 * @author Jonathan Wisniewski
 * @since  11-08-2021
 */

public class ErrorMessage {
	
	private int statusCode;
	private String timestamp;
	
    @JsonInclude(value = Include.NON_NULL)
	private String message;
    
    @JsonInclude(value = Include.NON_NULL)
	private List<String> defaultMessages;

	/**
	 * Constructor with parameters of statusCode, timestamp, and message
	 * 
	 * @param statusCode HTTP status code
	 * @param timestamp time the error occurred
	 * @param message error response
	 */
    
	public ErrorMessage(int statusCode, String timestamp, String message) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
	}
	
	/**
	 * Constructor with parameters of statusCode, timestamp, and defaultMessages
	 * 
	 * @param statusCode HTTP status code
	 * @param timestamp time the error occurred
	 * @param defaultMessages field error messages
	 */
	
	public ErrorMessage(int statusCode, String timestamp, List<String> defaultMessages) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.defaultMessages = defaultMessages;
	}
	
	/**
	 * Constructor with parameters of statusCode, timestamp, and message
	 * 
	 * @param statusCode HTTP status code
	 * @param timestamp time the error occurred
	 * @param message error response
	 * @param defaultMessages field error messages
	 */
		
	public ErrorMessage(int statusCode, String timestamp, String message, List<String> defaultMessages) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
		this.defaultMessages = defaultMessages;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}
	
	public List<String> getDefaultMessages() {
		return defaultMessages;
	}
}
