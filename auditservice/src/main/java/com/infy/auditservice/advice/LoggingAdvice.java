package com.infy.auditservice.advice;

import java.util.Optional;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Aspect
@Component
public class LoggingAdvice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut(value = "execution(* com.infy.auditservice.*.*.*(..))")
	public void loggingPointCut() {
	}

	@Around("loggingPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		String className = pjp.getTarget().getClass().toString();
		String methodName = pjp.getSignature().getName();
		Object[] args = pjp.getArgs();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		logger.info(className + "::" + methodName + "::" + "Entered");
		try {
			logger.debug(className + "::" + methodName + ":: arguments" + mapper.writeValueAsString(args));
		} catch (JsonProcessingException e) {
			logger.error("Exception Occurred during Processing Argumentes in" + className + "::" + methodName);
			throw e;
		}
		Object response = Optional.empty();
		try {
			response = pjp.proceed();
			logger.debug(className + "::" + methodName + ":: response" + mapper.writeValueAsString(response));
		} catch (Throwable ex) {
			logger.error("Exception Occurred in " + className + "::" + methodName + "::" + ex);
			throw ex;
		}
		logger.info(className + "::" + methodName + "::" + "Exit");
		return response;
	}
}
