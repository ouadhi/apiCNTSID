package com.douane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douane.entities.TodoItems;


public interface TodoDao extends JpaRepository<TodoItems, Integer>{

}
