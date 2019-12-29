package com.douane;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douane.entities.ToDoItem;
import com.douane.repository.TodoItemRepository;

@SpringBootApplication
public class DouaneServiceProjectApplication {
	 
	@Autowired  
	private  TodoItemRepository  itemRepository ; 
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
