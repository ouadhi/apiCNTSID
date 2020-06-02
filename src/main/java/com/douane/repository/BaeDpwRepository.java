package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.BaeDpw;

public interface BaeDpwRepository extends JpaRepository<BaeDpw, Long> {
	
	@Query("SELECT  b FROM  BaeDpw b WHERE b.flag=false")
	public List<BaeDpw> getDataNotMarked(); 
	
	@Modifying
	@Transactional
	@Query(value = "update bae_dpw  set  flag= 1   where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") long start ,@Param("end") long end  ) ; 
	
	@Query("Select Count(*) from BaeDpw WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("Select Count(*) from BaeDpw WHERE  flag  = true ")
	public int getCountConsumed () ; 
	
	@Query("select new map(min(id) as start ,  max(id) as end ) from  BaeDpw where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 
	
	@Query("SELECT  b FROM  BaeDpw b WHERE b.id between :start and  :end  ")
	public List<BaeDpw> getDataBetweenIs(@Param("start") long start ,@Param("end") long end ); 

}
