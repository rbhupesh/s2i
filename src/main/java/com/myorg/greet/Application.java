package com.myorg.greet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.myorg.greet.service.GreetingService;
import com.myorg.greet.service.impl.GreetingServiceImpl;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(title = "greeting service API",
		version = "1.0",
		description = "greeting service used for s2i demo"),
		servers = @Server(url = "https://www.rb-greeting.com",
		description = "spring-boot internal tomcat server is in use")
		)
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public GreetingService greetingService(){
		return new GreetingServiceImpl();
	}
	
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {		
			
			System.out.println("***************************************************************************");
			System.out.println("*s2i Service Started");
			System.out.println("http://localhost:8080/api/v2/greeting/xyz");
			System.out.println("***************************************************************************");
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/*
get http://localhost:8080//api/v2/greeting/xyz

*/


