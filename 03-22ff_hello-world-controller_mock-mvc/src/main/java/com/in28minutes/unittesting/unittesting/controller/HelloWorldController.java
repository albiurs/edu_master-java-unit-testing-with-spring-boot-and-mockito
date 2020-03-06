package com.in28minutes.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorldController
 *
 * @author created by Urs Albisser, on 2020-01-06
 * @version 0.0.1
 */
@RestController	// turns class into a restful service
public class HelloWorldController {

	@GetMapping("/hello-world")	// url to be mapped to the method
	public String helloWorld() {
		return "Hello World";
	}
}
