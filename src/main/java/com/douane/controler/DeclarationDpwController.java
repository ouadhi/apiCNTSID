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

import com.douane.entities.DeclarationDpw;
import com.douane.repository.DeclarationDpwRepository;

@RestController
@RequestMapping("/api/decl-dpw")
public class DeclarationDpwController {

	@Autowired  
	private DeclarationDpwRepository  repository  ;  
	
	@GetMapping(path = "/getdata")
	public List<DeclarationDpw> findNotMarkedt ()  {
		return repository.getDataNotMarked();  
	}
	
	@GetMapping(path = "/getalldata")
	public List<DeclarationDpw> findAll ()  {
		return repository.findAll() ; 
	}
	@GetMapping(path = "/getdata/{id}")
	public Optional<DeclarationDpw> getDataById(@PathVariable(name = "id") long  id) {
		return repository.findById(id)  ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody DeclarationDpw data) {
		data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody DeclarationDpw data) {
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
		   Optional<DeclarationDpw> optional =   repository.findById(id) ; 
		   DeclarationDpw  declarationDpw = optional.get() ; 
		   declarationDpw.setFlag(true);
		   declarationDpw.setDate_ajout(new Date());
		   
		   repository.save(declarationDpw)  ; 
			System.out.println("Data has been marked successfully :" + declarationDpw.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
}
