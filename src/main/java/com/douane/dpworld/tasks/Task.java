package com.douane.dpworld.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.douane.entities.Message;
import com.douane.entities.MessageDAO;
import com.douane.repository.MessageRepository;
import com.douane.service.MessageType;

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

	@Autowired
	private MessageRepository messageRepository;

	private static final Logger log = LoggerFactory.getLogger(Task.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	private static final String marekUrl = "http://192.168.9.10:8088/api/markSaved/";

	@Override
	@Scheduled(fixedRate = 10000)
	public void fetchPullOut() {

		ResponseEntity<SortiePhysique[]> resppnse = template.getForEntity("http://localhost:8085/api/pulout", SortiePhysique[].class);
		SortiePhysique[] liste = resppnse.getBody();

		if (liste.length > 0) {

			for (SortiePhysique sortiePhysique : liste) {
				if (!outRepository.existsById(sortiePhysique.getId())) {
					sortiePhysique.setAjoute(new Date());
					outRepository.save(sortiePhysique);
				//	this.markMessage(sortiePhysique.getId());
				}
			}

			this.saveMessage("PullOut", liste[0].getId(), liste[liste.length - 1].getId());
			log.info("save and marked  pull out items" + liste.length);
		}

	}

	@Override
	@Scheduled(fixedRate = 10000)
	public void fetchDebarquement() {

		ResponseEntity<Debarquement[]> response = template.getForEntity("http://localhost:8085/api/debarquement",Debarquement[].class);

		Debarquement[] liste = response.getBody();
		if (liste.length > 0) {
			for (Debarquement debarquement : liste) {
				if (!debarquementRepository.existsById(debarquement.getId())) {
					debarquement.setAjoute(new Date());
					debarquementRepository.save(debarquement);
					//this.markMessage(debarquement.getId());
				}
			}
			this.saveMessage("Debarquement", liste[0].getId(), liste[liste.length - 1].getId());
			log.info("save and marked  debarquement  items" + liste.length);
		}

	}

	@Override
	@Scheduled(fixedRate = 10000)
	public void fetchContainerVisit() {

		ResponseEntity<ConteneurParcVisite[]> resppnse = template.getForEntity("http://localhost:8085/api/cparc",ConteneurParcVisite[].class);

		ConteneurParcVisite[] liste = resppnse.getBody();
		if (liste.length > 0) {

			for (ConteneurParcVisite conteneurParcVisite : liste) {
				if (!contneurParcVisiteRepository.existsById(conteneurParcVisite.getId())) {
					conteneurParcVisite.setAjoute(new Date());
					contneurParcVisiteRepository.save(conteneurParcVisite);
					//this.markMessage(conteneurParcVisite.getId());
				}

			}

			this.saveMessage("Visite parc", liste[0].getId(), liste[liste.length - 1].getId());
			log.info("save and marked  contneur parc  items" + liste.length);
		}

	}

	private void markMessage(int id) {

		ResponseEntity<String> responseEntity = template.postForEntity(this.marekUrl + id, null, null);

		if (responseEntity.getStatusCode() == HttpStatus.ACCEPTED) {
			System.out.println("marek message ");
		}
	}

	private void saveMessage(String messageName, int start, int end) {
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.setType(MessageType.In);
		messageDAO.setMessageName(messageName);
		messageDAO.setSaveDate(new Date());
		messageDAO.setUser_name("App douane");
		messageDAO.setStart(start);
		messageDAO.setEnd(end);

		messageRepository.save(messageDAO);
	}

}
