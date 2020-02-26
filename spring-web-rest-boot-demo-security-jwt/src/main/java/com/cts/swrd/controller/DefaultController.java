package com.cts.swrd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {
	
	@GetMapping
	public ResponseEntity<String> dafaultGetRequestHandler() {
		return new ResponseEntity<String>("Welcome",HttpStatus.OK);
	}

}
