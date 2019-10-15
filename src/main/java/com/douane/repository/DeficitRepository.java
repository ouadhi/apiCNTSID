package com.douane.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douane.entities.Deficit;

public interface DeficitRepository extends  JpaRepository<Deficit, Long> {

}
