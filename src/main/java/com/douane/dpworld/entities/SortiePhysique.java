package com.douane.dpworld.entities;

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
@Table(name="SortiePhysique")
public class SortiePhysique {
	@Id
	private int id;
	
	@Column(name="num_cts")
	private String containerNumber;
	
	@Column(name="num_bl")
	private String blNumber;
	
	@Column(name="numero_vi")
	private String internationalVoyageNumber;
	
	@Column(name="numero_escale")
	private String escalNumber;
	
	@Column(name="num_gors")
	private String grossNumber;
	
	@Column(name="numero_dp")
	private String dpNumber;
	
	@Temporal(TemporalType.TIME)
	@Column(name="date_dp")
	private Date dpDate;
	
	@Temporal(TemporalType.TIME)
	@Column(name="date_sortie")
	private Date pulloutDate;
	
	@Column(name="numero_camion")
	private String truckLicencePlateNumber;
	
	@Column(name="num_article")
	private String articleNumber;
	
	@Column(name="desc_mission")
	private String missionTypeDesc;
	
	@Column(name="type_cts")
	private String containerType;
	
	@Temporal(TemporalType.TIME)
	private Date Ajoute;

	

}
