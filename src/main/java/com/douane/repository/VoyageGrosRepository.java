package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.VoyageGros;

public interface VoyageGrosRepository  extends  JpaRepository<VoyageGros,Long>{
	
	@Query("SELECT v  FROM  VoyageGros v  WHERE v.flag  =  false   ")
	public  List<VoyageGros> getDataNotMarked (); 
}