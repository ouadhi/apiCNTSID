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
import com.douane.dpworld.entities.Debarquement;
import com.douane.dpworld.entities.SortiePhysique;
import com.douane.dpworld.repository.PullOutRepository;
import com.douane.service.MessageDaoService;

@Component
public class PullOutService {

	@Autowired
	private PullOutRepository outRepository;
	@Autowired
	private MarkedService markedService;
	@Autowired
	private MessageDaoService msgService;
	@Autowired
	private RestTemplate template;

	public int doFetch() {
		
		System.out.println("Pull out");

		// fetch API and save response
		ResponseEntity<SortiePhysique[]> response = template.getForEntity(ConstVar.URL_Sortie,
				SortiePhysique[].class);

		// get body response
		SortiePhysique[] body = response.getBody();
		// convert body to List with same argumant
		List<SortiePhysique> apiList = new ArrayList<SortiePhysique>();
		apiList = Arrays.asList(body);
		System.out.println("ApiLis"+apiList.size());
		

		// getAll items saved in data base
		ArrayList<SortiePhysique> listDB = (ArrayList<SortiePhysique>) outRepository.findAll();
		
		System.out.println("DbList"+listDB.size());

		// get ids from DB list
		Set<Integer> ids = listDB.stream().map(SortiePhysique::getId).collect(Collectors.toSet());

		// deffirence between tow list
		List<SortiePhysique> parentlist = apiList.stream().filter(sortie -> !ids.contains(sortie.getId()))
				.collect(Collectors.toList());
		
		
		System.out.println("parentList"+parentlist.size());

		int count_save = parentlist.size();
		parentlist.stream().forEach(item  -> item.setAjoute(new Date()));
		outRepository.saveAll(parentlist);
		// marked items

		// logs details
		if (count_save >0)
			this.msgService.saveMessage("PullOut", parentlist.get(0).getId(),
					parentlist.get(count_save - 1).getId());

		return count_save  ; 

	}

}
