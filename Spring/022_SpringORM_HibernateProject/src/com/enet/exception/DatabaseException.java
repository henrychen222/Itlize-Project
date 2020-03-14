package com.enet.exception;

public class DatabaseException extends NestingException {
	private static final long serialVersionUID = 9102791551777200510L;
	private String dbMsg;

	public DatabaseException(String msg) {
		super(msg);
		dbMsg = msg;
	}

	public DatabaseException(Exception nestedException) {
		super(nestedException);
	}

	public DatabaseException(String message, Exception nestedException) {
		super(message, nestedException);
	}

	public String getMessage() {
		return dbMsg;
	}
}