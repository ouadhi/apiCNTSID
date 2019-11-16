package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the manifest database table.
 * 
 */
@Entity
@NamedQuery(name="Manifest.findAll", query="SELECT m FROM Manifest m")
public class Manifest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="date_marquage")
	@Temporal(TemporalType.DATE)
	private Date dateMarquage;

	private boolean flag;

	@Column(name="num_bl")
	private String numBl;

	@Column(name="num_cts")
	private String numCts;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="numero_vi")
	private String numeroVi;

	@Column(name="tare_cts")
	private short tareCts;

	public Manifest() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public Date getDateMarquage() {
		return this.dateMarquage;
	}

	public void setDateMarquage(Date dateMarquage) {
		this.dateMarquage = dateMarquage;
	}

	public boolean getFlag() {
		return this.flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
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

	public short getTareCts() {
		return this.tareCts;
	}

	public void setTareCts(short tareCts) {
		this.tareCts = tareCts;
	}

}