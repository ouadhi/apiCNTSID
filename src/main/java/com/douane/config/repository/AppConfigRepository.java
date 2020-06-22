package com.douane.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.douane.config.Entities.ConfigItem;



@Repository
public interface  AppConfigRepository extends JpaRepository<ConfigItem, String> {

}
