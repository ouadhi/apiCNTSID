package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.BaeDpw;
import com.douane.entities.ContainersDpw;

public interface ContainersDpwRepository  extends  JpaRepository<ContainersDpw, Long>{
	
	@Query("SELECT c FROM  ContainersDpw c  WHERE c.flag = false ")
	public List<ContainersDpw>  getDataNotMarked () ;
	
	@Modifying
	@Transactional
	@Query(value = "update containers_dpw  set  flag='t' where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	@Query("Select Count(*) from ContainersDpw WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  ContainersDpw where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 
	
	@Query("SELECT  b FROM ContainersDpw  b WHERE b.id between :start and  :end  ")
	public List<ContainersDpw> getDataBetweenId(@Param("start") long start ,@Param("end") long end );  

}
