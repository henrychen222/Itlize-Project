package com.dev.aop.logger;

import org.aspectj.lang.JoinPoint;

public class AspectLogger {
	
	
	public void logEntry(JoinPoint joinPoint) {
		System.out.println("Currently in " + joinPoint.getSignature().getName() + "()  :: Args = "+joinPoint.getArgs());
	}

	public void logExit(JoinPoint joinPoint) {
		System.out.println("Currently in " + joinPoint.getSignature().getName() + "()");
	}

	public void logAroundAdvice(JoinPoint joinPoint) {
		System.out.println("Currently in " + joinPoint.getSignature().getName() + "()");
	}

	public void logExitAfterReturn(JoinPoint joinPoint) {
		System.out.println("Currently in " + joinPoint.getSignature().getName() + "()");
	}

	public void logAfterThrowsAdvice(JoinPoint joinPoint) {
		System.out.println("Currently in " + joinPoint.getSignature().getName() + "()");
	}

	public static void log(String LogMessage) {
		System.err.println(LogMessage);
	}
}
