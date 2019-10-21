package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.DeclarationPort;

public interface DeclarationPortRepository extends  JpaRepository<DeclarationPort, Long> {
	
	@Query("SELECT d FROM  DeclarationPort d WHERE d.flag =  false ")
	public List<DeclarationPort>  getNotMarked () ; 
}
