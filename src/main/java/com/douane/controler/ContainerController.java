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

import com.douane.entities.ContainersDpw;
import com.douane.repository.ContainersRepository;


//  end  point annotation 
@RestController
@RequestMapping("/api/container")

public class ContainerController {
	
	//  inject  Repository  
	@Autowired  
	private ContainersRepository containersRepository   ;  
	
	
	/*  find all data  when flag  = true 
	 *   data  not  consumed
	 */
	
	@GetMapping(path = "/getdata")
	public List<ContainersDpw> findNotMarkedt ()  {
		return containersRepository.getDataNotMarked();  
	}
	
	@GetMapping(path = "/getalldata")
	public List<ContainersDpw> findAll ()  {
		return containersRepository.findAll();  
	}
	
	@GetMapping(path = "/getdata/{id}")
	public Optional<ContainersDpw> getDataById(@PathVariable(name = "id") long  id) {
		return containersRepository.findById(id) ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		containersRepository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody ContainersDpw data) {
		data.setFlag(false);
		containersRepository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody ContainersDpw data) {
		if (containersRepository.existsById(data.getId())) {
			containersRepository.save(data);
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
		if (containersRepository.existsById(id))  {
		   Optional<ContainersDpw> optional =   containersRepository.findById(id) ; 
		   ContainersDpw  ContainersDpw = optional.get() ; 
		   ContainersDpw.setFlag(true);
		   containersRepository.save(ContainersDpw)  ; 
			System.out.println("Data has been marked successfully :" + ContainersDpw.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

}
