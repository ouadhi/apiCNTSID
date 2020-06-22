package com.douane.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douane.dpworld.repository.ContneurParcVisiteRepository;
import com.douane.dpworld.repository.DebarquementRepository;
import com.douane.dpworld.repository.PullOutRepository;
import com.douane.repository.BaeDpwRepository;
import com.douane.repository.ConterVisiteRepository;
import com.douane.repository.DebarquementManifestRepositroy;
import com.douane.repository.DeclarationDpwRepository;
import com.douane.repository.MessageRepository;

import springfox.documentation.service.ApiInfo;

@Service 
public class MessageService {
	
	@Autowired
	private ContneurParcVisiteRepository cpvrepository;
	@Autowired
	private DebarquementRepository drepository;
	@Autowired
	private PullOutRepository poreppsitory;

	@Autowired
	private DebarquementManifestRepositroy deb_manifets;
	@Autowired
	private DeclarationDpwRepository decldpw;
	@Autowired
	private ConterVisiteRepository contervisite;
	@Autowired
	private BaeDpwRepository bae;
	
	@Autowired MessageRepository  messageRepository ;  
	
	public  MessgIn createIn() {
		MessgIn messgIn = new MessgIn();

		MessageInItem parcvisite = new MessageInItem("parc visite", cpvrepository.count_today(),
				cpvrepository.count_all());
		messgIn.additem(parcvisite);

		MessageInItem debarqument = new MessageInItem("debarquement", drepository.count_today(),
				drepository.count_all());
		messgIn.additem(debarqument);

		MessageInItem pullout = new MessageInItem("pullout", poreppsitory.count_today(), poreppsitory.count_all());
		messgIn.additem(pullout);

		return messgIn;

	}

	public MessgOut createOut() {
		MessgOut messgOut = new MessgOut();

		MsgOutItem manif = new MsgOutItem("manifest", deb_manifets.getCount(), deb_manifets.getCountConsumed());
		messgOut.addItem(manif);
		MsgOutItem decl = new MsgOutItem("declaration", decldpw.getCount(), decldpw.getCountConsumed());
		messgOut.addItem(decl);
		MsgOutItem contre = new MsgOutItem("contre", contervisite.getCount(), contervisite.getCountConsumed());
		messgOut.addItem(contre);
		MsgOutItem baedp = new MsgOutItem("bae", bae.getCount(), bae.getCountConsumed());
		messgOut.addItem(baedp);

		return messgOut;
	}
	
	public AppInfo createApiInfo() {
		AppInfo appInfo = new AppInfo();
		appInfo.setIn(createIn());
		appInfo.setOut(createOut());

		return appInfo;
	}
	
	
	public HashMap< String, Object>  inInfo  ()  {
		HashMap<String, Object>  map  =  new HashMap() ; 
		map.put("stat", this.createIn()) ; 
		map.put("liste" , this.messageRepository.getMessagesByType(MessageType.In))  ; 
	
		return  map ; 
	}
	
	public HashMap< String, Object>  outInfo  ()  {
		HashMap<String, Object>  map  =  new HashMap() ; 
		map.put("stat", this.createOut()) ; 
		map.put("liste" , this.messageRepository.getMessagesByType(MessageType.Out))  ; 
	
		return  map ; 
	}


}
