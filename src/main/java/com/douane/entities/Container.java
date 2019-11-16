package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the containers database table.
 * 
 */
@Entity
@Table(name="containers")
@NamedQuery(name="Container.findAll", query="SELECT c FROM Container c")
public class Container implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue 
	private  Long id   ; 

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="nbr_colis")
	private int nbrColis;

	@Column(name="num_cts")
	private String numCts;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="tare_cts")
	private int tareCts;
	
	@Column(name="flag")
	private boolean  flag ;
	
	@Temporal(TemporalType.DATE)
	private Date dateMarkage ; 
	

	public Container() {
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

	public int getNbrColis() {
		return this.nbrColis;
	}

	public void setNbrColis(int nbrColis) {
		this.nbrColis = nbrColis;
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

	public int getTareCts() {
		return this.tareCts;
	}

	public void setTareCts(int tareCts) {
		this.tareCts = tareCts;
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