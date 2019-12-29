package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.Dstr;

public interface DstrRepository extends JpaRepository<Dstr, Long>{
	
	@Query("SELECT d FROM Dstr d WHERE d.flag = false  ")
	public List<Dstr>  getDataNotMarked() ; 
	
	@Modifying
	@Transactional
	@Query(value = "update Dstr  set  flag='t' where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	@Query("Select Count(*) from Dstr WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  Dstr where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 

}
