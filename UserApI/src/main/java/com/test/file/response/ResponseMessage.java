package com.test.file.response;

public class ResponseMessage {
	
	private String message;
     private int statusCode;
	public ResponseMessage(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
	return statusCode;
}

public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseMessage(String message) {
		super();
		this.message = message;
	}

}
