package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.DebarquementManifeste;

public interface DebarquementManifestRepositroy extends JpaRepository<DebarquementManifeste, Long >{
	
	@Query("SELECT d FROM DebarquementManifeste d WHERE d.flag=false ")
	public  List<DebarquementManifeste>  getDataNotMarked();   

}
