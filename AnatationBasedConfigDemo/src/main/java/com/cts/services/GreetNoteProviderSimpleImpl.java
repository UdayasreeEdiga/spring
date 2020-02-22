package com.cts.services;


import org.springframework.stereotype.Component;

@Component("gnp1")
public class GreetNoteProviderSimpleImpl implements GreetNoteProvider {

	public String getGreetNote() {
		// TODO Auto-generated method stub
		return "Welcome";
	}

}
