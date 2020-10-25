package com.douane.controler;

import java.util.HashMap;
import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douane.entities.BaeDpw;
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.repository.MessageRepository;
import com.douane.service.MessageService;
import com.douane.service.MessageType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@Api(value = "Messages end-point", description = "Operations pertaining to messages")
@RequestMapping("/api/v1/message")

public class MessageController {

	@Autowired
	private MessageRepository repository;
	@Autowired
	private  MessageService messageService ; 

	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "Liste  of messages ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "/")
	public ResponseEntity<?> getAllMessages() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("In", this.messageService.inInfo());
		map.put("Out", this.messageService.outInfo());
		return ResponseEntity.ok(map);
	}

	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "Liste  of messages ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })

	@GetMapping(path = "/{id}")
	public MessageDAO getMessageById(@PathVariable(name = "id") Long id) {
		return repository.getOne(id);
	}

	@PreAuthorize("hasRole('admin')")
	@ApiOperation(value = "Liste  of messages ")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@GetMapping(path = "")

	public List<MessageDAO> getMessageByType(@RequestParam(required = false) String type ) {
		MessageType eType = MessageType.valueOf(type); 
		return repository.getMessagesByType(eType) ; 
	}
	
	
	
	

}
