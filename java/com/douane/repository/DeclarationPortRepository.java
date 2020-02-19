package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.BaeDpw;
import com.douane.entities.DeclarationPort;

public interface DeclarationPortRepository extends  JpaRepository<DeclarationPort, Long> {
	
	@Query("SELECT d FROM  DeclarationPort d WHERE d.flag =  false ")
	public List<DeclarationPort>  getNotMarked () ; 
    
	@Modifying
	@Transactional
	@Query(value = "update declaration_port  set  flag='t' where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	@Query("Select Count(*) from DeclarationPort WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  DeclarationPort where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 
	
	@Query("SELECT  b FROM  DeclarationPort b WHERE b.id between :start and  :end  ")
	public List<DeclarationPort> getDataBetweenIs(@Param("start") long start ,@Param("end") long end ); 

}
