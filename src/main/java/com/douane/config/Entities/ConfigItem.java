package com.douane.config.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "config")
public class ConfigItem {
	
	@Id
	private String title ;
	@Column(nullable = false)
	private String url  ; 
	@Column(nullable = false)
	private int cron   ; 
	private boolean  enable  ; 
	
	
	

}
