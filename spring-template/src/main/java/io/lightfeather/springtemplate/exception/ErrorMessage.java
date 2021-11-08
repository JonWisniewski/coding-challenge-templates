package io.lightfeather.springtemplate.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ErrorMessage {
	
	private int statusCode;
	private String timestamp;
	
    @JsonInclude(value = Include.NON_NULL)
	private String message;
    
    @JsonInclude(value = Include.NON_NULL)
	private List<String> defaultMessages;

	public ErrorMessage(int statusCode, String timestamp, String message) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.message = message;
	}
	
	public ErrorMessage(int statusCode, String timestamp, List<String> defaultMessages) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.defaultMessages = defaultMessages;
	}
		
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
