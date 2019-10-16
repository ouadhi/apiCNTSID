package com.douane.controler;

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

import com.douane.entities.CparcVisite;

import com.douane.repository.CparcVisiteRepository;

//end  point annotation 
@RestController
@RequestMapping("/api/parcvisit")

public class CparcVisiteController {
	
//  inject  Repository  
	@Autowired  
	private CparcVisiteRepository cparcVisiteRepository   ;  
	
	
	/*  find all data  when flag  = true 
	 *   data  not  consumed
	 */
	
	@GetMapping(path = "/getdata")
	public List<CparcVisite> findNotMarkedt ()  {
		return cparcVisiteRepository.getDataNotMarked();  
	}
	
	@GetMapping(path = "/getalldata")
	public List<CparcVisite> findAll ()  {
		return cparcVisiteRepository.findAll();  
	}
	
	@GetMapping(path = "/getdata/{id}")
	public Optional<CparcVisite> getDataById(@PathVariable(name = "id") long  id) {
		return cparcVisiteRepository.findById(id) ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		cparcVisiteRepository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody CparcVisite data) {
		data.setFlag(false);
		cparcVisiteRepository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody CparcVisite data) {
		if (cparcVisiteRepository.existsById(data.getId())) {
			cparcVisiteRepository.save(data);
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
		if (cparcVisiteRepository.existsById(id))  {
		   Optional<CparcVisite> optional =   cparcVisiteRepository.findById(id) ; 
		   CparcVisite  CparcVisite = optional.get() ; 
		   CparcVisite.setFlag(true);
		   cparcVisiteRepository.save(CparcVisite)  ; 
			System.out.println("Data has been marked successfully :" + CparcVisite.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

}
