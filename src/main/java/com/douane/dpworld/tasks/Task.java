package com.douane.dpworld.tasks;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

	private static final Logger log = LoggerFactory.getLogger(Task.class);

	@Override
	@Scheduled(fixedDelay = 15*60*1000)
	public void fetchPullOut() {

		this.outService.doFetch();
	}

	@Override
	@Scheduled(fixedDelay = 15*60*1000)

	public void fetchDebarquement() {
		this.debarquementService.doFetch();
	}

	@Override
	@Scheduled(fixedDelay = 15*60*1000)

	public void fetchContainerVisit() {

		this.parcService.doFetch();

	}

}
