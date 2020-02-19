package com.douane.securite.model;

import java.util.Date;

public class JwtValideResponse {

	private String token;
	private boolean valide;
	private Date dateExpiration;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isValide() {
		return valide;
	}
	public void setValide(boolean valide) {
		this.valide = valide;
	}
	public Date getDateExpiration() {
		return dateExpiration;
	}
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	
	public JwtValideResponse() {
		
	}

}
