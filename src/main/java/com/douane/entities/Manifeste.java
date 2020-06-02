package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.informix.util.dateUtil;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Manifeste.findAll", query="SELECT m FROM Manifeste m")
public class Manifeste implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="an_manif")
	@Temporal(TemporalType.DATE)
	private Date an_manif;

	@Column(name="code_bur")
	private short code_bur;

	@Column(name="date_arrive")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_arrive;

	@Column(name="date_enr")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_enr;

	@Column(name="date_entre")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_entre;

	private String entree;

	@Column(name="lieu_debarq")
	private String lieu_debarq;

	@Column(name="nat_manif")
	private String nat_manif;

	@Column(name="nbre_lig")
	private short nbre_lig;

	@Column(name="num_consig")
	private int num_consig;

	@Column(name="num_magasin")
	private short num_magasin;

	@Column(name="num_manif")
	private int num_manif;

	@Column(name="num_transp")
	private String num_transp;

	@Column(name="poidsb_t")
	private BigDecimal poidsb_t;

	@Column(name="poidsm_t")
	private BigDecimal poidsm_t ; 

	private String transport;

	@Column(name="type_manif")
	private String type_manif;
	
	@Column(name="flag")
	private boolean  flag  ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_markage")
	private Date date_markage;


	

}