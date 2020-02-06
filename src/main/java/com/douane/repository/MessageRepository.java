package com.douane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douane.entities.MessageDAO;

public interface MessageRepository extends JpaRepository<MessageDAO, Long> {

}
