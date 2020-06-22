package com.douane.dpworld.service;

import java.util.Date;

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

	public void doFetch() {

		ResponseEntity<Debarquement[]> response = template.getForEntity(ConstVar.URL_debarquement,
				Debarquement[].class);

		Debarquement[] liste = response.getBody();

		if (liste.length > 0) {

			for (Debarquement debarquement : liste) {

				if (!debarquementRepository.existsById(debarquement.getId())) {
					debarquement.setAjoute(new Date());
					debarquementRepository.save(debarquement);
					this.markedService.markMessage(debarquement.getId());
				} else {
					this.markedService.markMessage(debarquement.getId());
				}

			}
			this.msgService.saveMessage("Debarquement", liste[0].getId(), liste[liste.length - 1].getId());
		}

	}
}
