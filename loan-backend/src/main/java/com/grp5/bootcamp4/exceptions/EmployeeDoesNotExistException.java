package com.grp5.bootcamp4.exceptions;


public class EmployeeDoesNotExistException extends Exception {
	private static final long serialVersionID = 1L;
	private String message;
	
	public EmployeeDoesNotExistException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}