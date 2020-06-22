package com.douane.dpworld.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.douane.config.ConstVar;
import com.douane.dpworld.entities.SortiePhysique;
import com.douane.dpworld.repository.PullOutRepository;
import com.douane.service.MessageDaoService;

@Component
public class PullOutService   {
	
	@Autowired
	private PullOutRepository outRepository;
	@Autowired
	private MarkedService markedService;
	@Autowired
	private MessageDaoService msgService;
	@Autowired
	private RestTemplate template;

	
	
	
	public void doFetch() {

		ResponseEntity<SortiePhysique[]> resppnse = template.getForEntity(ConstVar.URL_Sortie, SortiePhysique[].class);
		SortiePhysique[] liste = resppnse.getBody();
		

		if (liste.length > 0) {

			for (SortiePhysique sortiePhysique : liste) {

				if (!outRepository.existsById(sortiePhysique.getId())) {
					sortiePhysique.setAjoute(new Date());
					outRepository.save(sortiePhysique);
					this.markedService.markMessage(sortiePhysique.getId());
				} else {
					this.markedService.markMessage(sortiePhysique.getId());
					
				}

			}

			this.msgService.saveMessage("PullOut", liste[0].getId(), liste[liste.length - 1].getId());
			
		}

	}
	
}
