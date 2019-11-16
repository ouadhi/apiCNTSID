package com.douane.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the voyage_gros database table.
 * 
 */
@Entity
@Table(name="voyage_gros")
@NamedQuery(name="VoyageGro.findAll", query="SELECT v FROM VoyageGro v")
public class VoyageGro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id  
	private Long id;  

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="date_accostage")
	private Timestamp dateAccostage;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="numero_vi")
	private String numeroVi;

	@Column(name="tc_debarque")
	private short tcDebarque;

	@Column(name="tc_manifeste")
	private short tcManifeste;
	
	private boolean flag  ;
	
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date  dateMarkage  ; 

	public VoyageGro() {
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

	public Timestamp getDateAccostage() {
		return this.dateAccostage;
	}

	public void setDateAccostage(Timestamp dateAccostage) {
		this.dateAccostage = dateAccostage;
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

	public short getTcDebarque() {
		return this.tcDebarque;
	}

	public void setTcDebarque(short tcDebarque) {
		this.tcDebarque = tcDebarque;
	}

	public short getTcManifeste() {
		return this.tcManifeste;
	}

	public void setTcManifeste(short tcManifeste) {
		this.tcManifeste = tcManifeste;
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