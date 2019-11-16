package com.douane.controler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.entities.DebarquementManifeste;
import com.douane.entities.DebarquementManifeste;
import com.douane.repository.DebarquementManifestRepositroy;

//end  point annotation 
@RestController
@RequestMapping("/api/debarquement")
public class DebarquementManifestController {
	
//  inject  Repository  
	@Autowired  
	private  DebarquementManifestRepositroy repositroy   ;  
	
	
	/*
	 * create  date Formate  
	 */
      DateFormat  df  =  new SimpleDateFormat()  ; 
	
	
	/*  find all data  when flag  = true 
	 *   data  not  consumed
	 */
	
	@GetMapping(path = "/getdata")
	public List<DebarquementManifeste> findNotMarkedt ()  {
		return repositroy.getDataNotMarked();  
	}
	
	@GetMapping(path = "/getalldata")
	public List<DebarquementManifeste> findAll ()  {
		return repositroy.findAll();  
	}
	
	@GetMapping(path = "/getdata/{id}")
	public Optional<DebarquementManifeste> getDataById(@PathVariable(name = "id") long  id) {
		return repositroy.findById(id) ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repositroy.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody DebarquementManifeste data) {
		data.setFlag(false);
		repositroy.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody DebarquementManifeste data) {
		if (repositroy.existsById(data.getId())) {
			repositroy.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	
	/*
	 *  find data  by id  if exist 
	 *  update  object set  flag =  true 
	 *  save object 
	 */
	
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (repositroy.existsById(id))  {
		   Optional<DebarquementManifeste> optional =   repositroy.findById(id) ; 
		   DebarquementManifeste  debarquementManifeste = optional.get() ; 
		   debarquementManifeste.setFlag(true);
		   debarquementManifeste.setDateMarkage(new Date())  ; 
		   repositroy.save(debarquementManifeste)  ; 
			System.out.println("Data has been marked successfully :" + debarquementManifeste.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

}
