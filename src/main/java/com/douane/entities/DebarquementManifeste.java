package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="debarquement_manifeste")
@NamedQuery(name="DebarquementManifeste.findAll", query="SELECT d FROM DebarquementManifeste d")
public class DebarquementManifeste implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private  Long id  ;  

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	private String containertype;

	@Column(name="date_accostage")
	private Timestamp dateAccostage;

	@Column(name="date_arrivee")
	private Timestamp dateArrivee;

	@Column(name="date_debarquement")
	private Timestamp dateDebarquement;

	@Column(name="etat_lign")
	private String etatLign;

	@Column(name="num_bl")
	private String numBl;

	@Column(name="num_cts")
	private String numCts;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_magasin")
	private short numMagasin;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="numero_vi")
	private String numeroVi;
    
	@Column(name="position")
	private String position;
	
	@Column(name="flag")
	private boolean  flag  ; 
	
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date dateMarkage ;  

	public DebarquementManifeste() {
	}

	public Timestamp getAnManif() {
		return this.anManif;
	}

	public void setAnManif(Timestamp anManif) {
		this.anManif = anManif;
	}

	public short getCodeBur() {
		return this.codeBur;
	}

	public void setCodeBur(short codeBur) {
		this.codeBur = codeBur;
	}

	public String getContainertype() {
		return this.containertype;
	}

	public void setContainertype(String containertype) {
		this.containertype = containertype;
	}

	public Timestamp getDateAccostage() {
		return this.dateAccostage;
	}

	public void setDateAccostage(Timestamp dateAccostage) {
		this.dateAccostage = dateAccostage;
	}

	public Timestamp getDateArrivee() {
		return this.dateArrivee;
	}

	public void setDateArrivee(Timestamp dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public Timestamp getDateDebarquement() {
		return this.dateDebarquement;
	}

	public void setDateDebarquement(Timestamp dateDebarquement) {
		this.dateDebarquement = dateDebarquement;
	}

	public String getEtatLign() {
		return this.etatLign;
	}

	public void setEtatLign(String etatLign) {
		this.etatLign = etatLign;
	}

	public String getNumBl() {
		return this.numBl;
	}

	public void setNumBl(String numBl) {
		this.numBl = numBl;
	}

	public String getNumCts() {
		return this.numCts;
	}

	public void setNumCts(String numCts) {
		this.numCts = numCts;
	}

	public short getNumGroup() {
		return this.numGroup;
	}

	public void setNumGroup(short numGroup) {
		this.numGroup = numGroup;
	}

	public short getNumLigne() {
		return this.numLigne;
	}

	public void setNumLigne(short numLigne) {
		this.numLigne = numLigne;
	}

	public short getNumMagasin() {
		return this.numMagasin;
	}

	public void setNumMagasin(short numMagasin) {
		this.numMagasin = numMagasin;
	}

	public int getNumManif() {
		return this.numManif;
	}

	public void setNumManif(int numManif) {
		this.numManif = numManif;
	}

	public String getNumeroVi() {
		return this.numeroVi;
	}

	public void setNumeroVi(String numeroVi) {
		this.numeroVi = numeroVi;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Date getDateMarkage() {
		return dateMarkage;
	}

	public void setDateMarkage(Date dateMarkage) {
		this.dateMarkage = dateMarkage;
	}
	
	
	


}