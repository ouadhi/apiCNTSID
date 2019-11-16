package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.Contrevisite;


public interface ConterVisiteRepository  extends  JpaRepository<Contrevisite, Long>{
	@Query("SELECT  c FROM  Contrevisite  c WHERE c.flag =  false ")
	public List<Contrevisite>  getDataNotMarked () ; ; 

}
