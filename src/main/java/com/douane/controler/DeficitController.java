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
import com.douane.entities.Deficit;
import com.douane.entities.Message;
import com.douane.repository.DeficitRepository;
import com.douane.repository.MessageRepository;
import com.douane.securite.config.JwtTokenUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/deficit")
@Api(value="Deficit  end-point" , description = "Operations pertaining to BAE" )
public class DeficitController {
	
	@Autowired
	private  DeficitRepository deficitRepository  ;  
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	private String title  = "Deficit" ;  
	private Message<Deficit>  message  = new Message<Deficit>() ; 
	
	
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') and  hasRole('epal')" )
	@ApiOperation(value = "View a list of available BAE ", response = BaeDpw.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping(path = "/getdata")
	public Message<Deficit> findNomatkedData ()  {
		Long start  =(Long) deficitRepository.findStartEndId().get(0).get("start") ;  
		Long end = (Long)  deficitRepository.findStartEndId().get(0).get("end") ;  
	    message.setId(this.title+"-"+start+"-"+end) ; 
		message.setCount(deficitRepository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("manifest liste ");
		message.setContant( deficitRepository.getDataNoMarked());
		return message;
	} 
    
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') and  hasRole('epal')" )
	@GetMapping(path = "/getalldata")
	public List<Deficit> findAllData(){
		return   deficitRepository.findAll() ; 
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
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') and  hasRole('epal')" )
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name = "id")  Long id ) {
		if (deficitRepository.existsById(id)) {
			Deficit  data  =  deficitRepository.findById(id).get() ; 
			data.setFlag(true);
			data.setDateMarkage(new Date());
			deficitRepository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	
	@PreAuthorize("hasRole('admin') or hasRole('dpworld') and  hasRole('epal')" )
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void markedlist(@PathVariable(name="start") Long start   ,@PathVariable(name="end") Long end    ) {
		try {
			
			System.out.println(start +" "+ end);
			deficitRepository.setMareked(start, end);
			System.out.println("Data has been marked successfully :");
		} catch (Exception e) {
			System.out.println("Record not exists");
			System.err.println(e.getMessage());
		}
	}
	
	@GetMapping(path = "/getcount")
	public int  getcount ()  {
		return deficitRepository.getCount()  ; 
	}
	
	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "get a collection items whene id between two ids ")
	@PostMapping(path = "/getdata/{start}/{end}", produces = "application/json")
	public List<Deficit> getDatabetween(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end , HttpServletRequest request) {
		try {
			return deficitRepository.getDataBetweenIs(start, end) ; 
		} catch (Exception e) {
			System.out.println(e);
			return  null ; 
		}

	}
	
	
	

}
