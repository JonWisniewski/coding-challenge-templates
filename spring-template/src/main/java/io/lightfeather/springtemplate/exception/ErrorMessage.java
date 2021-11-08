package io.lightfeather.springtemplate.exception;

import java.util.List;

public class ErrorMessage {
	private int statusCode;
	private String timestamp;
	private String message;
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
