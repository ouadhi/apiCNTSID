package com.dpworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dpworld.entities.SortiePhysique;

public interface PullOutRepository extends   JpaRepository<SortiePhysique, Integer> {

}
