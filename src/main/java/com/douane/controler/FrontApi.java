package com.douane.controler;


import java.util.Date;

import javax.print.attribute.standard.Media;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.service.AppInfo;

import com.douane.service.MessageService;

import com.douane.service.MessgIn;
import com.douane.service.MessgOut;
import com.douane.service.Util;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/ui")
public class FrontApi {

	@Autowired
	private MessageService  messageService ; 
	@Autowired
	private Util utilservice  ;  

	@GetMapping(path = "")
	public AppInfo getAppInfo() {
		return this.messageService.createApiInfo(); 
	}

	@GetMapping(path = "/in")
	public MessgIn getInInfo() {

		return this.messageService.createIn();

	}

	@GetMapping(path = "/out")

	public MessgOut getOutInfo() {
		return this.messageService.createOut();
	}
	
	

	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "Message statistics end-point ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/v1/static"   )

	public ResponseEntity<?> statistics() {
		  Date date_start  =  new Date();  
	      Date date_end  =  utilservice.addDaysToDate(date_start, -10) ; 
	     
		return ResponseEntity.ok(messageService.statstic_in(date_start, date_end)) ;  
	}
	
	

	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "Message statistics end-point ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/v2/static"   )

	public ResponseEntity<?> statisticsv2() {
		  Date date_start  =  new Date();  
	      Date date_end  =  utilservice.addDaysToDate(date_start, -10) ; 
	      
	      
		
		return ResponseEntity.ok(messageService.statstic_in_v2(date_start, date_end)) ;  
	}
	
	
	
	
	

}
