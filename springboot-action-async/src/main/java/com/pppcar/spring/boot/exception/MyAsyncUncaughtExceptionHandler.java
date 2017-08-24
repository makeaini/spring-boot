package com.pppcar.spring.boot.exception;

import java.lang.reflect.Method;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
public class MyAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

	@Override
	public void handleUncaughtException(Throwable throwable, Method method, Object... args) {
	    System.out.println("Method Name::"+method.getName());
        System.out.println("Exception occurred::"+ throwable);
	}

}
