package com.dpworld.tasks;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dpworld.entities.SortiePhysique;
import com.dpworld.repository.PullOutRepository;


@Component
public class Task  implements  Itasks{
	
	@Autowired
	private RestTemplate template  ;  
	@Autowired
	private PullOutRepository outRepository  ; 
	
	private static final Logger  log = LoggerFactory.getLogger(Task.class)  ; 
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Override
	@Scheduled( fixedRate =  5000)
	public void fetchPullOut() {
		
		final String uri = "http://localhost:8085/api/pulout/getdata"; 
		ResponseEntity<SortiePhysique[]> resppnse =  template.getForEntity(uri, SortiePhysique[].class)  ; 
		
		SortiePhysique[] liste  =  resppnse.getBody()  ;  
		
		for (SortiePhysique sortiePhysique : liste) {
			outRepository.save(sortiePhysique)  ; 
			log.info("save pull out item   id"+sortiePhysique.getId());
		}
	     		
		
	}

	@Override
	public void fetchDebarquement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fetchContainerVisit() {
		// TODO Auto-generated method stub
		
	}

}
