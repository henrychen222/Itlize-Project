package com.easylearn;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CafeOwner {
	
	//@Pointcut("execution(protected void browse(*))") //arguments must match
	//@Pointcut("execution(protected void browse(..))") //Optional
	@Pointcut("execution(* browse*(..))") //Optional
	public void getAll(){
		
	}

	@Before("getAll()")
	public void getLoginTime(JoinPoint joinPoint) {
		System.out.println(joinPoint.getSignature()+ " "+ Arrays.asList(joinPoint.getArgs())+"    ==>   Login Time=" + new Date() + " of the customer");
		//transaction.beginTransaction();
	}

	@After("getAll()")
	public void getLogoutTime() {
		System.out.println("Logout Time=" + new Date() + " of the customer");
		//transaction.commit();
	}

	@AfterReturning("getAll()")
	public void generateBill() {
		System.out.println("Calculate the bill amount and share it with customer");
	}
	
	@Around("getAll()")
	public void whileBrowse(ProceedingJoinPoint procJoinPoint){
		System.out.println("please check your browser history is cleared");
		try {
			procJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("please remove your browser histroy");
	}

}
