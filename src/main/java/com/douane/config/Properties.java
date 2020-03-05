package com.douane.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")

public class Properties {

	private String address;
	private String prefix;
	private  int port  ; 
	
	public Properties() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public int getPort() {
		return port;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
}
