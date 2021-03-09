package com.douane.dpworld.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.douane.config.Entities.ConfigItem;
import com.douane.config.service.AppConfigService;
import com.douane.dpworld.service.DebarquementService;
import com.douane.dpworld.service.ParcVisteService;
import com.douane.dpworld.service.PullOutService;

@Component
public class Task implements Itasks {

	@Autowired
	private DebarquementService debarquementService;
	@Autowired
	private ParcVisteService parcService;
	@Autowired
	private PullOutService outService;
	@Autowired
	private AppConfigService configService;

	private ConfigItem jobConfig;
	private static final Logger log = LoggerFactory.getLogger(Task.class);

	private final String debarquement = "debarquement";
	private final String parcVisite = "parc";
	private final String pullout = "out";

	@Override
	@Scheduled(fixedDelay = 5 * 1000)
	public void fetchPullOut() {
		jobConfig = configService.getById(pullout);

		if (jobConfig.isEnable())
			this.outService.doFetch();

	}

	@Override
	@Scheduled(fixedDelay = 5 * 1000)
	public void fetchDebarquement() {
		jobConfig = configService.getById(debarquement);

		if (jobConfig.isEnable())
			this.debarquementService.doFetch();
	}

	@Override
	@Scheduled(fixedDelay = 5 * 1000)
	public void fetchContainerVisit() {
		jobConfig = configService.getById(parcVisite);

		if (jobConfig.isEnable())
			this.parcService.doFetch();

	}

}
