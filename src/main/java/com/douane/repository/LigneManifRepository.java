package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.LigneManif;

public interface LigneManifRepository extends JpaRepository<LigneManif, Long> {
	
	@Query("SELECT lign FROM LigneManif lign  WHERE lign.flag = false  ")
	public List<LigneManif> getDataNotMarked() ;  

}
