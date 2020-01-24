package com.douane.controler;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import com.douane.repository.BaeDpwRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value="Bae endpoint ", description="Operations pertaining to Bae Dpworld ")
@RequestMapping("/api/v1/bae")
public class BaeDpwController {
	
	@Autowired  
	private BaeDpwRepository  baeDpwRepository  ;  
	
	private Message<BaeDpw> message  =  new Message<BaeDpw>() ;  
	private String title ="Bae DpWorld" ; 
	
	@PreAuthorize("hasRole('admin') or hasRole('Dpworld')" )
	@ApiOperation(value = "View a list of available BAE ", response = BaeDpw.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	@GetMapping(path = "/getdata")
	public Message<BaeDpw>findNotMarkedt ()  {
		Long start  =(Long) baeDpwRepository.findStartEndId().get(0).get("start") ;  
		Long end = (Long) baeDpwRepository.findStartEndId().get(0).get("end") ;  
		
	    message.setId(this.title+"-"+start+"-"+end) ;  
		message.setCount(baeDpwRepository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("bae  liste ");
		
		message.setContant( baeDpwRepository.getDataNotMarked());	
	
		return message ; 
	}
	
	@GetMapping(path = "/getalldata")
	public List<BaeDpw> findAll ()  {
		return baeDpwRepository.getDataNotMarked();  
	}
	@GetMapping(path = "/getdata/{id}")
	public Optional<BaeDpw> getDataById(@PathVariable(name = "id") long  id) {
		return baeDpwRepository.findById(id)  ; 
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		baeDpwRepository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody BaeDpw data) {
		data.setFlag(false);
		baeDpwRepository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody BaeDpw data) {
		if (baeDpwRepository.existsById(data.getId())) {
			baeDpwRepository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	@PostMapping(path = "/marked/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (baeDpwRepository.existsById(id))  {
		   Optional<BaeDpw> optional =   baeDpwRepository.findById(id) ; 
		   BaeDpw  baeDpw = optional.get() ; 
		   baeDpw.setFlag(true);
		   baeDpw.setDateMarkage(new Date());
		   baeDpwRepository.save(baeDpw)  ; 
			System.out.println("Data has been marked successfully :" + baeDpw.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void marketData(@PathVariable(name="start") long start , @PathVariable(name="end") long end ) {
		try {
			System.out.println("Data has been marked successfully ");
			baeDpwRepository.setMareked(start, end);
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}

}
