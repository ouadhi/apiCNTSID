package com.douane.v2.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.entities.BaeDpw;
import com.douane.entities.MessageDAO;
import com.douane.repository.BaeDpwRepository;
import com.douane.repository.MessageRepository;
import com.douane.service.MessageType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Bae end-point", description = "Operations pertaining to BAE" , basePath ="/api/v2/bae" )
@ApiModel("BAE")
@RequestMapping("/api/v2/bae")
public class BaeController {
	
	
	@Autowired
	private BaeDpwRepository baeDpwRepository;
	@Autowired
	private MessageRepository messageRepository;
	
	private final String title = "Bae-DpWorld";
	

	@PreAuthorize("hasRole('admin') or hasRole('dpworld')")
	@ApiOperation(value = "View a list of available BAE ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/getdata")
	public ResponseEntity<ArrayList<BaeDpw>> getData(){
		ArrayList<BaeDpw> data  = new ArrayList<BaeDpw>(); 
		data =  (ArrayList<BaeDpw>) baeDpwRepository.getDataNotMarked()  ; 		
		
		ResponseEntity<ArrayList<BaeDpw>> responseEntity  =  new ResponseEntity<ArrayList<BaeDpw>>(data, HttpStatus.ACCEPTED)  ; 
		return  responseEntity ;  
	}
	
	@PreAuthorize("hasRole('admin') or hasRole(Dpworld)")
	@ApiOperation(value = "Mark a collection item specified by start  ID and End ID")
	@PostMapping(path = "/marked/{start}/{end}", produces = "application/json")
	public ResponseEntity<String>  marketData(@PathVariable(name = "start") long start, @PathVariable(name = "end") long end , HttpServletRequest request) {
		try {

			baeDpwRepository.setMareked(start, end);
			
			MessageDAO messageDAO = new MessageDAO();
			messageDAO.setMessageName(this.title);
			messageDAO.setType(MessageType.Out);
			messageDAO.setStart(start);
			messageDAO.setEnd(end);
			//messageDAO.setUser_name(jwtTokenUtil.getUsernameFromHttpRequest(request));
			messageDAO.setSaveDate(new Date());
			messageRepository.save(messageDAO);
			
			System.out.println("Data has been marked successfully ");
			return ResponseEntity.ok("marked Bae message "+start+"-"+end) ; 
		} catch (Exception e) {
			System.out.println(e);
			return   new ResponseEntity<>(
			          e.getMessage(), 
			          HttpStatus.BAD_REQUEST);
		}

	}
	
	
	
	

}
