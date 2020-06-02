package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douane.entities.BaeDpw;
import com.douane.entities.MessageDAO;

public interface MessageRepository extends JpaRepository<MessageDAO, Long> {
	
	@Query("SELECT  m FROM  MessageDAO m WHERE m.messageName  like %:type%")
	public List<MessageDAO> getMessagesByType( @Param("type")  String  type ) ; 
	
	
}
