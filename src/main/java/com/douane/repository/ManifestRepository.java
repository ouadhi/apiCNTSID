package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.Manifest;

public interface ManifestRepository extends JpaRepository<Manifest, Integer>{
	
	@Query("SELECT m FROM Manifest m WHERE m.flag= false ")
	public List<Manifest> getDataNoMarked() ; 

}
