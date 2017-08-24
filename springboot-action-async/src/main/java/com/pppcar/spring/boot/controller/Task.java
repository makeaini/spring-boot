package com.pppcar.spring.boot.controller;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

@Component
public class Task {
	// 定义一个随机对象.
	public static Random random = new Random();

	// 任务一;
	@Async
	public void doTaskOne() throws Exception {
		System.out.println("开始做任务一");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
	}

	// 任务二;
	@Async
	public void doTaskTwo() throws Exception {
		System.out.println("开始做任务二");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
		System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
	}

	// 任务3;
	@Async
	public void doTaskThree() throws Exception {
		System.out.println("开始做任务三");
		long start = System.currentTimeMillis();
		Thread.sleep(random.nextInt(10000));
		long end = System.currentTimeMillis();
	    String a = null;
	    if(a == null){
	    	throw new Exception("出现异常");
	    }
		System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
	}
	@Async
	public Future<String> doTaskOne1() throws Exception {
	    System.out.println("开始做任务一");
	    long start = System.currentTimeMillis();
	    Thread.sleep(random.nextInt(10000));
	    long end = System.currentTimeMillis();
	    System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
	    String a = null;
	    if(a == null){
	    	throw new Exception("出现异常");
	    }
	    return new AsyncResult<String>("任务一完成");
	}

}