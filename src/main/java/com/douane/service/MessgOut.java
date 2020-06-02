package com.douane.service;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.db.dialect.MsSQLDialect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessgOut {
	
	
	List<MsgOutItem> items =  new ArrayList<MsgOutItem>() ; 
	
	
	
	public  boolean  addItem  (MsgOutItem item ) {
		 return this.items.add(item) ; 
	}
	
	
	
}
