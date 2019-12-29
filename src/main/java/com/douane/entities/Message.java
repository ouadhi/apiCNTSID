package com.douane.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.ws.rs.core.Link;



public class Message<T> {
	
	private String id ; 
	
	private int  count  ; 
	
	private Long start_id ; 
	
	private Long end_id ; 
	
	private  String description ;  
	
	private Link  marked_link ;
	
	private List<T>  contant ; 
	
	private Date marekedDate  ; 
	
	public Message() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Link getMarked_link() {
		return marked_link;
	}

	public Long getStart_id() {
		return start_id;
	}

	public void setStart_id(Long start_id) {
		this.start_id = start_id;
	}

	public Long getEnd_id() {
		return end_id;
	}

	public void setEnd_id(Long end_id) {
		this.end_id = end_id;
	}

	public void setMarked_link(Link marked_link) {
		this.marked_link = marked_link;
	}

	public List<T> getContant() {
		return contant;
	}

	public void setContant(List<T> contant) {
		this.contant = contant;
	}

	public Date getMarekedDate() {
		return marekedDate;
	}

	public void setMarekedDate(Date marekedDate) {
		this.marekedDate = marekedDate;
	} 
	
	
	
	
}
