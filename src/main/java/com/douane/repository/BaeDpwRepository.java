package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.BaeDpw;

public interface BaeDpwRepository extends JpaRepository<BaeDpw, Long> {
	
	@Query("SELECT  b FROM  BaeDpw b WHERE b.flag=false")
	public List<BaeDpw> getDataNotMarked();  

}
