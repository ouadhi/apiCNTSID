package com.douane.dpworld.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.dpworld.entities.Debarquement;



public interface DebarquementRepository extends  JpaRepository<Debarquement, Integer> {
	
	@Query("Select Count(*) from Debarquement  ")
	public int count_all ();
	
	@Query("Select Count(*) from Debarquement c where date(c.ajoute)  = today ")
	public int count_today ();

}
