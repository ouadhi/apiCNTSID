package com.douane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douane.entities.ToDoItem;

public interface TodoItemRepository  extends  JpaRepository<ToDoItem, Integer> {

}
