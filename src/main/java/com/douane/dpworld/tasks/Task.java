package com.douane.dpworld.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.douane.config.ConstVar;
import com.douane.dpworld.entities.ConteneurParcVisite;
import com.douane.dpworld.entities.Debarquement;
import com.douane.dpworld.entities.SortiePhysique;
import com.douane.dpworld.repository.ContneurParcVisiteRepository;
import com.douane.dpworld.repository.DebarquementRepository;
import com.douane.dpworld.repository.PullOutRepository;
import com.douane.dpworld.service.DebarquementService;
import com.douane.dpworld.service.ParcVisteService;
import com.douane.dpworld.service.PullOutService;
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.repository.MessageRepository;
import com.douane.service.MessageType;

@Component
public class Task implements Itasks {
	
	@Autowired
	private  DebarquementService   debarquementService ; 
	@Autowired
	private  ParcVisteService  parcService ; 
	@Autowired
	private  PullOutService outService  ; 
	
	private static final Logger log = LoggerFactory.getLogger(Task.class);


	@Override
	@Scheduled(fixedRate = 100000)
	public void fetchPullOut() {
		log.info("------------------------ start out  ");
		this.outService.doFetch();
		log.info("------------------------ end out  ");
	
	}

	@Override
	//@Scheduled(fixedRate = 100000)
	public void fetchDebarquement() {
		log.info("------------------------ debarquement out  ");

		this.debarquementService.doFetch();
		
		log.info("------------------------ end debarquemtn  ");

	}

	@Override
   // @Scheduled(fixedRate = 100000)
	public void fetchContainerVisit() {
		log.info("------------------------ start visit  ");

		this.parcService.doFetch();
		
		log.info("------------------------ end visit  ");

	}

	
}
