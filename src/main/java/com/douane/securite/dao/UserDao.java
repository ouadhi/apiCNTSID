package com.douane.securite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.douane.securite.model.DAOUser;



@Repository
public interface UserDao extends JpaRepository<DAOUser, Long> {
	
	DAOUser findByUsername(String username);
	
}