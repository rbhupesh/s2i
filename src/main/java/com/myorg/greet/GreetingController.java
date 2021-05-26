package com.myorg.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myorg.greet.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService helloService;

	@GetMapping("/api/v2/greeting/{id}")
	public HttpEntity<String> getGreetV2(
			@PathVariable("id") String id) {		
		System.out.println("##### GreetingController.getGreetV2() STARTED!!!  #####");

		String str =helloService.greeting(id);		
		ResponseEntity<String> reString = new ResponseEntity<String>(str, HttpStatus.OK);

		return reString;
	}
}

