package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.BaeDpw;
import com.douane.entities.DeclarationDpw;

public interface DeclarationDpwRepository extends  JpaRepository<DeclarationDpw, Long> {
	
	@Query("SELECT d  FROM DeclarationDpw  d WHERE d.flag=  false ")
	public List<DeclarationDpw>  getDataNotMarked();   
	
	@Modifying
	@Transactional
	/*
	 * informix  query   style we  use  in boolean type  t=  true  , and  f  =  flase  ,  
	 * mysql we use  degit  items  0  true   and  1  = false  
	 */
	//@Query(value = "update declaration_dpw  set  flag='t' where id between :start and  :end  ", nativeQuery = true) informix 
	@Query(value = "update declaration_dpw  set  flag= 1 where id between :start and  :end  ", nativeQuery = true) 
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	@Query("Select Count(*) from DeclarationDpw WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("Select Count(*) from DeclarationDpw WHERE  flag  = true ")
	public int getCountConsumed () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  DeclarationDpw where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 
	
	@Query("SELECT  b FROM  DeclarationDpw b WHERE b.id between :start and  :end  ")
	public List<DeclarationDpw> getDataBetweenIs(@Param("start") long start ,@Param("end") long end ); 


}
