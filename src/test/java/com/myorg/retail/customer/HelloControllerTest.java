package com.myorg.retail.customer;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.myorg.greet.HelloController;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}
		
//	@Test
//	public void getGreetV2() throws Exception {
//		mvc.perform(MockMvcRequestBuilders
//				.get("/api/v2/greeting")
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//				//.andExpect(content().string(equalTo("Hello : xyz !!!")));;
//	}
	
	@Configuration
	static class ContextConfiguration {
		@Bean
		public HelloController controller()
		{
			return new HelloController();
		}
		
	
		
	}
	
}
