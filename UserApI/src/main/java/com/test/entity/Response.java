package com.test.entity;

public class Response {
	
	
	private String message;
	
	public Response()
	{
		
	}
	

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Response(String message) {
	
		this.message = message;
	}

}
