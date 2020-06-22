package com.douane.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douane.dpworld.tasks.Task;
import com.douane.entities.MessageDAO;
import com.douane.repository.MessageRepository;

@Service  
public class MessageDaoService {
	
	
	@Autowired
	private MessageRepository messageRepository;
	private static final Logger log = LoggerFactory.getLogger(Task.class);
	
	public void saveMessage(String messageName, int start, int end) {
		MessageDAO messageDAO = new MessageDAO();
		messageDAO.setType(MessageType.In);
		messageDAO.setMessageName(messageName);
		messageDAO.setSaveDate(new Date());
		messageDAO.setUser_name("App douane");
		messageDAO.setStart(start);
		messageDAO.setEnd(end);

		messageRepository.save(messageDAO);
		log.info("save and marked  debarquement  items" +start +" - "+ end );
	}

	
	
}
