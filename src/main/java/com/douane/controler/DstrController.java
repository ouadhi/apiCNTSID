package com.douane.controler;

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

import com.douane.entities.Dstr;
import com.douane.entities.Dstr;
import com.douane.repository.DstrRepository;
import com.douane.repository.DstrRepository;

@RestController
@RequestMapping("/api/dstr")
public class DstrController {
	
	@Autowired  
	private DstrRepository  repository  ;  
	
	@GetMapping(path = "/getdata")
	public List<Dstr> findNotMarkedt ()  {
		return repository.getDataNotMarked();  
	}
	
	@GetMapping(path = "/getalldata")
	public List<Dstr> findAll ()  {
		return repository.findAll() ; 
	}
	@GetMapping(path = "/getdata/{id}")
	public Optional<Dstr> getDataById(@PathVariable(name = "id") long  id) {
		return repository.findById(id)  ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Dstr data) {
		data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Dstr data) {
		if (repository.existsById(data.getId())) {
			repository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (repository.existsById(id))  {
		   Optional<Dstr> optional =   repository.findById(id) ; 
		   Dstr  Dstr = optional.get() ; 
		   Dstr.setFlag(true);
		   Dstr.setDateMarkage(new Date());
		   
		   repository.save(Dstr)  ; 
			System.out.println("Data has been marked successfully :" + Dstr.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

}
