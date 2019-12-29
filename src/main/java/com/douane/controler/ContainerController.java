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

import com.douane.entities.Container;
import com.douane.entities.Message;
import com.douane.repository.ContainersRepository;


//  end  point annotation 
@RestController
@RequestMapping("/api/container")

public class ContainerController {
	
	//  inject  Repository  
	@Autowired  
	private ContainersRepository containersRepository   ;  
	
	private Message<Container>  message = new Message<Container>() ; 
	private String title = "Container" ; 
	
	
	/*  find all data  when flag  = true 
	 *   data  not  consumed
	 */
	
	@GetMapping(path = "/getdata")
	public Message<Container> findNotMarkedt ()  {
		
		Long start  =(Long) containersRepository.findStartEndId().get(0).get("start") ;  
		Long end = (Long)  containersRepository.findStartEndId().get(0).get("end") ;  
	    message.setId(this.title+"-"+start+"-"+end) ; 
		message.setCount(containersRepository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("manifest liste ");
		message.setContant( containersRepository.getDataNotMarked());
		
		return message;  
	}
	
	@GetMapping(path = "/getalldata")
	public List<Container> findAll ()  {
		return containersRepository.findAll();  
	}
	
	@GetMapping(path = "/getdata/{id}")
	public Optional<Container> getDataById(@PathVariable(name = "id") long  id) {
		return containersRepository.findById(id) ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		containersRepository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Container data) {
		data.setFlag(false);
		containersRepository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Container data) {
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
		   Optional<Container> optional =   containersRepository.findById(id) ; 
		   Container  Container = optional.get() ; 
		   Container.setDateMarkage(new Date());
		   Container.setFlag(true);
		  
		   containersRepository.save(Container)  ; 
			System.out.println("Data has been marked successfully :" + Container.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void markedlist(@PathVariable(name="start") Long start   ,@PathVariable(name="end") Long end    ) {
		try {
			
			System.out.println(start +" "+ end);
			containersRepository.setMareked(start, end);
			System.out.println("Data has been marked successfully :");
		} catch (Exception e) {
			System.out.println("Record not exists");
			System.err.println(e.getMessage());
		}
	}

}
