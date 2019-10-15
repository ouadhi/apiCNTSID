package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="debarquement_manifeste")
public class DebarquementManifeste implements   Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long  id  ;  
	private String numero_vi ; 
	private String num_bl ; 
	private String  num_cts ;  
	private char containertype ;  
	private String position ; 
	private Date date_debarquement ; 
	private Date date_arrivee ; 
	private Date date_accostage ; 
	private int code_bur ; 
	private Date an_manif ; 
	private int num_manif  ;  
	private int num_ligne ; 
	private int num_group ;  
	private char etat_lign ; 
	private int  num_magasin  ;
	public DebarquementManifeste(String numero_vi, String num_bl, String num_cts, char containertype, String position,
			Date date_debarquement, Date date_arrivee, Date date_accostage, int code_bur, Date an_manif, int num_manif,
			int num_ligne, int num_group, char etat_lign, int num_magasin) {
		this.numero_vi = numero_vi;
		this.num_bl = num_bl;
		this.num_cts = num_cts;
		this.containertype = containertype;
		this.position = position;
		this.date_debarquement = date_debarquement;
		this.date_arrivee = date_arrivee;
		this.date_accostage = date_accostage;
		this.code_bur = code_bur;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.num_ligne = num_ligne;
		this.num_group = num_group;
		this.etat_lign = etat_lign;
		this.num_magasin = num_magasin;
	}
	public DebarquementManifeste() {
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
	public String getNum_bl() {
		return num_bl;
	}
	public void setNum_bl(String num_bl) {
		this.num_bl = num_bl;
	}
	public String getNum_cts() {
		return num_cts;
	}
	public void setNum_cts(String num_cts) {
		this.num_cts = num_cts;
	}
	public char getContainertype() {
		return containertype;
	}
	public void setContainertype(char containertype) {
		this.containertype = containertype;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Date getDate_debarquement() {
		return date_debarquement;
	}
	public void setDate_debarquement(Date date_debarquement) {
		this.date_debarquement = date_debarquement;
	}
	public Date getDate_arrivee() {
		return date_arrivee;
	}
	public void setDate_arrivee(Date date_arrivee) {
		this.date_arrivee = date_arrivee;
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
	public int getNum_manif() {
		return num_manif;
	}
	public void setNum_manif(int num_manif) {
		this.num_manif = num_manif;
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
	public char getEtat_lign() {
		return etat_lign;
	}
	public void setEtat_lign(char etat_lign) {
		this.etat_lign = etat_lign;
	}
	public int getNum_magasin() {
		return num_magasin;
	}
	public void setNum_magasin(int num_magasin) {
		this.num_magasin = num_magasin;
	} 
	
	
	
	
}
