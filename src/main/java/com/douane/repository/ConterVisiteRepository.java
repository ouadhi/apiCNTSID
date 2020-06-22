package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.BaeDpw;
import com.douane.entities.Contrevisite;
import com.douane.entities.Cparcvisite;


public interface ConterVisiteRepository  extends  JpaRepository<Contrevisite, Long>{
	@Query("SELECT  c FROM  Contrevisite  c where flag = 0 ")
	public List<Contrevisite>  getDataNotMarked () ; 
	
	@Modifying
	@Transactional
	@Query(value = "update Contrevisite  set  flag=1 where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	@Query("Select Count(*) from Contrevisite  where flag = 0")
	public int getCount () ; 
	
	@Query("Select Count(*) from Contrevisite WHERE  flag  = 1 ")
	public int getCountConsumed () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  Contrevisite where flag = 0   ")
	public List<Map<String, Object>> findStartEndId() ; 
	
	@Query("SELECT  b FROM  Contrevisite b WHERE b.id between :start and  :end  ")
	public List<Contrevisite> getDataBetweenIs(@Param("start") long start ,@Param("end") long end ); 


}
