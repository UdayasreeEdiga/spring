package com.cts.services;

import org.springframework.stereotype.Component;

@Component("g1")
public class GreetServiceSimpleImpl implements GreetService {

	public String greet(String userName) {
		// TODO Auto-generated method stub
		return "Hello"+" "+userName;
	}

}
