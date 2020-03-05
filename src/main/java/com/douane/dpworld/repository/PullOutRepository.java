package com.douane.dpworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.douane.dpworld.entities.SortiePhysique;



public interface PullOutRepository extends   JpaRepository<SortiePhysique, Integer> {

}
