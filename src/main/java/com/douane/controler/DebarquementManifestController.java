package com.douane.controler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.entities.DebarquementManifeste;
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.entities.DebarquementManifeste;
import com.douane.repository.DebarquementManifestRepositroy;
import com.douane.repository.MessageRepository;
import com.douane.service.MessageType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;

//end  point annotation 
@RestController
@RequestMapping("/api/v1/manif")
@Api(value = "Manifeste end-point", description = "Operations pertaining to Manifeste")
@ApiModel("Manifeste ")

public class DebarquementManifestController {
	
//  inject  Repository  
	@Autowired  
	private  DebarquementManifestRepositroy repository   ;  
	@Autowired
	private MessageRepository messageRepository;
	
     private String  title  =  "DebarquementManifest"  ; 
     
     Message<DebarquementManifeste>   message  = new Message<DebarquementManifeste>() ; 
	
	/*  find all data  when flag  = true 
	 *   data  not  consumed
	 */
	
	@GetMapping(path = "/getdata")
	public Message<DebarquementManifeste> findNotMarkedt ()  {
		Long start  =(Long) repository.findStartEndId().get(0).get("start") ;  
		Long end = (Long)  repository.findStartEndId().get(0).get("end") ;  
	    message.setId(this.title+"-"+start+"-"+end) ; 
		message.setCount(repository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("Debarequement manifest liste ");
		message.setContant( repository.getDataNotMarked());
		return message;
	}
	
	@GetMapping(path = "/getalldata")
	public List<DebarquementManifeste> findAll ()  {
		return repository.findAll();  
	}
	
	@GetMapping(path = "/getdata/{id}")
	public Optional<DebarquementManifeste> getDataById(@PathVariable(name = "id") long  id) {
		return repository.findById(id) ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody DebarquementManifeste data) {
		//data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody DebarquementManifeste data) {
		/*
		if (repository.existsById(data.getId())) {
			repository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
		*/
	}
	
	
	/*
	 *  find data  by id  if exist 
	 *  update  object set  flag =  true 
	 *  save object 
	 */
	
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (repository.existsById(id))  {
		   Optional<DebarquementManifeste> optional =   repository.findById(id) ; 
		   DebarquementManifeste  debarquementManifeste = optional.get() ; 
		   debarquementManifeste.setFlag(true);
		   //debarquementManifeste.setDateMarkage(new Date())  ; 
		   repository.save(debarquementManifeste)  ; 
			System.out.println("Data has been marked successfully ");
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public ResponseEntity<String>  markedlist(@PathVariable(name="start") Long start   ,@PathVariable(name="end") Long end    ) {
		try {
			
			repository.setMareked(start, end);
			
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.setMessageName(this.title);
			messageDAO.setType(MessageType.Out);
			messageDAO.setStart(start);
			messageDAO.setEnd(end);
			//messageDAO.setUser_name(jwtTokenUtil.getUsernameFromHttpRequest(request));
			messageDAO.setSaveDate(new Date());
			messageRepository.save(messageDAO);
			return ResponseEntity.ok("marked Bae message "+start+"-"+end) ; 
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return   new ResponseEntity<>(
			          e.getMessage(), 
			          HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "/getcount")
	public int  getcount ()  {
		return repository.getCount()  ; 
	}
	

}
