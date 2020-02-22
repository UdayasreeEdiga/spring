package com.cts.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("a1")
public class GreetServiceAdvancedImpl implements GreetService {
	
	@Autowired
	@Qualifier("gnp")
	private GreetNoteProvider gmp;
	
	public GreetServiceAdvancedImpl() {
		
	}

	public GreetServiceAdvancedImpl(GreetNoteProvider gmp) {
		super();
		this.gmp = gmp;
	}

	public GreetNoteProvider getGmp() {
		return gmp;
	}

	public void setGmp(GreetNoteProvider gmp) {
		this.gmp = gmp;
	}

	public String greet(String userName) {
		// TODO Auto-generated method stub
		return gmp.getGreetNote()+" "+userName;
	}
	
}
