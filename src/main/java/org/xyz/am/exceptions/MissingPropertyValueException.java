package org.xyz.am.exceptions;

public class MissingPropertyValueException extends Exception {
	private static final long serialVersionUID = 1L;

	public MissingPropertyValueException(String message) {
		super(message);
	}
}
