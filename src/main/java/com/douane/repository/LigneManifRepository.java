package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.LigneManif;

public interface LigneManifRepository extends JpaRepository<LigneManif, Long> {
	
	@Query("SEELCT l FROM LigneManif l  WHERE l.flag = false  ")
	public List<LigneManif> getDataNotMarked() ;  

}
