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
import com.douane.config.service.AppConfigService;
import com.douane.dpworld.entities.ConteneurParcVisite;
import com.douane.dpworld.repository.ContneurParcVisiteRepository;
import com.douane.securite.config.JwtTokenUtil;
import com.douane.securite.service.JwtUserDetailsService;


@SpringBootApplication
//@EnableScheduling

public class DouaneServiceProjectApplication  implements   CommandLineRunner {
	 
	@Autowired  
	private JwtUserDetailsService   detailsService  ; 
	@Autowired
	private AppConfigService  confService ; 
	
	
	
	@Bean
	public RestTemplate getRestTemplate () {
		return  new  RestTemplate()  ; 
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(DouaneServiceProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		detailsService.initRole();
		confService.intConfig();
	     		
	}
	



	

}
