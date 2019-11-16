package com.douane.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.douane.entities.ContainersDpw;

public interface ContainersDpwRepository  extends  JpaRepository<Long, ContainersDpw>{
	
	@Query("SELECT c FROM  ContainersDpw c  WHERE c.flag = false ")
	public List<ContainersDpw>  getDataNotMarked () ;


}
