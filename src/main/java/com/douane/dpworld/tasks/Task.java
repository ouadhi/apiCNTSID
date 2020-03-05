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

import com.douane.config.ConstVar;
import com.douane.dpworld.entities.ConteneurParcVisite;
import com.douane.dpworld.entities.Debarquement;
import com.douane.dpworld.entities.SortiePhysique;
import com.douane.dpworld.repository.ContneurParcVisiteRepository;
import com.douane.dpworld.repository.DebarquementRepository;
import com.douane.dpworld.repository.PullOutRepository;

@Component
public class Task implements Itasks {

	@Autowired
	private RestTemplate template;
	@Autowired
	private PullOutRepository outRepository;
	@Autowired
	private DebarquementRepository debarquementRepository;
	@Autowired
	private ContneurParcVisiteRepository contneurParcVisiteRepository;

	private static final Logger log = LoggerFactory.getLogger(Task.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Override
	@Scheduled(fixedRate = 10000)
	public void fetchPullOut() {

		ResponseEntity<SortiePhysique[]> resppnse = template.getForEntity(ConstVar.URL_Sortie, SortiePhysique[].class);

		SortiePhysique[] liste = resppnse.getBody();

		for (SortiePhysique sortiePhysique : liste) {
			sortiePhysique.setAjoute(new Date());
			outRepository.save(sortiePhysique);
			// ResponseEntity<String> responseEntity =
			// template.postForEntity("http://localhost:8085/api/pulout/marked/"+sortiePhysique.getId(),
			// null, null) ;
		
		}
		log.info("save and marked  pull out items" +liste.length);

	}

	@Override
	@Scheduled(fixedRate = 10000)
	public void fetchDebarquement() {

		ResponseEntity<Debarquement[]> response = template.getForEntity(ConstVar.URL_debarquement,
				Debarquement[].class);

		Debarquement[] liste = response.getBody();

		for (Debarquement debarquement : liste) {

			debarquement.setAjoute(new Date());
			debarquementRepository.save(debarquement);
			// ResponseEntity<String> responseEntity =
			// template.postForEntity("http://localhost:8085/api/debarquement/mark/"+debarquement.getId(),
			// null, null) ;
		

		}
		log.info("save and marked  debarquement  items" + liste.length);

	}

	@Override
	@Scheduled(fixedRate = 10000)
	public void fetchContainerVisit() {

		ResponseEntity<ConteneurParcVisite[]> resppnse = template.getForEntity(ConstVar.URL_Container, ConteneurParcVisite[].class);

		ConteneurParcVisite[] liste = resppnse.getBody();
		log.info("size"+liste.length);

		for (ConteneurParcVisite conteneurParcVisite : liste) {
			conteneurParcVisite.setAjoute(new Date());
			contneurParcVisiteRepository.save(conteneurParcVisite);
			// ResponseEntity<String> responseEntity =
			// template.postForEntity("http://localhost:8085/api/debarquement/mark/"+conteneurParcVisite.getId(),
			// null, null) ;
			
		}
		log.info("save and marked  contneur parc  items"+liste.length)  ;
	

	}

}
