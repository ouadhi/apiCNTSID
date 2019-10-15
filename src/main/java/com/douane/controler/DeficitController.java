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

import com.douane.entities.Deficit;
import com.douane.entities.TodoItems;
import com.douane.repository.DeficitRepository;

@RestController
@RequestMapping("/api/deficit")
public class DeficitController {
	
	@Autowired
	private  DeficitRepository deficitRepository  ;  
	
	@GetMapping(path = "/getdata")
	public List<Deficit> findAll ()  {
		return  deficitRepository.findAll() ;  
	}
	
	@GetMapping(path = "/getdata/{id}")
	public Optional<Deficit> getDataById(@PathVariable(name = "id") long  id) {
		return deficitRepository.findById(id)  ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		deficitRepository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Deficit data) {
		deficitRepository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Deficit data) {
		if (deficitRepository.existsById(data.getId())) {
			deficitRepository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	
	@PostMapping(path = "/market", produces = "application/json")
	public void marketData(@RequestBody Deficit data) {
		if (deficitRepository.existsById(data.getId())) {
			deficitRepository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	

}
