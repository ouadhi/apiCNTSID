package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.Manifeste;


public interface ManifesteRepository extends JpaRepository<Manifeste, Long>{
	
	@Query("SELECT  b FROM  Manifeste b WHERE b.flag=false")
	public List<Manifeste> getDataNotMarked(); 
	
	@Modifying
	@Transactional
	@Query(value = "update Manifeste  set  flag='t' where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") long start ,@Param("end") long end  ) ; 
	
	@Query("Select Count(*) from Manifeste WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  Manifeste where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 

}
