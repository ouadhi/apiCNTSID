package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Null;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Timestamp;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="declaration_dpw")
@NamedQuery(name="DeclarationDpw.findAll", query="SELECT d FROM DeclarationDpw d")
public class DeclarationDpw implements Serializable {

	@Id 
	private  Long id ; 
	 
	@Column(name="flag")
	private boolean  flag  ;
	
	@Column(name="numero_vi")
	private String numero_vi;
	
	@Column(name="num_bl")
	private String num_bl;
	
	@Column(name="num_cts")
	private String num_cts;
	
	@Column(name="code_bur")
	private short code_bur;
	
	@Column(name="an_manif")
	@Temporal(TemporalType.DATE)
	private Date  anManif;
	
	@Column(name="num_manif")
	private int num_manif;
	
	@Column(name="num_ligne")
	private short num_ligne;
	
	@Column(name="num_group")
	private short num_group;
	
	@Column(name="an_decl")
	@Temporal(TemporalType.DATE)
	private Date anDecl;
	
	@Column(name="num_decl")
	private int num_decl;
	
	@Column(name="type_visite")
	private String type_visite;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_declaration")
	private Date date_declaration;
	
	private String fap;
	
	@Column(name="nom_agent")
	private String nom_agent;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_av_ar")
	private Date date_av_ar;
	
	@Column(name="date_ajout")
	@Temporal(TemporalType.DATE)
	private Date dateAjout;
	
	private String user;

	



	

	

	

	

	

	

	
	



	

	

	

	

	/*
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date  date_markage ; 

	
	
	private boolean  flag  ; 
	*/

	
	

}