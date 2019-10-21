package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.DeclarationDpw;

public interface DeclarationDpwRepository extends  JpaRepository<DeclarationDpw, Long> {
	
	@Query("SELECT d  FROM DeclarationDpw  d WHERE d.flag=  false ")
	public List<DeclarationDpw>  getDataNotMarked();   

}
