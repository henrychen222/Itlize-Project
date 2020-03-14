package com.enet.logger;

import org.aspectj.lang.JoinPoint;

public class GlobalLogger {

	public void methodEntry(JoinPoint joinPoint) {
		LogUtil.info(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() execution is started.");
		System.out.println(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() execution is started.");
	}

	public void methodExit(JoinPoint joinPoint) {
		LogUtil.info(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() execution is ended.");
		System.out.println(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() execution is ended.");
	}

	public void methodExitAfterReturn(JoinPoint joinPoint) {
		LogUtil.debug(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() is exited.");
		System.out.println(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() execution is exited.");
	}

	public void methodAfterThrowsAdvice(JoinPoint joinPoint, Exception exception) throws Exception {
		LogUtil.error(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() is throwed.");
		System.out.println(joinPoint.getTarget().getClass() + ":" + joinPoint.getSignature().getName() + "() execution is throwed.");
		LogUtil.error(exception);

	}

	public static void log(String LogMessage) {
		LogUtil.info(LogMessage);
	}
}