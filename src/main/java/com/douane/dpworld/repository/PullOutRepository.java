package com.douane.dpworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.dpworld.entities.SortiePhysique;



public interface PullOutRepository extends   JpaRepository<SortiePhysique, Integer> {
	
	
	@Query("Select Count(*) from SortiePhysique  ")
	public int count_all ();
	
	@Query("Select Count(*) from SortiePhysique c where date(c.Ajoute) = CURRENT_DATE ")
	public int count_today ();

}
