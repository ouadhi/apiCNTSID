package com.douane;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.douane.config.Properties;



@SpringBootApplication
public class DouaneServiceProjectApplication {
	 
	public static void main(String[] args) {
		SpringApplication.run(DouaneServiceProjectApplication.class, args);
	}
	
	/*
  
	@Override
	public void run(String... args) throws Exception {
		ToDoItem  item =  new ToDoItem(); 
	
		item.setLastname("yacijn") ; 
		item.setName("moh");
		
		itemRepository.save(item)  ;
		
		System.out.println("lancement"); 
		
	}
	
	*/
	

	

}
