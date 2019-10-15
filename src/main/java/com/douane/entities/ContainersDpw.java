package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="containers_dpw")
public class ContainersDpw implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private  Long id  ; 
	private  Date an_manif ; 
	private int num_manif ; 
	private int code_bur  ;  
	private int num_ligne ;  
	private int num_group ; 
	private String num_cts; 
	private int tar_cts  ; 
	private int colis  ;  
	private String num_reference ; 
	private String etat_lign ; 
	private int num_magasin ;
	
	
	public ContainersDpw(Long id, Date an_manif, int num_manif, int code_bur, int num_ligne, int num_group,
			String num_cts, int tar_cts, int colis, String num_reference, String etat_lign, int num_magasin) {
		this.id = id;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.code_bur = code_bur;
		this.num_ligne = num_ligne;
		this.num_group = num_group;
		this.num_cts = num_cts;
		this.tar_cts = tar_cts;
		this.colis = colis;
		this.num_reference = num_reference;
		this.etat_lign = etat_lign;
		this.num_magasin = num_magasin;
	}


	public ContainersDpw() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getAn_manif() {
		return an_manif;
	}


	public void setAn_manif(Date an_manif) {
		this.an_manif = an_manif;
	}


	public int getNum_manif() {
		return num_manif;
	}


	public void setNum_manif(int num_manif) {
		this.num_manif = num_manif;
	}


	public int getCode_bur() {
		return code_bur;
	}


	public void setCode_bur(int code_bur) {
		this.code_bur = code_bur;
	}


	public int getNum_ligne() {
		return num_ligne;
	}


	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}


	public int getNum_group() {
		return num_group;
	}


	public void setNum_group(int num_group) {
		this.num_group = num_group;
	}


	public String getNum_cts() {
		return num_cts;
	}


	public void setNum_cts(String num_cts) {
		this.num_cts = num_cts;
	}


	public int getTar_cts() {
		return tar_cts;
	}


	public void setTar_cts(int tar_cts) {
		this.tar_cts = tar_cts;
	}


	public int getColis() {
		return colis;
	}


	public void setColis(int colis) {
		this.colis = colis;
	}


	public String getNum_reference() {
		return num_reference;
	}


	public void setNum_reference(String num_reference) {
		this.num_reference = num_reference;
	}


	public String getEtat_lign() {
		return etat_lign;
	}


	public void setEtat_lign(String etat_lign) {
		this.etat_lign = etat_lign;
	}


	public int getNum_magasin() {
		return num_magasin;
	}


	public void setNum_magasin(int num_magasin) {
		this.num_magasin = num_magasin;
	} 
	
	
	

}
