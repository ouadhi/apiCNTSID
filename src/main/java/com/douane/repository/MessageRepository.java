package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douane.entities.BaeDpw;
import com.douane.entities.MessageDAO;
import com.douane.service.MessageType;

public interface MessageRepository extends JpaRepository<MessageDAO, Long> {
	
	@Query("SELECT  m FROM  MessageDAO m WHERE m.type =:type")
	public List<MessageDAO> getMessagesByType( @Param("type") MessageType type ) ; 
	
	
}
