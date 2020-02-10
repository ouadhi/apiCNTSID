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
import com.douane.entities.Cparcvisite;
import com.douane.entities.Manifest;
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.repository.CparcVisiteRepository;
import com.douane.repository.MessageRepository;
import com.douane.securite.config.JwtTokenUtil;

import io.swagger.annotations.ApiOperation;

//end  point annotation 
@RestController
@RequestMapping("/api/parcvisit")

public class CparcVisiteController {

//  inject  Repository  
	@Autowired
	private CparcVisiteRepository cparcVisiteRepository;
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	private Message<Cparcvisite> message = new Message<Cparcvisite>();

	private String title = "CparcVisite";

	/*
	 * find all data when flag = true data not consumed
	 */

	@GetMapping(path = "/getdata")
	public Message<Cparcvisite> findNotMarkedt() {

		Long start = (Long) cparcVisiteRepository.findStartEndId().get(0).get("start");
		Long end = (Long) cparcVisiteRepository.findStartEndId().get(0).get("end");
		message.setId(this.title + "-" + start + "-" + end);
		message.setCount(cparcVisiteRepository.getCount());
		message.setStart_id(start);
		message.setEnd_id(end);
		message.setDescription("Container  liste ");
		message.setContant(cparcVisiteRepository.getDataNotMarked());
		return message;

	}

	@GetMapping(path = "/getalldata")
	public List<Cparcvisite> findAll() {
		return cparcVisiteRepository.findAll();
	}

	@GetMapping(path = "/getdata/{id}")
	public Optional<Cparcvisite> getDataById(@PathVariable(name = "id") long id) {
		return cparcVisiteRepository.findById(id);
	}

	@DeleteMapping(path = "/deletebyid/{id}")
	public void removebyId(@PathVariable(name = "id") long id) {
		cparcVisiteRepository.deleteById(id);
		System.out.println("Record has been deleted with the id: " + id);
	}

	@PostMapping(path = "/save", produces = "application/json")
	public void createData(@RequestBody Cparcvisite data) {
		data.setFlag(false);
		cparcVisiteRepository.save(data);
		System.out.println(" data has been saved successfully: " + data);
	}

	@PostMapping(path = "/update", produces = "application/json")
	public void updateData(@RequestBody Cparcvisite data) {
		if (cparcVisiteRepository.existsById(data.getId())) {
			cparcVisiteRepository.save(data);
			System.out.println("Data has been updated successfully :" + data);
		} else {
			System.out.println("Record not exists with the Id: " + data.getId());
		}
	}

	/*
	 * find data by id if exist update object set flag = true save object
	 */

	@PostMapping(path = "/market/{id}", produces = "application/json")
	public void marketData(@PathVariable(name = "id") Long id) {
		if (cparcVisiteRepository.existsById(id)) {
			Optional<Cparcvisite> optional = cparcVisiteRepository.findById(id);
			Cparcvisite CparcVisite = optional.get();
			CparcVisite.setFlag(true);
			CparcVisite.setDateMarkage(new Date());
			cparcVisiteRepository.save(CparcVisite);
			System.out.println("Data has been marked successfully :" + CparcVisite.getId());
		} else {
			System.out.println("Record not exists with the Id: " + id);
		}
	}

	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public void markedlist(@PathVariable(name = "start") Long start, @PathVariable(name = "end") Long end,
			HttpServletRequest request) {
		try {

			cparcVisiteRepository.setMareked(start, end);

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

	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "get a collection items whene id between two ids ")
	@PostMapping(path = "/getdata/{start}/{end}", produces = "application/json")
	public List<Cparcvisite> getDatabetween(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end,
			HttpServletRequest request) {
		try {
			return cparcVisiteRepository.getDataBetweenIs(start, end);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
