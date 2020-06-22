package com.douane.entities;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.douane.config.Properties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Timestamp;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bae_dpw")
@NamedQuery(name="BaeDpw.findAll", query="SELECT b FROM BaeDpw b")
public class BaeDpw implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private  Long  id ; 
	
	@Column(name="flag")
	private boolean  flag  ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_markage")
	private Date date_markage;
	
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
	private Date an_manif;
	
	@Column(name="num_manif")
	private int num_manif;
	
	@Column(name="num_ligne")
	private short num_ligne;
	
	@Column(name="num_group")
	private short num_group;
	
	@Column(name="num_decl")
	private int num_decl;

	@Temporal(TemporalType.DATE)
	@Column(name="date_bae")
	private Date date_bae;

	

	

	
	

	

	

	@Column(name="type_declaration")
	private String type_declaration;
	
	
	
	
	//  ingnore attribute mapping and  in  the same  time  we innclude in  Json  Response  .  
	//  we  use  transient annotation  to  ingnore  mapping  
	// and   seconde  annotation  to  include it  in  the  Json  response .   
	/*
	@Transient
	@JsonInclude
	private URI  linkGetById  ; //  or  String   link
	
	*/
	
	

	

}