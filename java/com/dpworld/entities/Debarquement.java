package com.dpworld.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Debarquement implements Serializable {

	private static final long serialVersionUID = 1L;

	private String containerNumber;
	private String blNumber;
	private String internationalVoyageNumber;
	private String escalNumber;
	@Temporal(TemporalType.DATE)
	private Date vesselArrivalDate;
	@Temporal(TemporalType.DATE)
	private Date vesselBerthDate;
	@Temporal(TemporalType.DATE)
	private Date dischargeDate;
	private String containerType;
	private String position;
	@Id
	private int id;
	@Temporal(TemporalType.DATE)
	private Date jobExecDate;
	@Temporal(TemporalType.DATE)
	private Date ajoute;

	public Debarquement() {
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

	public Date getVesselArrivalDate() {
		return vesselArrivalDate;
	}

	public void setVesselArrivalDate(Date vesselArrivalDate) {
		this.vesselArrivalDate = vesselArrivalDate;
	}

	public Date getVesselBerthDate() {
		return vesselBerthDate;
	}

	public void setVesselBerthDate(Date vesselBerthDate) {
		this.vesselBerthDate = vesselBerthDate;
	}

	public Date getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(Date dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getJobExecDate() {
		return jobExecDate;
	}

	public void setJobExecDate(Date jobExecDate) {
		this.jobExecDate = jobExecDate;
	}

	public void setAjoute(Date ajoute) {
		this.ajoute = ajoute;
	}

	public Date getAjoute() {
		return ajoute;
	}

	public String getContainerType() {
		return containerType;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Debarquement{" + "containerNumber=" + containerNumber + ", blNumber=" + blNumber
				+ ", internationalVoyageNumber=" + internationalVoyageNumber + ", escalNumber=" + escalNumber
				+ ", vesselArrivalDate=" + vesselArrivalDate + ", vesselBerthDate=" + vesselBerthDate
				+ ", dischargeDate=" + dischargeDate + ", id=" + id + ", jobExecDate=" + jobExecDate + '}';
	}

}
