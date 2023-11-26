package com.mid.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mid.exception.BankException;

@Component
@Aspect
public class LoggingAspect {
	
	@Autowired
	Environment properties;
	Log LOGGER=LogFactory.getLog(LoggingAspect.class);
	
	@Before(value="execution(* com.mid.service.*.*(..))")
	public void beforeAdvice() throws BankException
	{
		LOGGER.debug("Going Inside service class method");
		
	}
	
	@AfterReturning(value="execution(* com.mid.service.*.*(..))", returning="returnValue")
	public void AfterReturningAdvice(String returnValue) throws BankException
	{
		LOGGER.info(properties.getProperty(returnValue));
	}
	

	
	@AfterThrowing(pointcut="execution(* com.mid.service.*.*(..))", throwing ="e")
	public void AfterException (BankException e) throws BankException
	{
		LOGGER.error(properties.getProperty(e.getMessage()),e);
		
	}
	
	

}
