package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="voyage_gros")
public class VoyageGros implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue
	private Long id ; 
	private String numero_vi ; 
	private Date date_accostage ;  
	private int code_bur  ;  
	private Date an_manif ; 
	private int tc_debarque ; 
	private int tc_manifeste ;
	
	public VoyageGros(String numero_vi, Date date_accostage, int code_bur, Date an_manif, int tc_debarque,
			int tc_manifeste) {
		this.numero_vi = numero_vi;
		this.date_accostage = date_accostage;
		this.code_bur = code_bur;
		this.an_manif = an_manif;
		this.tc_debarque = tc_debarque;
		this.tc_manifeste = tc_manifeste;
	}
	
	
	public VoyageGros() {
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero_vi() {
		return numero_vi;
	}
	public void setNumero_vi(String numero_vi) {
		this.numero_vi = numero_vi;
	}
	public Date getDate_accostage() {
		return date_accostage;
	}
	public void setDate_accostage(Date date_accostage) {
		this.date_accostage = date_accostage;
	}
	public int getCode_bur() {
		return code_bur;
	}
	public void setCode_bur(int code_bur) {
		this.code_bur = code_bur;
	}
	public Date getAn_manif() {
		return an_manif;
	}
	public void setAn_manif(Date an_manif) {
		this.an_manif = an_manif;
	}
	public int getTc_debarque() {
		return tc_debarque;
	}
	public void setTc_debarque(int tc_debarque) {
		this.tc_debarque = tc_debarque;
	}
	public int getTc_manifeste() {
		return tc_manifeste;
	}
	public void setTc_manifeste(int tc_manifeste) {
		this.tc_manifeste = tc_manifeste;
	}  
	
	

}
