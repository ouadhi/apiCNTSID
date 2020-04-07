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
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.entities.Transfer;
import com.douane.repository.MessageRepository;
import com.douane.repository.TransferRepository;
import com.douane.securite.config.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1/transfer")
@Api(value="Trandfert end-pointt" , description = "Operations pertaining to Transfert" )
@ApiModel("Transfert")
@ApiIgnore

public class TransferController {

	@Autowired  
	private TransferRepository  repository  ; 
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	private String  title = "Transfert" ;  
	private Message<Transfer> message =  new Message<Transfer>()  ; 
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@GetMapping(path = "/getdata")
	public Message<Transfer> findNotMarkedt ()  {

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
	
	@PreAuthorize("hasRole('admin')" )
	@GetMapping(path = "/getalldata")
	public List<Transfer> findAll ()  {
		return repository.findAll() ; 
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@GetMapping(path = "/getdata/{id}")
	public Optional<Transfer> getDataById(@PathVariable(name = "id") long  id) {
		return repository.findById(id)  ; 
	}
	
	@PreAuthorize("hasRole('admin')" )
	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}
	
	@PreAuthorize("hasRole('admin')" )
	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Transfer data) {
		data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}
	
	@PreAuthorize("hasRole('admin')" )
	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Transfer data) {
		if (repository.existsById(data.getId())) {
			repository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (repository.existsById(id))  {
		   Optional<Transfer> optional =   repository.findById(id) ; 
		   Transfer  Transfer = optional.get() ; 
		   Transfer.setFlag(true);
		   Transfer.setDateMarkage(new Date());
		   
		   repository.save(Transfer)  ; 
			System.out.println("Data has been marked successfully :" + Transfer.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void markedlist(@PathVariable(name="start") Long start   ,@PathVariable(name="end") Long end , HttpServletRequest request    ) {
		try {
			
			repository.setMareked(start, end);
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.setMessageName(this.title);
			messageDAO.setStart(start);
			messageDAO.setEnd(end);
			messageDAO.setUser_name(jwtTokenUtil.getUsernameFromHttpRequest(request));
			messageDAO.setSaveDate(new Date());
			messageRepository.save(messageDAO);
			System.out.println("Data has been marked successfully :");
		} catch (Exception e) {
			System.out.println("Record not exists");
			System.err.println(e.getMessage());
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@GetMapping(path = "/getcount")
	public int  getcount ()  {
		return repository.getCount()  ; 
	}
	
	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "get a collection items whene id between two ids ")
	@PostMapping(path = "/getdata/{start}/{end}", produces = "application/json")
	public List<Transfer> getDatabetween(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end , HttpServletRequest request) {
		try {
			return repository.getDataBetweenIs(start, end) ; 
		} catch (Exception e) {
			System.out.println(e);
			return  null ; 
		}

	}
	

}
