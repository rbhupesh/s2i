package com.myorg.greet.service.impl;

import com.myorg.greet.service.GreetingService;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String greeting(String str) {
		return "Hello : "+str+" !!!";
	}
}
