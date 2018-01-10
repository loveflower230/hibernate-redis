package com.jack.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jack.service.RedisTestService;

public class RedisTestServiceTest extends SpringTestCase {

	@Autowired
	private RedisTestService redisService;
	
	@Test
	public void testGetTimeStamp() throws InterruptedException{
		System.out.println("first: "+ redisService.getTimestamp("param"));
		Thread.sleep(2000);
		System.out.println("second: " + redisService.getTimestamp("param"));
		Thread.sleep(5000);
		System.out.println("third: " + redisService.getTimestamp("param"));
	}
}
