package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;

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
	private static final long serialVersionUID = 1L;  
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long id ; 

	@Column(name="an_decl")
	private Timestamp anDecl;

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short code_bur;

	@Column(name="date_ajout")
	private Timestamp dateAjout;

	@Temporal(TemporalType.DATE)
	@Column(name="date_av_ar")
	private Date date_av_ar;

	@Temporal(TemporalType.DATE)
	@Column(name="date_declaration")
	private Date date_declaration;

	private String fap;

	@Column(name="nom_agent")
	private String nom_agent;

	@Column(name="num_bl")
	private String num_bl;

	@Column(name="num_cts")
	private String num_cts;

	@Column(name="num_decl")
	private int num_decl;

	@Column(name="num_group")
	private short num_group;

	@Column(name="num_ligne")
	private short num_ligne;

	@Column(name="num_manif")
	private int num_manif;

	@Column(name="numero_vi")
	private String numero_vi;

	@Column(name="type_visite")
	private String type_visite;
	
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date  date_markage ; 

	private String user;
	
	private boolean  flag  ; 

	
	

}