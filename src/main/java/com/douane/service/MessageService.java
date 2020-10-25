package com.douane.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;
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

import io.swagger.models.auth.In;

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
	
	@Autowired 
	MessageRepository  messageRepository ; 
	@Autowired
	private Util util  ; 
	
	
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
	
	
	public  Map<?, ?> statstic_in (Date start  , Date  end ) {
		Map<String, Object>  map  = new  HashMap<String, Object>() ;  
		map.put("Debarquement", this.debarquementstatic(start, end))  ; 
	    map.put("Parc Visite", this.parcvisitestatic(start, end)) ; 
		map.put("pullout", this.pulloutstatic(start, end)) ; 
		
		
		return  map ; 
	}
	
	
	public  List<?> pulloutstatic (Date start  , Date  end ) {
 		
		List<Date> days = util.getDatesBetweenUsingJava7(end, start)  ; 
		List<Map<String , String>> elements = new  ArrayList<>()  ; 
		
		for (Date date : days) {
			int count  =  this.poreppsitory.countByDate(date) ; 
			HashMap<String , String>  element =  new HashMap<String, String>() ; 
			element.put("date", util.StringDateFormat(date))  ;  
			element.put("count", Integer.toString(count)) ; 
			
			elements.add(element) ; 
		}
		
		
		return  elements ; 
	}
	
	
	private  List<?> debarquementstatic (Date start  , Date  end ) {
		List<Date> days = util.getDatesBetweenUsingJava7(end, start)  ; 
		List<Map<String , String>> elements = new  ArrayList<>()  ; 
		
		for (Date date : days) {
			int count  =  this.drepository.countByDate(date) ; 
			HashMap<String , String>  element =  new HashMap<String, String>() ; 
			element.put("date", util.StringDateFormat(date))  ;  
			element.put("count", Integer.toString(count)) ; 
			
			elements.add(element) ; 
		}
		
		
		return  elements ; 
	}
	
	
	private  List<?> parcvisitestatic (Date start  , Date  end ) {
		List<Date> days = util.getDatesBetweenUsingJava7(end, start)  ; 
		List<Map<String , String>> elements = new  ArrayList<>()  ; 
		
		for (Date date : days) {
			int count  =  this.cpvrepository.countByDate(date) ; 
			HashMap<String , String>  element =  new HashMap<String, String>() ; 
			element.put("date", util.StringDateFormat(date))  ;  
			element.put("count", Integer.toString(count)) ; 
			
			elements.add(element) ; 
		}
		
		
		return  elements ; 
	}
	
	

	public  Map<?, ?> statstic_in_v2 (Date start  , Date  end ) {
		List<Date> days = util.getDatesBetweenUsingJava7(end, start)  ; 
		
		Map<String, Object>  map  = new  HashMap<String, Object>() ;  
		map.put("date",util.listDateFormat(days))  ; 
	    map.put("debarquement", this.countsdebar(days)) ; 
	    map.put("parc", this.countsparc(days)) ; 
		map.put("pullout", this.countsouts(days)) ; 
		
		
		return  map ; 
	}
	
	
	private List<Integer> countsouts (List<Date> days ) {
		List<Integer>  counts  = new  ArrayList<Integer>()   ;   
		for (Date date : days) {
			counts.add(poreppsitory.countByDate(date)); 
			
		}
		
			return counts  ; 
	
	}
	
	private List<Integer> countsparc(List<Date> days ) {
		List<Integer>  counts  = new  ArrayList<Integer>()   ;   
		for (Date date : days) {
			counts.add(cpvrepository.countByDate(date)); 
			
		}
		
			return counts  ; 
	
	}
	
	private List<Integer> countsdebar (List<Date> days ) {
		List<Integer>  counts  = new  ArrayList<Integer>()   ;   
		for (Date date : days) {
			counts.add(drepository.countByDate(date)); 
			
		}
		
			return counts  ; 
	
	}
	
	


}
