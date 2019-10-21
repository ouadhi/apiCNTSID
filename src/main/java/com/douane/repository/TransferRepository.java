package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.Transfer;

public interface TransferRepository  extends  JpaRepository<Transfer, Long>{
	
	@Query("SELECT t FROM Transfer t WHERE t.flag = false  ")
	public List<Transfer> getDataNotMarked() ; 

}
