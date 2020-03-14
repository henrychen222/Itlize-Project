package com.enet.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

public class NestingException extends Exception {
	private static final long serialVersionUID = 1L;
	private Throwable nestedException;
	private String stackTraceString;

	public NestingException(String msg) {
		super(msg);
	}

	public NestingException(Throwable nestedException) {
		this.nestedException = nestedException;
		stackTraceString = generateStackTraceString(nestedException);
	}

	public NestingException(String msg, Throwable nestedException) {
		this(msg);
		this.nestedException = nestedException;
		stackTraceString = generateStackTraceString(nestedException);
	}

	public static String generateStackTraceString(Throwable t) {
		StringWriter s = new StringWriter();
		t.printStackTrace(new PrintWriter(s));
		return s.toString();
	}

	public Throwable getNestedException() {
		return nestedException;
	}

	public String getStackTraceString() {
		if (nestedException == null) {
			return null;
		}
		StringBuffer traceBuffer = new StringBuffer();
		if (nestedException instanceof NestingException) {
			traceBuffer.append(((NestingException) nestedException).getStackTraceString());
			traceBuffer.append("-------- nested by:\n");
		}
		traceBuffer.append(stackTraceString);
		return traceBuffer.toString();
	}

	public String getMessage() {
		// superMsg will contain whatever String was passed into the
		// constructor, and null otherwise.
		String superMsg = super.getMessage();

		// if there's no nested exception, do like we would always do
		if (getNestedException() == null)
			return superMsg;

		StringBuffer theMsg = new StringBuffer();
		String nestedMsg = getNestedException().getMessage(); 
		
		if (superMsg != null) {
			theMsg.append(superMsg).append(": ").append(nestedMsg);
		} else {
			theMsg.append(nestedMsg);
		}

		return theMsg.toString();
	}

	public String toString() {
		StringBuffer theMsg = new StringBuffer(super.toString());
		if (getNestedException() != null)
			theMsg.append("; \n\t---> nested ").append(getNestedException());
		return theMsg.toString();
	}
}