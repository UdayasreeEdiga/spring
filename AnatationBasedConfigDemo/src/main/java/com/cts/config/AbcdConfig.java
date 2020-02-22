package com.cts.config;

import java.time.LocalDate;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.cts.services")
public class AbcdConfig {
	@Bean
	public LocalDate today() {
		
		return LocalDate.now();
	}

}
