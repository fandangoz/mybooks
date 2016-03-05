package com.mybooks.config;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Apect to log operations on books
 */
@Aspect
public class MyBooksLogger {
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Intercept method Services method's calls and Log informations about them
	 */
	@Before("execution(* com.mybooks.service.*.*(..))")
	public void log(JoinPoint point) {
		logger.info(String.format("Method %s from service %s was called", point.getSignature().getName(),
				point.getTarget().getClass().getName()));
	}
}
