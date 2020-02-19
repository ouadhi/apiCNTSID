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
import com.douane.entities.Dstr;
import com.douane.entities.Manifest;
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.entities.Dstr;
import com.douane.repository.DstrRepository;
import com.douane.repository.MessageRepository;
import com.douane.securite.config.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.douane.repository.DstrRepository;



@RestController
@RequestMapping("api/v1/dstr")
@Api(value="Dstr end-point" , description = "Operations pertaining to Dstr" )
public class DstrController {
	
	@Autowired  
	private DstrRepository  repository  ;  	
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private String  title = "Dstr"  ; 
	private Message<Dstr> message = new  Message<Dstr>()  ;
	
	
	@ApiOperation(value = "View a list of All dstr in DataBase ")
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@GetMapping(path = "/getdata")
	public Message<Dstr> findNotMarkedt ()  {
		
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
	public List<Dstr> findAll ()  {
		return repository.findAll() ; 
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@GetMapping(path = "/getdata/{id}")
	public Optional<Dstr> getDataById(@PathVariable(name = "id") long  id) {
		return repository.findById(id)  ; 
	}

	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}
	
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Dstr data) {
		data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Dstr data) {
		if (repository.existsById(data.getId())) {
			repository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (repository.existsById(id))  {
		   Optional<Dstr> optional =   repository.findById(id) ; 
		   Dstr  Dstr = optional.get() ; 
		   Dstr.setFlag(true);
		   Dstr.setDateMarkage(new Date());
		   
		   repository.save(Dstr)  ; 
			System.out.println("Data has been marked successfully :" + Dstr.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void markedlist(@PathVariable(name="start") Long start   ,@PathVariable(name="end") Long end  , HttpServletRequest   request    ) {
		try {
			
			
			repository.setMareked(start, end);
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.setMessageName(this.title);
			messageDAO.setStart(start);
			messageDAO.setEnd(end);
			messageDAO.setUser_name(jwtTokenUtil.getUsernameFromHttpRequest(request));
			messageDAO.setSaveDate(new Date());
			System.out.println("Data has been marked successfully :");
		} catch (Exception e) {
			System.out.println("Record not exists");
			System.err.println(e.getMessage());
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld')" )
	@GetMapping(path = "/getcount")
	public int  getcount ()  {
		return repository.getCount()  ; 
	}
	
	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "get a collection items whene id between two ids ")
	@PostMapping(path = "/getdata/{start}/{end}", produces = "application/json")
	public List<Dstr> getDatabetween(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end , HttpServletRequest request) {
		try {
			return repository.getDataBetweenIs(start, end) ; 
		} catch (Exception e) {
			System.out.println(e);
			return  null ; 
		}

	}
	
	
	

}
