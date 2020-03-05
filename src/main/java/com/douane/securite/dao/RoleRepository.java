package com.douane.securite.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douane.securite.model.Role;

public interface RoleRepository  extends  JpaRepository<Role,Long> {
	
	
	@Query("SELECT r FROM  Role r WHERE name = :name ")
	public Role getRoleByName(@Param("name") String name ) ;   

}
