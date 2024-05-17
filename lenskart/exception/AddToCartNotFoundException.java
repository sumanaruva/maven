package com.lenskart.exception;

public class AddToCartNotFoundException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	public AddToCartNotFoundException()
	{
		super();
		
	}
	public AddToCartNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
