package com.BookOrderManagement.exceptions;

public class OrderAlreadyExistsExceptions extends RuntimeException{
	public OrderAlreadyExistsExceptions(String msg)
	{
		super(msg);
	}
}
