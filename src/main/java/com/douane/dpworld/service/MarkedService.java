package com.douane.dpworld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.douane.config.ConstVar;


@Service
public class MarkedService {
	
	@Autowired 
	private  RestTemplate template  ; 
	
	public  void markMessage(int id) {

		ResponseEntity<String> responseEntity = template.postForEntity( ConstVar.marekUrl+ id, null, null);

		if (responseEntity.getStatusCode() == HttpStatus.ACCEPTED) {
			System.out.println("marek message ");
		}
	}

}
