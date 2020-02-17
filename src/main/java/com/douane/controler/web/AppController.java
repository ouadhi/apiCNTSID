package com.douane.controler.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.config.Properties;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("app")
@ApiIgnore
public class AppController {
	
	
	@Autowired
	private Properties  properties ; 
	
	 @GetMapping("/config")
	 public Properties getAppAddres()
	 {
	  return properties ; 
	 }
	 
	
	

}
