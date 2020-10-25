package com.douane.dpworld.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douane.dpworld.entities.SortiePhysique;
import com.douane.entities.BaeDpw;



public interface PullOutRepository extends   JpaRepository<SortiePhysique, Integer> {
	
	
	@Query("Select Count(*) from SortiePhysique  ")
	public int count_all ();
	
	@Query("Select Count(*) from SortiePhysique c where date(c.Ajoute) = today  ")
	public int count_today ();
	
	
	@Query("Select Count(*) from SortiePhysique c where date(c.Ajoute) = date(:date)  ")
	public int countByDate (@Param("date") Date date );
	
	@Query("SELECT  b FROM  SortiePhysique b WHERE b.id between :start and  :end  ")
	public List<BaeDpw> getDataBetweenIs(@Param("start") long start ,@Param("end") long end ); 

}
