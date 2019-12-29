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

import com.douane.entities.BaeDpw;
import com.douane.entities.Message;
import com.douane.repository.BaeDpwRepository;

@RestController
@RequestMapping("/api/bae")
public class BaeDpwController {
	
	@Autowired  
	private BaeDpwRepository  baeDpwRepository  ;  
	
	private Message<BaeDpw> message  =  new Message<BaeDpw>() ;  
	private String title ="Bae DpWorld" ; 
	
	@GetMapping(path = "/getdata")
	public Message<BaeDpw>findNotMarkedt ()  {
		

		long start  =(long) baeDpwRepository.findStartEndId().get(0).get("start") ;  
		long end = (long) baeDpwRepository.findStartEndId().get(0).get("end") ;  
	    message.setId(this.title+"-"+start+"-"+end) ; 
		message.setCount(baeDpwRepository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("manifest liste ");
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
	public void marketData(@PathVariable(name="start") int start , @PathVariable(name="end") int end ) {
		try {
			System.out.println("Data has been marked successfully ");
			baeDpwRepository.setMareked(start, end);
		} catch (Exception e) {
			System.out.println(e);
		}
			
	}

}
