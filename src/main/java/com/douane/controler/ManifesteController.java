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
import com.douane.entities.Deficit;
import com.douane.entities.Manifeste;
import com.douane.entities.Message;
import com.douane.repository.DeficitRepository;
import com.douane.repository.ManifesteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/manifeste")
@Api(value="Manifest-Endpoint" , description = "Operations pertaining to Manifest" )
@ApiModel("Manifest")
public class ManifesteController {

	@Autowired
	private ManifesteRepository repository;

	private String title = "Manifeste";
	private Message<Manifeste> message = new Message<Manifeste>();

	@GetMapping(path = "/getdata")
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@ApiOperation(value = "View a list of All BAE in DataBase ", response = Manifeste.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
	public Message<Manifeste> findNomatkedData() {
		Long start = (Long) repository.findStartEndId().get(0).get("start");
		Long end = (Long) repository.findStartEndId().get(0).get("end");

		message.setId(this.title + "-" + start + "-" + end);
		message.setCount(repository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("manifest liste ");
		message.setContant(repository.getDataNotMarked());

		return message;
	}
	
	@PreAuthorize("hasRole('admin') " )
	@GetMapping(path = "/getalldata")
	public List<Manifeste> findAll() {
		return repository.getDataNotMarked();
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@GetMapping(path = "/getdata/{id}")
	public Optional<Manifeste> getDataById(@PathVariable(name = "id") long id) {
		return repository.findById(id);
	}
	
	@PreAuthorize("hasRole('admin')" )
	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		repository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}
	
	@PreAuthorize("hasRole('admin') " )
	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Manifeste data) {
		data.setFlag(false);
		repository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}
	
	@PreAuthorize("hasRole('admin')" )
	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Manifeste data) {
		if (repository.existsById(data.getId())) {
			repository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@PostMapping(path = "/marked/{id}", produces = "application/json")
	public void marketData(@PathVariable(name = "id") Long id) {
		if (repository.existsById(id)) {
			Optional<Manifeste> optional = repository.findById(id);
			Manifeste Manifeste = optional.get();
			Manifeste.setFlag(true);
			Manifeste.setDateMarkage(new Date());
			repository.save(Manifeste);
			System.out.println("Data has been marked successfully :" + Manifeste.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}
	
	@PreAuthorize("hasRole('admin') or  hasRole('Dpworld') or hasRole('epal')" )
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void marketData(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end) {
		try {
			System.out.println("Data has been marked successfully ");
			repository.setMareked(start, end);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
