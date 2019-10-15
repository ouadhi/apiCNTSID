package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transfer")
public class Transfer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private  Long id; 
	@Temporal(TemporalType.DATE)
	private Date an_trans  ; 
	private int  num_trans ; 
	private Date  date_trans ; 
	private int code_bur ; 
	private Date an_manif ;  
	private int num_manif ;
	private int num_ligne ;
	private int num_group  ; 
	private String num_depot  ;  
	private String chassis ; 
	private String desing_march  ; 
	private int nbr_colist ; 
	private int nbr_colisd ;  
	private Date date_depot ;  
	private String lieu_trans  ;  
	private String nom_oper ;  
	private String adr_oper ; 
	private String provenance ; 
	private String lieu_stock ; 
	private Date date_apur ;
	
	public Transfer(Date an_trans, int num_trans, Date date_trans, int code_bur, Date an_manif, int num_manif,
			int num_ligne, int num_group, String num_depot, String chassis, String desing_march, int nbr_colist,
			int nbr_colisd, Date date_depot, String lieu_trans, String nom_oper, String adr_oper, String provenance,
			String lieu_stock, Date date_apur) {
		this.an_trans = an_trans;
		this.num_trans = num_trans;
		this.date_trans = date_trans;
		this.code_bur = code_bur;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.num_ligne = num_ligne;
		this.num_group = num_group;
		this.num_depot = num_depot;
		this.chassis = chassis;
		this.desing_march = desing_march;
		this.nbr_colist = nbr_colist;
		this.nbr_colisd = nbr_colisd;
		this.date_depot = date_depot;
		this.lieu_trans = lieu_trans;
		this.nom_oper = nom_oper;
		this.adr_oper = adr_oper;
		this.provenance = provenance;
		this.lieu_stock = lieu_stock;
		this.date_apur = date_apur;
	}

	public Transfer() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAn_trans() {
		return an_trans;
	}

	public void setAn_trans(Date an_trans) {
		this.an_trans = an_trans;
	}

	public int getNum_trans() {
		return num_trans;
	}

	public void setNum_trans(int num_trans) {
		this.num_trans = num_trans;
	}

	public Date getDate_trans() {
		return date_trans;
	}

	public void setDate_trans(Date date_trans) {
		this.date_trans = date_trans;
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

	public String getNum_depot() {
		return num_depot;
	}

	public void setNum_depot(String num_depot) {
		this.num_depot = num_depot;
	}

	public String getChassis() {
		return chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public String getDesing_march() {
		return desing_march;
	}

	public void setDesing_march(String desing_march) {
		this.desing_march = desing_march;
	}

	public int getNbr_colist() {
		return nbr_colist;
	}

	public void setNbr_colist(int nbr_colist) {
		this.nbr_colist = nbr_colist;
	}

	public int getNbr_colisd() {
		return nbr_colisd;
	}

	public void setNbr_colisd(int nbr_colisd) {
		this.nbr_colisd = nbr_colisd;
	}

	public Date getDate_depot() {
		return date_depot;
	}

	public void setDate_depot(Date date_depot) {
		this.date_depot = date_depot;
	}

	public String getLieu_trans() {
		return lieu_trans;
	}

	public void setLieu_trans(String lieu_trans) {
		this.lieu_trans = lieu_trans;
	}

	public String getNom_oper() {
		return nom_oper;
	}

	public void setNom_oper(String nom_oper) {
		this.nom_oper = nom_oper;
	}

	public String getAdr_oper() {
		return adr_oper;
	}

	public void setAdr_oper(String adr_oper) {
		this.adr_oper = adr_oper;
	}

	public String getProvenance() {
		return provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
	}

	public String getLieu_stock() {
		return lieu_stock;
	}

	public void setLieu_stock(String lieu_stock) {
		this.lieu_stock = lieu_stock;
	}

	public Date getDate_apur() {
		return date_apur;
	}

	public void setDate_apur(Date date_apur) {
		this.date_apur = date_apur;
	}  
	
	
	

}
