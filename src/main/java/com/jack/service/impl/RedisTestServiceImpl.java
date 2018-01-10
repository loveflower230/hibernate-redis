package com.jack.service.impl;

import com.jack.service.RedisTestService;

public class RedisTestServiceImpl implements RedisTestService {

	public String getTimestamp(String param) {
		System.out.println("go to service");
//		  Long timestamp = System.currentTimeMillis();
	      return "testing";
	}

}
