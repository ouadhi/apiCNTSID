package com.douane.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.douane.service.MessageType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String messageName;
	
	private MessageType type ; 

	private long start;

	private long end;

	private Date saveDate;

	private String user_name;

	
	

}
