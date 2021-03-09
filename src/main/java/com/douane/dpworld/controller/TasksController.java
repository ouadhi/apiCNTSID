package com.douane.dpworld.controller;

import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douane.dpworld.service.DebarquementService;
import com.douane.dpworld.service.ParcVisteService;
import com.douane.dpworld.service.PullOutService;

@RestController
@RequestMapping("/api/v1/tasks")
public class TasksController {

	@Autowired
	private DebarquementService debarquementService;
	@Autowired
	private ParcVisteService parcService;
	@Autowired
	private PullOutService outService;

	@PostMapping("")
	public ResponseEntity<?> runtask(@RequestParam(required = true, defaultValue = "debarquement") String task) {
		try {
			int count = this.doRun(task) ; 
			HashMap<String, Object> respons = new HashMap<String, Object>();
			respons.put("task", task);
			respons.put("items", count);
			respons.put("Date", new Date());

			return ResponseEntity.ok(respons);

		} catch (Exception e) {
			return  new ResponseEntity<>("Task not undefined",HttpStatus.BAD_REQUEST)  ;  
		}
	}

	private int doRun(String task) {

		int count = 0;

		switch (task) {
		case "debarquement":
			count = debarquementService.doFetch();
			break;
		case "parc":
			count = parcService.doFetch();
			break;
		default:
			count = outService.doFetch();

		}

		return count;
	}

}
