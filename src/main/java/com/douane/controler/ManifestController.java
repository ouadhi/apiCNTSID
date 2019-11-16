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

import com.douane.entities.Manifest;
import com.douane.repository.ManifestRepository;


@RestController
@RequestMapping("/api/manifest")
public class ManifestController {
	@Autowired  
	private ManifestRepository  repository  ;  
	
	@GetMapping(path = "/getdata")
	public List<Manifest> findNotMarkedt ()  {
		return repository.getDataNoMarked() ;
	}
	
	@GetMapping(path = "/getalldata")
	public List<Manifest> findAll ()  {
		return repository.findAll() ; 
	}
	@GetMapping(path = "/getdata/{id}")
	public Optional<Manifest> getDataById(@PathVariable(name = "id") int  id) {
		return repository.findById(id)  ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") int id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Manifest data) {
		data.setFlag(true);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Manifest data) {
		if (repository.existsById(data.getId())) {
			repository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") int id ) {
		if (repository.existsById(id))  {
		   Optional<Manifest> optional =   repository.findById(id) ; 
		   Manifest  Manifest = optional.get() ; 
		   Manifest.setFlag(true);
		   Manifest.setDateMarquage(new Date());
		   
		   repository.save(Manifest)  ; 
			System.out.println("Data has been marked successfully :" + Manifest.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

}
