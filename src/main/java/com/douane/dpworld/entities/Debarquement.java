package com.douane.dpworld.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="debarquement")
public class Debarquement implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="num_cts")
	private String containerNumber;
	
	@Column(name="num_bl")
	private String blNumber;
	
	@Column(name="numero_Vi")
	private String internationalVoyageNumber;
	
	@Column(name="numero_escale")
	private String escalNumber;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_arrivee")
	private Date vesselArrivalDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_accostage")
	private Date vesselBerthDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_debarquement")
	private Date dischargeDate;
	
	@Column(name="containerType")
	private String containerType;
	
	@Column(name="position")
	private String position;
	
	@Id
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date jobExecDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ajoute;

	

}
