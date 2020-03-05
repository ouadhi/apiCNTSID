package com.douane.dpworld.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ConteneurParcVisite implements Serializable {

	private static final long serialVersionUID = 1L;

	private String containerNumber;
	private String blNumber;
	private String internationalVoyageNumber;
	private String escalNumber;
	private String grossNumber;
	private String articleNumber;
	private String clearenceNumber;
	private String visitType;
	@Temporal(TemporalType.DATE)
	private Date transferDate;
	private int jobExecId;
	@Id
	private int id;
	@Temporal(TemporalType.TIME)
	private Date ajoute;
	
	public ConteneurParcVisite() {
		// TODO Auto-generated constructor stub
	}

	public String getContainerNumber() {
		return containerNumber;
	}

	public void setContainerNumber(String containerNumber) {
		this.containerNumber = containerNumber;
	}

	public String getBlNumber() {
		return blNumber;
	}

	public void setBlNumber(String blNumber) {
		this.blNumber = blNumber;
	}

	public String getInternationalVoyageNumber() {
		return internationalVoyageNumber;
	}

	public void setInternationalVoyageNumber(String internationalVoyageNumber) {
		this.internationalVoyageNumber = internationalVoyageNumber;
	}

	public String getEscalNumber() {
		return escalNumber;
	}

	public void setEscalNumber(String escalNumber) {
		this.escalNumber = escalNumber;
	}

	public String getGrossNumber() {
		return grossNumber;
	}

	public void setGrossNumber(String grossNumber) {
		this.grossNumber = grossNumber;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getClearenceNumber() {
		return clearenceNumber;
	}

	public void setClearenceNumber(String clearenceNumber) {
		this.clearenceNumber = clearenceNumber;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public int getJobExecId() {
		return jobExecId;
	}

	public void setJobExecId(int jobExecId) {
		this.jobExecId = jobExecId;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAjoute() {
		return ajoute;
	}

	public void setAjoute(Date ajoute) {
		this.ajoute = ajoute;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
