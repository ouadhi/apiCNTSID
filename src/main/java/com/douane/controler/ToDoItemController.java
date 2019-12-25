package com.douane.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.entities.ToDoItem;
import com.douane.repository.TodoItemRepository;

@RestController
@RequestMapping("/api/todo")

public class ToDoItemController {
	
	@Autowired
	private TodoItemRepository repo ; 
	
	@GetMapping(path = "/get")
	public List<ToDoItem> findNotMarkedt ()  {
		return repo.findAll() ; 
	}
	
	@GetMapping(path = "/hello")
	public String  sayhello ()  {
		return "hello"; 
	}
	
	@PostMapping(path = "/save")
	public void save(@RequestBody ToDoItem  item) {
		
		repo.save(item) ; 
		
	}

}
