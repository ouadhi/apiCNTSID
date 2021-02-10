package com.douane.dpworld.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.douane.config.ConstVar;
import com.douane.dpworld.entities.Debarquement;
import com.douane.dpworld.repository.DebarquementRepository;
import com.douane.service.MessageDaoService;

@Component
public class DebarquementService {

	@Autowired
	private DebarquementRepository debarquementRepository;
	@Autowired
	private MarkedService markedService;
	@Autowired
	private MessageDaoService msgService;

	@Autowired
	private RestTemplate template;

	public int doFetch() {
		
		// fetch API and save response  
		ResponseEntity<Debarquement[]> response = template.getForEntity(ConstVar.URL_debarquement,Debarquement[].class);
		
		// get  body response  
		Debarquement[] body = response.getBody();
		// convert  body to  List  with same  argumant
		List<Debarquement> apiList = new ArrayList<Debarquement>();
		apiList = Arrays.asList(body);
		System.out.println(apiList.size());
		
		// getAll items saved in data base  
		ArrayList<Debarquement> listDB = (ArrayList<Debarquement>) debarquementRepository.findAll();
		System.out.println(listDB.size());

		// get ids from DB list
		Set<Integer> ids = listDB.stream().map(Debarquement::getId).collect(Collectors.toSet());
		
		// deffirence  between tow  list  
		List<Debarquement> parentlist = apiList.stream()
				.filter(debarquement -> !ids.contains(debarquement.getId())).collect(Collectors.toList());
		
		System.out.println(parentlist.size());
		
		int count_save = parentlist.size();
		parentlist.stream().forEach(item  -> item.setAjoute(new Date()));
		// save deffirence  in data base 
		debarquementRepository.saveAll(parentlist)  ;    
		// marked items 
		// logs details  
		if(count_save>0)
		this.msgService.saveMessage("Debarquement", parentlist.get(0).getId(),  parentlist.get(count_save-1).getId()); 

	
		
		return count_save;
	}

}
