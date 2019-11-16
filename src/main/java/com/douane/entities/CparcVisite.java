package com.douane.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cparcvisite database table.
 * 
 */
@Entity
@NamedQuery(name="Cparcvisite.findAll", query="SELECT c FROM Cparcvisite c")
public class Cparcvisite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="date_transfert")
	private Date dateTransfert;
	
	@Id
	private Long id;

	@Column(name="num_bl")
	private String numBl;

	@Column(name="num_cts")
	private String numCts;

	@Column(name="numero_vi")
	private String numeroVi;
	
	@Column(name = "date_markage")
	private Date DateMarkage ; 
	private boolean flage ; 

	public Cparcvisite() {
	}

	public Date getDateTransfert() {
		return this.dateTransfert;
	}

	public void setDateTransfert(Date dateTransfert) {
		this.dateTransfert = dateTransfert;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getNumeroVi() {
		return this.numeroVi;
	}

	public void setNumeroVi(String numeroVi) {
		this.numeroVi = numeroVi;
	}

	public Date getDateMarkage() {
		return DateMarkage;
	}

	public void setDateMarkage(Date dateMarkage) {
		DateMarkage = dateMarkage;
	}

	public boolean isFlage() {
		return flage;
	}

	public void setFlage(boolean flage) {
		this.flage = flage;
	}
	
	

}