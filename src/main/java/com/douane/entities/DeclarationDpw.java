package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the declaration_dpw database table.
 * 
 */
@Entity
@Table(name="declaration_dpw")
@NamedQuery(name="DeclarationDpw.findAll", query="SELECT d FROM DeclarationDpw d")
public class DeclarationDpw implements Serializable {
	private static final long serialVersionUID = 1L;  
	
	@Id 
	@GeneratedValue
	private  Long id ; 

	@Column(name="an_decl")
	private Timestamp anDecl;

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="date_ajout")
	private Timestamp dateAjout;

	@Temporal(TemporalType.DATE)
	@Column(name="date_av_ar")
	private Date dateAvAr;

	@Temporal(TemporalType.DATE)
	@Column(name="date_declaration")
	private Date dateDeclaration;

	private String fap;

	@Column(name="nom_agent")
	private String nomAgent;

	@Column(name="num_bl")
	private String numBl;

	@Column(name="num_cts")
	private String numCts;

	@Column(name="num_decl")
	private int numDecl;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="numero_vi")
	private String numeroVi;

	@Column(name="type_visite")
	private String typeVisite;
	
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date  dateMarkage ; 

	private String user;
	
	private boolean  flag  ; 

	public DeclarationDpw() {
	}

	public Timestamp getAnDecl() {
		return this.anDecl;
	}

	public void setAnDecl(Timestamp anDecl) {
		this.anDecl = anDecl;
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

	public Timestamp getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Date getDateAvAr() {
		return this.dateAvAr;
	}

	public void setDateAvAr(Date dateAvAr) {
		this.dateAvAr = dateAvAr;
	}

	public Date getDateDeclaration() {
		return this.dateDeclaration;
	}

	public void setDateDeclaration(Date dateDeclaration) {
		this.dateDeclaration = dateDeclaration;
	}

	public String getFap() {
		return this.fap;
	}

	public void setFap(String fap) {
		this.fap = fap;
	}

	public String getNomAgent() {
		return this.nomAgent;
	}

	public void setNomAgent(String nomAgent) {
		this.nomAgent = nomAgent;
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

	public int getNumDecl() {
		return this.numDecl;
	}

	public void setNumDecl(int numDecl) {
		this.numDecl = numDecl;
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

	public String getTypeVisite() {
		return this.typeVisite;
	}

	public void setTypeVisite(String typeVisite) {
		this.typeVisite = typeVisite;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
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