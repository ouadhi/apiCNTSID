package com.douane.dpworld.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.douane.dpworld.entities.Debarquement;



public interface DebarquementRepository extends  JpaRepository<Debarquement, Integer> {

}
