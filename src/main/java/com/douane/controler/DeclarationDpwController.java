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
import com.douane.entities.Message;
import com.douane.repository.DeclarationDpwRepository;

@RestController
@RequestMapping("/api/decl-dpw")
public class DeclarationDpwController {

	@Autowired  
	private DeclarationDpwRepository  repository  ;  
	
	private String title = "DeclarationDpw"   ; 
	private Message<DeclarationDpw>  message = new Message<DeclarationDpw>()  ; 
	
	@GetMapping(path = "/getdata")
	public Message<DeclarationDpw>findNotMarkedt ()  {
		
		Long start  =(Long) repository.findStartEndId().get(0).get("start") ;  
		Long end = (Long)  repository.findStartEndId().get(0).get("end") ;  
	    message.setId(this.title+"-"+start+"-"+end) ; 
		message.setCount(repository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("manifest liste ");
		message.setContant( repository.getDataNotMarked());
		return message;
	}
	
	@GetMapping(path = "/getalldata")
	public List<DeclarationDpw> getAll ()  {
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
		   declarationDpw.setDateMarkage(new Date());
		   
		   repository.save(declarationDpw)  ; 
			System.out.println("Data has been marked successfully :" + declarationDpw.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void markedlist(@PathVariable(name="start") Long start   ,@PathVariable(name="end") Long end    ) {
		try {
			
			System.out.println(start +" "+ end);
			repository.setMareked(start, end);
			System.out.println("Data has been marked successfully :");
		} catch (Exception e) {
			System.out.println("Record not exists");
			System.err.println(e.getMessage());
		}
	}
	
	@GetMapping(path = "/getcount")
	public int  getcount ()  {
		return repository.getCount()  ; 
	}
}
