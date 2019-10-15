package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dstr")
public class Dstr implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long  id ; 
	private int num_agrt ; 
	private Date  an_dst  ;  
	private int num_dst ; 
	private int  bur_dst  ;  
	private Date date_dst ; 
	private int code_bur ; 
	private Date an_manif ; 
	private int num_manif ;  
	private int num_ligne ; 
	private int num_group ; 
	private String design_march  ;  
	private int nb_colisd  ;  
	private double poidsb_d ; 
	private Date date_transf  ;  
	private int  num_apure  ;  
	private Date date_apure ; 
	private String lieu ; 
	private String nom_oper ;  
	private String adr_oper; 
	private String pays_frs ; 
	private String nom_frs ;  
	private String adr_frs ;  
	private String document  ; 
	private String type_dst  ;
	
	public Dstr(int num_agrt, Date an_dst, int num_dst, int bur_dst, Date date_dst, int code_bur, Date an_manif,
			int num_manif, int num_ligne, int num_group, String design_march, int nb_colisd, double poidsb_d,
			Date date_transf, int num_apure, Date date_apure, String lieu, String nom_oper, String adr_oper,
			String pays_frs, String nom_frs, String adr_frs, String document, String type_dst) {
		this.num_agrt = num_agrt;
		this.an_dst = an_dst;
		this.num_dst = num_dst;
		this.bur_dst = bur_dst;
		this.date_dst = date_dst;
		this.code_bur = code_bur;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.num_ligne = num_ligne;
		this.num_group = num_group;
		this.design_march = design_march;
		this.nb_colisd = nb_colisd;
		this.poidsb_d = poidsb_d;
		this.date_transf = date_transf;
		this.num_apure = num_apure;
		this.date_apure = date_apure;
		this.lieu = lieu;
		this.nom_oper = nom_oper;
		this.adr_oper = adr_oper;
		this.pays_frs = pays_frs;
		this.nom_frs = nom_frs;
		this.adr_frs = adr_frs;
		this.document = document;
		this.type_dst = type_dst;
	}

	public Dstr() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNum_agrt() {
		return num_agrt;
	}

	public void setNum_agrt(int num_agrt) {
		this.num_agrt = num_agrt;
	}

	public Date getAn_dst() {
		return an_dst;
	}

	public void setAn_dst(Date an_dst) {
		this.an_dst = an_dst;
	}

	public int getNum_dst() {
		return num_dst;
	}

	public void setNum_dst(int num_dst) {
		this.num_dst = num_dst;
	}

	public int getBur_dst() {
		return bur_dst;
	}

	public void setBur_dst(int bur_dst) {
		this.bur_dst = bur_dst;
	}

	public Date getDate_dst() {
		return date_dst;
	}

	public void setDate_dst(Date date_dst) {
		this.date_dst = date_dst;
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

	public String getDesign_march() {
		return design_march;
	}

	public void setDesign_march(String design_march) {
		this.design_march = design_march;
	}

	public int getNb_colisd() {
		return nb_colisd;
	}

	public void setNb_colisd(int nb_colisd) {
		this.nb_colisd = nb_colisd;
	}

	public double getPoidsb_d() {
		return poidsb_d;
	}

	public void setPoidsb_d(double poidsb_d) {
		this.poidsb_d = poidsb_d;
	}

	public Date getDate_transf() {
		return date_transf;
	}

	public void setDate_transf(Date date_transf) {
		this.date_transf = date_transf;
	}

	public int getNum_apure() {
		return num_apure;
	}

	public void setNum_apure(int num_apure) {
		this.num_apure = num_apure;
	}

	public Date getDate_apure() {
		return date_apure;
	}

	public void setDate_apure(Date date_apure) {
		this.date_apure = date_apure;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
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

	public String getPays_frs() {
		return pays_frs;
	}

	public void setPays_frs(String pays_frs) {
		this.pays_frs = pays_frs;
	}

	public String getNom_frs() {
		return nom_frs;
	}

	public void setNom_frs(String nom_frs) {
		this.nom_frs = nom_frs;
	}

	public String getAdr_frs() {
		return adr_frs;
	}

	public void setAdr_frs(String adr_frs) {
		this.adr_frs = adr_frs;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getType_dst() {
		return type_dst;
	}

	public void setType_dst(String type_dst) {
		this.type_dst = type_dst;
	} 
	
	
	
	
	
}
