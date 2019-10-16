package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.CparcVisite;

public interface  CparcVisiteRepository extends  JpaRepository<CparcVisite, Long>{
	
	@Query("SELECT  c FROM  CparcVisite  c WHERE c.flag =  false ")
	public List<CparcVisite>  getDataNotMarked () ; ; 

}
