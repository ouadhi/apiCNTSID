package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Manifest.findAll", query="SELECT m FROM Manifest m")
public class Manifest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="an_manif")
	private Timestamp an_manif;

	@Column(name="code_bur")
	private short code_bur;

	@Column(name="date_marquage")
	@Temporal(TemporalType.DATE)
	private Date date_marquage;

	private boolean flag;

	@Column(name="num_bl")
	private String num_bl;

	@Column(name="num_cts")
	private String num_cts;

	@Column(name="num_group")
	private short num_group;

	@Column(name="num_ligne")
	private short num_ligne;

	@Column(name="num_manif")
	private int num_manif;

	@Column(name="numero_vi")
	private String numero_Vi;

	@Column(name="tare_cts")
	private short tare_cts;

	

}