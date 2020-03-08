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
@Table(name="ConteneurParcVisite")
public class ConteneurParcVisite implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	
	@Column(name="num_cts")
	private String containerNumber;
	
	@Column(name="num_bl")
	private String blNumber;
	
	@Column(name="numero_vi")
	private String internationalVoyageNumber;
	
	@Column(name="num_escal")
	private String escalNumber;
	
	@Column(name="num_group")
	private String grossNumber;
	
	@Column(name="num_article")
	private String articleNumber;
	
	@Column(name="clearencenumber")
	private String clearenceNumber;
	
	@Column(name="type_visite")
	private String visitType;
	
	@Column(name="date_tarnsfert")
	@Temporal(TemporalType.DATE)
	private Date transferDate;
	
	private int jobExecId;
	
	@Temporal(TemporalType.TIME)
	private Date ajoute;
	
	
}
