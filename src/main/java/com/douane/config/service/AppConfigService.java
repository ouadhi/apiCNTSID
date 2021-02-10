package com.douane.config.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douane.config.Entities.ConfigItem;
import com.douane.config.repository.AppConfigRepository;


@Service
public class AppConfigService {

	@Autowired
	private AppConfigRepository repository;
	private static final Logger log = LoggerFactory.getLogger(AppConfigService.class);

	public void save(ConfigItem item) {
		try {
			repository.save(item);

		} catch (Exception e) {
			log.error(e.getMessage());

		}
	}
	
	
	public void saveList(List<ConfigItem> liste) {
		try {
			for (ConfigItem item : liste) {
				ConfigItem config = repository.findById(item.getTitle()).get(); 
				config.setCron(item.getCron());
				config.setUrl(item.getUrl());
				config.setEnable(item.isEnable());
				this.save(config);
			}

		} catch (Exception e) {
			log.error(e.getMessage());

		}
	}
	
	
	
	public  ConfigItem  getById  (  String  id ) {
		try {
			
			return   repository.findById(id).get()  ; 
			
		} catch (Exception e) {
			log.error(e.getMessage());
			return  null ; 
		}
	}
	
	
	public List<ConfigItem>getAll  (){
		return repository.findAll() ; 
	}
	
	
	public void intConfig() {
		
		if(!repository.existsById("debarquement")) {
			ConfigItem item  = new ConfigItem() ; 
			item.setUrl("http://192.168.9.10:8088/api/containers");
			item.setEnable(true);
			item.setTitle("debarquement");
			item.setCron(1);
			repository.save(item)  ; 
		}
		
		if(!repository.existsById("parc")) {
			ConfigItem item  = new ConfigItem() ; 
			item.setUrl("http://192.168.9.10:8088/api/ciContainers");
			item.setEnable(true);
			item.setTitle("parc");
			item.setCron(1);
			repository.save(item)  ; 
		}
		
		if(!repository.existsById("out")) {
			ConfigItem item  = new ConfigItem() ; 
			item.setUrl("http://192.168.9.10:8088/api/pullouts");
			item.setEnable(true);
			item.setTitle("out");
			item.setCron(1);
			repository.save(item)  ; 
		}
		
		if(!repository.existsById("marked")) {
			ConfigItem item  = new ConfigItem() ; 
			item.setUrl("http://192.168.9.10:8088/api/markSaved/");
			item.setEnable(true);
			item.setTitle("marked");
			item.setCron(1);
			repository.save(item)  ; 
		}
	}
	
	
	
	

}
                                                                                                                                                                                                                                                                                                                                                       