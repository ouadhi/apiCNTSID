package com.douane.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoItem {
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  int  id ; 
	
	private  String  name  ;  
	
	private  String  lastname  ;
	
	 
	public ToDoItem(int id, String name, String lastname) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
	}
	

	public ToDoItem() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	} 
	
	
	

}
