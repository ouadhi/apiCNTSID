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

import com.douane.entities.BaeDpw;
import com.douane.repository.BaeDpwRepository;

@RestController
@RequestMapping("/api/bae")
public class BaeDpwController {
	
	@Autowired  
	private BaeDpwRepository  baeDpwRepository  ;  
	
	@GetMapping(path = "/getdata")
	public List<BaeDpw> findNotMarkedt ()  {
		return baeDpwRepository.getDataNotMarked();  
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
	
	
	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name="id") Long id ) {
		if (baeDpwRepository.existsById(id))  {
		   Optional<BaeDpw> optional =   baeDpwRepository.findById(id) ; 
		   BaeDpw  baeDpw = optional.get() ; 
		   baeDpw.setFlag(true);
		   baeDpwRepository.save(baeDpw)  ; 
			System.out.println("Data has been updated successfully :" + baeDpw.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

}
