package com.douane.service;

import java.util.ArrayList;
import java.util.List;

import com.douane.entities.Message;
import com.douane.entities.MessageDAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class MessgIn {
	
	private List<MessageInItem> items = new ArrayList<>(); 

	
	public boolean additem(MessageInItem  item) {
		return this.items.add(item) ; 
	}
	
	
	
}
