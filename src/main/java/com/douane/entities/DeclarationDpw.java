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
@Table(name="declaration_dpw")
public class DeclarationDpw implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id  ;  
	private String  numero_vi ; 
	private String num_bl  ; 
	private String num_cts  ; 
	private int code_bur;  
	private Date an_manif ; 
	private int num_ligne ; 
	private int num_group  ; 
	private Date an_decl  ; 
	private int num_decl  ; 
	private char type_visite  ; 
	private Date date_declaration  ; 
	private char fap  ; 
	private String nom_agent ; 
	private Date  date_av_ar ; 
	private String user ; 
	private boolean flag ; 
	@Temporal(TemporalType.DATE)
	private Date date_ajout ; 
	
	public DeclarationDpw(String numero_vi, String num_bl, String num_cts, int code_bur, Date an_manif, int num_ligne,
			int num_group, Date an_decl, int num_decl, char type_visite, Date date_declaration, char fap,
			String nom_agent, Date date_av_ar, Date date_ajout, String user) {
		this.numero_vi = numero_vi;
		this.num_bl = num_bl;
		this.num_cts = num_cts;
		this.code_bur = code_bur;
		this.an_manif = an_manif;
		this.num_ligne = num_ligne;
		this.num_group = num_group;
		this.an_decl = an_decl;
		this.num_decl = num_decl;
		this.type_visite = type_visite;
		this.date_declaration = date_declaration;
		this.fap = fap;
		this.nom_agent = nom_agent;
		this.date_av_ar = date_av_ar;
		this.date_ajout = date_ajout;
		this.user = user;
	}
	
	public DeclarationDpw() {
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
	public Date getAn_decl() {
		return an_decl;
	}
	public void setAn_decl(Date an_decl) {
		this.an_decl = an_decl;
	}
	public int getNum_decl() {
		return num_decl;
	}
	public void setNum_decl(int num_decl) {
		this.num_decl = num_decl;
	}
	public char getType_visite() {
		return type_visite;
	}
	public void setType_visite(char type_visite) {
		this.type_visite = type_visite;
	}
	public Date getDate_declaration() {
		return date_declaration;
	}
	public void setDate_declaration(Date date_declaration) {
		this.date_declaration = date_declaration;
	}
	public char getFap() {
		return fap;
	}
	public void setFap(char fap) {
		this.fap = fap;
	}
	public String getNom_agent() {
		return nom_agent;
	}
	public void setNom_agent(String nom_agent) {
		this.nom_agent = nom_agent;
	}
	public Date getDate_av_ar() {
		return date_av_ar;
	}
	public void setDate_av_ar(Date date_av_ar) {
		this.date_av_ar = date_av_ar;
	}
	public Date getDate_ajout() {
		return date_ajout;
	}
	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	} 
	
	
	
	

}
