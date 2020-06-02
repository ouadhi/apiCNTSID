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
import com.douane.service.MessgIn;
import com.douane.service.MessgOut;
import com.douane.service.MsgOutItem;

@RestController
@RequestMapping("/api/ui")
public class FrontApi {

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

	@GetMapping(path = "")
	public AppInfo getAppInfo() {
		AppInfo appInfo = new AppInfo();
		appInfo.setIn(createIn());
		appInfo.setOut(createOut());

		return appInfo;
	}

	@GetMapping(path = "/in")
	public MessgIn getInInfo() {

		return this.createIn();

	}

	@GetMapping(path = "/out")

	public MessgOut getOutInfo() {
		return createOut();
	}

	@GetMapping(path = "/debarquement")

	public MessageInItem getDebarquementIfo() {
		MessageInItem debarqument = new MessageInItem("debarquement", drepository.count_today(),
				drepository.count_all());
		return debarqument;
	}

	private MessgIn createIn() {
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

	private MessgOut createOut() {
		MessgOut messgOut = new MessgOut();

		MsgOutItem manif = new MsgOutItem("manifest", deb_manifets.getCount(), deb_manifets.getCountConsumed());
		messgOut.addItem(manif);
		MsgOutItem decl = new MsgOutItem("declaration", decldpw.getCount(), decldpw.getCountConsumed());
		messgOut.addItem(decl);
		MsgOutItem contre = new MsgOutItem("contre", contervisite.getCount(), contervisite.getCount());
		messgOut.addItem(contre);
		MsgOutItem baedp = new MsgOutItem("bae", bae.getCount(), bae.getCountConsumed());
		messgOut.addItem(baedp);

		return messgOut;
	}

}
