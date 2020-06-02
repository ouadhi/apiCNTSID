package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="debarquement_manifeste")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="DebarquementManifeste.findAll", query="SELECT d FROM DebarquementManifeste d")
public class DebarquementManifeste implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long   id ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_markage")
	private Date date_markage;
	
	@Column(name="flag")
	private boolean  flag  ;
	
	@Column(name="numero_vi")
	private String numeroVi;
	
	@Column(name="num_bl")
	private String numBl;
	
	@Column(name="num_cts")
	private String numCts;
	
	private String containertype;
	
	@Column(name="position")
	private String position;
	
	@Column(name="date_debarquement")
	@Temporal(TemporalType.DATE)
	private Date dateDebarquement;
	
	@Column(name="date_arrivee")
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	
	@Column(name="date_accostage")
	@Temporal(TemporalType.DATE)
	private Date dateAccostage;
	
	@Column(name="code_bur")
	private short codeBur;
	
	@Column(name="an_manif")
	@Temporal(TemporalType.DATE)
	private Date anManif;
	
	@Column(name="num_manif")
	private int numManif;
	
	@Column(name="num_ligne")
	private short numLigne;
	
	@Column(name="num_group")
	private short numGroup;
	
	@Column(name="etat_lign")
	private String etatLign;


	@Column(name="num_magasin")
	private short numMagasin;
	
	
	
	

	

	


}