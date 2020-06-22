package com.douane.config.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.config.Entities.ConfigItem;
import com.douane.config.service.AppConfigService;

@RestController
@RequestMapping("/api/v1")
public class AppConfigControler {
	
	@Autowired  
	private AppConfigService service   ; 
	
	
	@GetMapping(path = "")
	public ResponseEntity<?> getAllConfig ()  {
		try {
			return new  ResponseEntity<List>(service.getAll(), HttpStatus.OK)  ; 
		} catch (Exception e) {
			return new  ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST)   ;  
		}
	}
	
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> ConfigById (@PathVariable(name = "id") String id )  {
		try {
			return new  ResponseEntity<ConfigItem>(service.getById(id), HttpStatus.OK)  ; 
		} catch (Exception e) {
			return new  ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST)   ;  
		}
	}
	
	@PostMapping(path = "")
	public ResponseEntity<?>  Saveconfig (@RequestBody List<ConfigItem>  list ){
		try {
			service.saveList(list);
			return new  ResponseEntity<Integer>(list.size() ,HttpStatus.OK)  ; 
		} catch (Exception e) {
			return new  ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST)   ;  
		}
	}
	
	
	

}
