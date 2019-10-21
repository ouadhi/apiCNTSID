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
import org.springframework.web.client.HttpClientErrorException.Gone;

import com.douane.entities.VoyageGros;
import com.douane.entities.VoyageGros;
import com.douane.repository.VoyageGrosRepository;
import com.douane.repository.VoyageGrosRepository;

@RestController
@RequestMapping("/api/voyage-gros")
public class VoyageGrosController {
	
	@Autowired  
	private VoyageGrosRepository  repository  ;  
	
	@GetMapping(path = "/getdata")
	public List<VoyageGros> findNotMarkedt ()  {
		return repository.getDataNotMarked();  
	}
	
	@GetMapping(path = "/getalldata")
	public List<VoyageGros> findAll ()  {
		return repository.findAll() ; 
	}
	@GetMapping(path = "/getdata/{id}")
	public Optional<VoyageGros> getDataById(@PathVariable(name = "id") long  id) {
		return repository.findById(id)  ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody VoyageGros data) {
		data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody VoyageGros data) {
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
		   Optional<VoyageGros> optional =   repository.findById(id) ; 
		   VoyageGros  VoyageGros = optional.get() ; 
		   VoyageGros.setFlag(true);
		   VoyageGros.setDate_mark(new Date());
		   
		   repository.save(VoyageGros)  ; 
			System.out.println("Data has been marked successfully :" + VoyageGros.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

}
