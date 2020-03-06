package com.in28minutes.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * HelloWorldControllerTest
 *
 * @author created by Urs Albisser, on 2020-01-06
 * @version 0.0.1
 */
//@RunWith(SpringRunner.class) // JUnit 4
@ExtendWith(SpringExtension.class) // JUnit 5
@WebMvcTest(value=HelloWorldController.class) // @WebMvcTest(value=ClassToBeTested.class): WebMvcTest framework
public class HelloWorldControllerTest {

	// == fields ==
	@Autowired
	private MockMvc mockMvc;


	// == JUnit tests ==
	@Test
	public void helloWorld_basic() throws Exception {

		// call a GET-request to "/hello-world" return the data in application/json format
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/hello-world")
				.accept(MediaType.APPLICATION_JSON);

		// build/execute a "/hello-world" request and stub the result (=content of the page)
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

		// verify "/hello-world"
		assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
	}
}
