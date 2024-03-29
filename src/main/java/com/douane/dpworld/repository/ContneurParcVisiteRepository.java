package com.douane.dpworld.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.douane.dpworld.entities.ConteneurParcVisite;


public interface ContneurParcVisiteRepository  extends  JpaRepository<ConteneurParcVisite, Integer>{
	
	@Query("Select Count(*) from ConteneurParcVisite ")
	public int count_all ();
	
	@Query("Select Count(*) from ConteneurParcVisite c where date(c.ajoute) = today ")
	public int count_today ();
	
	@Query("Select Count(*) from ConteneurParcVisite c where date(c.ajoute) = date(:date)  ")
	public int countByDate (@Param("date") Date date );
}
