package com.douane.dpworld.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.douane.config.ConstVar;
import com.douane.dpworld.entities.ConteneurParcVisite;
import com.douane.dpworld.entities.SortiePhysique;
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

	public int  doFetch() {
		System.out.println("parc");
		// fetch API and save response
		ResponseEntity<ConteneurParcVisite[]> response = template.getForEntity(ConstVar.URL_Sortie, ConteneurParcVisite[].class);

		// get body response
		ConteneurParcVisite[] body = response.getBody();
		// convert body to List with same argumant
		List<ConteneurParcVisite> apiList = new ArrayList<ConteneurParcVisite>();
		apiList = Arrays.asList(body);
		System.out.println(apiList.size());

		// getAll items saved in data base
		ArrayList<ConteneurParcVisite> listDB = (ArrayList<ConteneurParcVisite>) contneurParcVisiteRepository.findAll();
		
		System.out.println(listDB);

		// get ids from DB list
		Set<Integer> ids = listDB.stream().map(ConteneurParcVisite::getId).collect(Collectors.toSet());

		// deffirence between tow list
		List<ConteneurParcVisite> parentlist = apiList.stream().filter(sortie -> !ids.contains(sortie.getId()))
				.collect(Collectors.toList());
		System.out.println(parentlist.size());

		int count_save = parentlist.size();
		parentlist.stream().forEach(item  -> item.setAjoute(new Date()));
		// save deffirence in data base
		contneurParcVisiteRepository.saveAll(parentlist);
		// marked items

		// logs details
		if (count_save >0)
			this.msgService.saveMessage("Visite parc", parentlist.get(0).getId(),
					parentlist.get(count_save - 1).getId());

		return count_save;
		
	}
}
