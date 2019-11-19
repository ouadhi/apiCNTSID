package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.VoyageGro;

public interface VoyageGrosRepository  extends  JpaRepository<VoyageGro,Long>{
	
	@Query("SELECT v  FROM  VoyageGro v  WHERE v.flag  =  false   ")
	public  List<VoyageGro> getDataNotMarked (); 
}
