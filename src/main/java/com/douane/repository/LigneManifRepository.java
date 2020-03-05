package com.douane.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.douane.entities.LigneManif;

public interface LigneManifRepository extends JpaRepository<LigneManif, Long> {
	
	@Query("SELECT lign FROM LigneManif lign  WHERE lign.flag = false  ")
	public List<LigneManif> getDataNotMarked() ;  
	
	@Modifying
	@Transactional
	@Query(value = "update ligne_manif  set  flag='t' where id between :start and  :end  ", nativeQuery = true)
	public void setMareked(@Param("start") Long start ,@Param("end") Long end  ) ; 
	
	@Query("Select Count(*) from LigneManif WHERE  flag  = false ")
	public int getCount () ; 
	
	@Query("select new  map(min(id) as start ,  max(id) as end ) from  LigneManif where flag='f' ")
	public List<Map<String, Object>> findStartEndId() ; 

}
