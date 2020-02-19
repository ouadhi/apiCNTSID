package com.dpworld.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class SortiePhysique {
	private static final long serialVersionUID = 1L;

	private String containerNumber;
	private String blNumber;
	private String internationalVoyageNumber;
	private String escalNumber;
	private String grossNumber;
	private String dpNumber;
	@Temporal(TemporalType.TIME)
	private Date dpDate;
	@Temporal(TemporalType.TIME)
	private Date pulloutDate;
	private String truckLicencePlateNumber;
	@Id
	private int id;
	@Temporal(TemporalType.TIME)
	private Date Ajoute;
	private String articleNumber;
	private String missionTypeDesc;
	private String containerType;

	public SortiePhysique() {
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

	public String getDpNumber() {
		return dpNumber;
	}

	public void setDpNumber(String dpNumber) {
		this.dpNumber = dpNumber;
	}

	public Date getDpDate() {
		return dpDate;
	}

	public void setDpDate(Date dpDate) {
		this.dpDate = dpDate;
	}

	public Date getPulloutDate() {
		return pulloutDate;
	}

	public void setPulloutDate(Date pulloutDate) {
		this.pulloutDate = pulloutDate;
	}

	public String getTruckLicencePlateNumber() {
		return truckLicencePlateNumber;
	}

	public void setTruckLicencePlateNumber(String truckLicencePlateNumber) {
		this.truckLicencePlateNumber = truckLicencePlateNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAjoute() {
		return Ajoute;
	}

	public void setAjoute(Date ajoute) {
		Ajoute = ajoute;
	}

	public String getArticleNumber() {
		return articleNumber;
	}

	public void setArticleNumber(String articleNumber) {
		this.articleNumber = articleNumber;
	}

	public String getMissionTypeDesc() {
		return missionTypeDesc;
	}

	public void setMissionTypeDesc(String missionTypeDesc) {
		this.missionTypeDesc = missionTypeDesc;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
