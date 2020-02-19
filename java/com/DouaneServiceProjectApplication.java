package com;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.douane.config.Properties;
import com.douane.securite.config.JwtTokenUtil;
import com.douane.securite.service.JwtUserDetailsService;

import com.dpworld.*;
import com.dpworld.entities.SortiePhysique;


@SpringBootApplication
@EnableScheduling
//@ComponentScan(basePackages = "com")
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
		
		
		final String uri = "http://localhost:8085/api/pulout/getdata"; 
		ResponseEntity<SortiePhysique[]> resppnse =  template.getForEntity(uri, SortiePhysique[].class)  ; 
		
		SortiePhysique[] liste  =  resppnse.getBody()  ;  
		
		for (SortiePhysique sortiePhysique : liste) {
			System.out.println(sortiePhysique.getId());
		}
	     		
	}
	



	

}
