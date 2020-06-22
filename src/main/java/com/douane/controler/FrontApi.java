package com.douane.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douane.dpworld.repository.ContneurParcVisiteRepository;
import com.douane.dpworld.repository.DebarquementRepository;
import com.douane.dpworld.repository.PullOutRepository;
import com.douane.repository.BaeDpwRepository;
import com.douane.repository.ConterVisiteRepository;
import com.douane.repository.DebarquementManifestRepositroy;
import com.douane.repository.DeclarationDpwRepository;
import com.douane.service.AppInfo;
import com.douane.service.MessageInItem;
import com.douane.service.MessageService;
import com.douane.service.MessgIn;
import com.douane.service.MessgOut;
import com.douane.service.MsgOutItem;

@RestController
@RequestMapping("/api/ui")
public class FrontApi {

	@Autowired
	private MessageService  messageService ; 

	@GetMapping(path = "")
	public AppInfo getAppInfo() {
		return this.messageService.createApiInfo(); 
	}

	@GetMapping(path = "/in")
	public MessgIn getInInfo() {

		return this.messageService.createIn();

	}

	@GetMapping(path = "/out")

	public MessgOut getOutInfo() {
		return this.messageService.createOut();
	}

	
	

}
