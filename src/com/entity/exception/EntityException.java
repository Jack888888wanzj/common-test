package com.entity.exception;

public class EntityException extends RuntimeException {
	 
	        /**
	 * @�ֶ����� serialVersionUID
	 * @˵����TODO
	        */  
	    
	private static final long serialVersionUID = 1L;

	public EntityException() {
	}

	public EntityException(String message) {
		super(message);
	}

	public EntityException(Throwable cause) {
		super(cause);
	}

	public EntityException(String message, Throwable cause) {
		super(message, cause);
	}
}
