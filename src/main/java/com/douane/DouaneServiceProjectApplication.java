package com.douane;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.douane.config.Properties;
import com.douane.securite.config.JwtTokenUtil;
import com.douane.securite.service.JwtUserDetailsService;



@SpringBootApplication
public class DouaneServiceProjectApplication  implements   CommandLineRunner {
	 
	@Autowired  
	private JwtUserDetailsService   detailsService  ; 
	public static void main(String[] args) {
		SpringApplication.run(DouaneServiceProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		detailsService.initRole();
		
	}
	



	

}
