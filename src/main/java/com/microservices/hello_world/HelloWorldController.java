package com.microservices.hello_world;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	
	@GetMapping("/hello-world")
	public String hello()
	{
		return "Hello from rest app v2.";
	}
}
