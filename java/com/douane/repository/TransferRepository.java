package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.BaeDpw;
import com.douane.entities.Transfer;

public interface TransferRepository  extends  JpaRepository<Transfer, Long>{
	
	@Query("SELECT t FROM Transfer t WHERE t.flag = false  ")
	public List<Transfer> getDataNotMarked() ; 
	
	@Modifying
	@Transactional
	@Query(value = "update Transfer  set  flag='t' where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	@Query("Select Count(*) from Transfer WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  Transfer where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 
	
	@Query("SELECT  b FROM  Transfer b WHERE b.id between :start and  :end  ")
	public List<Transfer> getDataBetweenIs(@Param("start") long start ,@Param("end") long end ); 

	

}


