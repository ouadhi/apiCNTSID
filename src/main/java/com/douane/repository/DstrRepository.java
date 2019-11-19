package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.Dstr;

public interface DstrRepository extends JpaRepository<Dstr, Long>{
	
	@Query("SELECT d FROM Dstr d WHERE d.flag = false  ")
	public List<Dstr>  getDataNotMarked() ; 

}
