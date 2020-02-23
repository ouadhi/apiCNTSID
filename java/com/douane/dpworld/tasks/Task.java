package com.douane.dpworld.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.douane.dpworld.entities.ConteneurParcVisite;
import com.douane.dpworld.entities.Debarquement;
import com.douane.dpworld.entities.SortiePhysique;
import com.douane.dpworld.repository.ContneurParcVisiteRepository;
import com.douane.dpworld.repository.DebarquementRepository;
import com.douane.dpworld.repository.PullOutRepository;



@Component
public class Task  implements  Itasks{
	
	@Autowired
	private RestTemplate template  ;  
	@Autowired
	private PullOutRepository outRepository  ; 
	@Autowired
	private DebarquementRepository  debarquementRepository  ; 
	@Autowired
	private ContneurParcVisiteRepository contneurParcVisiteRepository ;  
	
	private static final Logger  log = LoggerFactory.getLogger(Task.class)  ; 
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Override
	@Scheduled( fixedRate =  5000)
	public void fetchPullOut() {
		
		final String uri = "http://localhost:8085/api/pulout/getdata"; 
		ResponseEntity<SortiePhysique[]> resppnse =  template.getForEntity(uri, SortiePhysique[].class)  ; 
		
		SortiePhysique[] liste  =  resppnse.getBody()  ;  
		
		for (SortiePhysique sortiePhysique : liste) {
			sortiePhysique.setAjoute(new Date());
			outRepository.save(sortiePhysique)  ; 
			ResponseEntity<String> responseEntity = template.postForEntity("http://localhost:8085/api/pulout/marked/"+sortiePhysique.getId(), null, null) ; 
			log.info("save and marked  pull out item   id"+sortiePhysique.getId());
		}
	}

	@Override
	@Scheduled( fixedRate =  5000)
	public void fetchDebarquement() {
		final String uri = "http://localhost:8085/api/debarquement/getdata" ; 
		ResponseEntity<Debarquement[]> resppnse =  template.getForEntity(uri, Debarquement[].class)  ; 
		
		Debarquement[] liste  =  resppnse.getBody()  ;  
		
		for (Debarquement debarquement : liste) {
			debarquement.setAjoute(new Date());
			debarquementRepository.save(debarquement)  ; 
			ResponseEntity<String> responseEntity = template.postForEntity("http://localhost:8085/api/debarquement/mark/"+debarquement.getId(), null, null) ; 
			log.info("save and marked  debarquement  item   id"+debarquement.getId());
		}
		
	}

	@Override
	@Scheduled( fixedRate =  5000)
	public void fetchContainerVisit() {
		final String uri = "http://localhost:8085/api/cparc/getdata"; 
		ResponseEntity<ConteneurParcVisite[]> resppnse =  template.getForEntity(uri, ConteneurParcVisite[].class)  ; 
		
		ConteneurParcVisite[] liste  =  resppnse.getBody()  ;  
		
		for (ConteneurParcVisite conteneurParcVisite : liste) {
			conteneurParcVisite.setAjoute(new Date());
			contneurParcVisiteRepository.save(conteneurParcVisite)  ; 
			ResponseEntity<String> responseEntity = template.postForEntity("http://localhost:8085/api/debarquement/mark/"+conteneurParcVisite.getId(), null, null) ; 
			log.info("save and marked  contneur parc  item   id"+conteneurParcVisite.getId());
		}
		
	}

}
