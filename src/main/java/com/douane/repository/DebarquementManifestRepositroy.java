package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.DebarquementManifeste;

public interface DebarquementManifestRepositroy extends JpaRepository<DebarquementManifeste, Long >{
	
	@Query("SELECT d FROM DebarquementManifeste d WHERE d.flag= 0  ")
	public  List<DebarquementManifeste>  getDataNotMarked();   
	
	@Modifying
	@Transactional
	@Query(value = "update debarquement_manifeste  set  flag= 1 where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	// not consumed  
	@Query("Select Count(*) from DebarquementManifeste WHERE  flag  = 0 ")
	public int getCount () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  DebarquementManifeste where flag= 0 ")
	public List<Map<String, Object>> findStartEndId() ; 
	
	@Query("Select Count(*) from DebarquementManifeste WHERE  flag  = 1 ")
	public int getCountConsumed () ; 

}
