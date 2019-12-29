package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;



@Entity
@Table(name="bae_dpw")
@NamedQuery(name="BaeDpw.findAll", query="SELECT b FROM BaeDpw b")
public class BaeDpw implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long  id ; 

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	@Temporal(TemporalType.DATE)
	@Column(name="date_bae")
	private Date dateBae;

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

	@Column(name="type_declaration")
	private String typeDeclaration;
	
	@Column(name="flag")
	private boolean  flag  ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_markage")
	private Date dateMarkage;

	public BaeDpw() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateBae() {
		return this.dateBae;
	}

	public void setDateBae(Date dateBae) {
		this.dateBae = dateBae;
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

	public String getTypeDeclaration() {
		return this.typeDeclaration;
	}

	public void setTypeDeclaration(String typeDeclaration) {
		this.typeDeclaration = typeDeclaration;
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