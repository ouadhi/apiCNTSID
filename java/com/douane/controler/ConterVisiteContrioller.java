package com.douane.controler;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.entities.BaeDpw;
import com.douane.entities.Contrevisite;
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.repository.ConterVisiteRepository;
import com.douane.repository.MessageRepository;
import com.douane.securite.config.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//end  point annotation 
@RestController
@RequestMapping("/api/container-visite")
@Api(value="Containers-Visiteld end-point" , description = "Operations pertaining to Containers-Visite" )

public class ConterVisiteContrioller {

	//  inject  Repository  
	@Autowired  
	private ConterVisiteRepository repository  ; 
	@Autowired 
	private  MessageRepository messageRepository   ;  
	@Autowired 
	private  JwtTokenUtil jwtTokenUtil   ; 
	
	
	private String title  =  "Contenervisite" ; 
	private Message<Contrevisite> message  = new Message<Contrevisite>()  ; 
	
	
	/*  find all data  when flag  = true 
	 *   data  not  consumed
	 */
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') or hasRole('epal')")
	@GetMapping(path = "/getdata")
	public Message<Contrevisite> findNotMarkedt ()  {
		Long start  =(Long) repository.findStartEndId().get(0).get("start") ;  
		Long end = (Long)  repository.findStartEndId().get(0).get("end") ;  
	    message.setId(this.title+"-"+start+"-"+end) ; 
		message.setCount(repository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("contenaire visite ");
		message.setContant( repository.getDataNotMarked());
		return message;
	}
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') or hasRole('epal')" )
	@GetMapping(path = "/getalldata")
	public List<Contrevisite> findAll ()  {
		return repository.findAll(); 
	}
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') or hasRole('epal')" )
	@GetMapping(path = "/getdata/{id}")
	public Optional<Contrevisite> getDataById(@PathVariable(name = "id") long  id) {
		return repository.findById(id) ; 
	}
    
	@PreAuthorize("hasRole('admin')" )
	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}
	
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Contrevisite data) {
		data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PreAuthorize("hasRole('admin')" )
	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Contrevisite data) {
		if (repository.existsById(data.getId())) {
			repository.save(data);
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
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') or hasRole('epal')" )
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (repository.existsById(id))  {
		   Optional<Contrevisite> optional =   repository.findById(id) ; 
		   Contrevisite  Contrevisite = optional.get() ; 
		   Contrevisite.setDateMarkage(new Date());
		   Contrevisite.setFlag(true);
		  
		   repository.save(Contrevisite)  ; 
			System.out.println("Data has been marked successfully :" + Contrevisite.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') or hasRole('epal')" )
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void markedlist(@PathVariable(name="start") Long start   ,@PathVariable(name="end") Long end , HttpServletRequest  request    ) {
		try {
			
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.setMessageName(this.title);
			messageDAO.setStart(start);
			messageDAO.setEnd(end);
			messageDAO.setUser_name(jwtTokenUtil.getUsernameFromHttpRequest(request));
			messageDAO.setSaveDate(new Date());

			repository.setMareked(start, end);
			System.out.println("Data has been marked successfully :");
		} catch (Exception e) {
			System.out.println("Record not exists");
			System.err.println(e.getMessage());
		}
	}
	
	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "get a collection items whene id between two ids ")
	@PostMapping(path = "/getdata/{start}/{end}", produces = "application/json")
	public List<Contrevisite> getDatabetween(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end ) {
		try {
			return repository.getDataBetweenIs(start, end) ; 
		} catch (Exception e) {
			System.out.println(e);
			return  null ; 
		}

	}
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') or hasRole('epal')" )
	@GetMapping(path = "/getcount")
	public int  getcount ()  {
		return repository.getCount()  ; 
	}



}
