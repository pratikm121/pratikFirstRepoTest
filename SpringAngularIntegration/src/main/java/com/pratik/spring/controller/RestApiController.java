package com.pratik.spring.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
 
	@RequestMapping("/api/hi")
	public String hi() {
		return "Hello world! >>> Message from <a href='http://javasampleapproach.com' target='_blank'>JavaSampleApproach.com</a>";
	}
}
