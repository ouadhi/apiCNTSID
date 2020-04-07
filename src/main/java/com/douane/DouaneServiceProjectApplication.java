package com.douane;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.douane.config.Properties;
import com.douane.securite.config.JwtTokenUtil;
import com.douane.securite.service.JwtUserDetailsService;




@SpringBootApplication
//@EnableScheduling

public class DouaneServiceProjectApplication  implements   CommandLineRunner {
	 
	@Autowired  
	private JwtUserDetailsService   detailsService  ; 
	
	
	
	@Bean
	public RestTemplate getRestTemplate () {
		return  new  RestTemplate()  ; 
	}
	
	@Autowired
	private RestTemplate  template ;  
	public static void main(String[] args) {
		SpringApplication.run(DouaneServiceProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		detailsService.initRole();
		
	     		
	}
	



	

}
