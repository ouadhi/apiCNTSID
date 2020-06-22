package com.douane.dpworld.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.douane.config.ConstVar;
import com.douane.dpworld.entities.ConteneurParcVisite;
import com.douane.dpworld.repository.ContneurParcVisiteRepository;
import com.douane.dpworld.repository.DebarquementRepository;
import com.douane.service.MessageDaoService;

@Component
public class ParcVisteService {

	@Autowired
	private ContneurParcVisiteRepository contneurParcVisiteRepository;;
	@Autowired
	private MarkedService markedService;
	@Autowired
	private MessageDaoService msgService;
	@Autowired
	private RestTemplate template;

	public void doFetch() {

		ResponseEntity<ConteneurParcVisite[]> resppnse = template.getForEntity(ConstVar.URL_Container,
				ConteneurParcVisite[].class);

		ConteneurParcVisite[] liste = resppnse.getBody();
		System.out.println(" size parc visite " + liste.length);
		if (liste.length > 0) {

			for (ConteneurParcVisite conteneurParcVisite : liste) {

				if (!contneurParcVisiteRepository.existsById(conteneurParcVisite.getId())) {
					conteneurParcVisite.setAjoute(new Date());
					contneurParcVisiteRepository.save(conteneurParcVisite);
					this.markedService.markMessage(conteneurParcVisite.getId());
				} else {
					this.markedService.markMessage(conteneurParcVisite.getId());

				}

			}

			this.msgService.saveMessage("Visite parc", liste[0].getId(), liste[liste.length - 1].getId());
		}
	}
}
