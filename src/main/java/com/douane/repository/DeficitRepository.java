package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.Deficit;

public interface DeficitRepository extends  JpaRepository<Deficit, Long> {
	@Query("SELECT c FROM Deficit c WHERE c.flag = false  ")
	public List<Deficit>  getDataNoMarked ()  ;

}
