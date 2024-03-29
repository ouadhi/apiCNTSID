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
@NamedQuery(name="Contrevisite.findAll", query="SELECT c FROM Contrevisite c")
public class Contrevisite implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long   id ; 
	
	@Column(name="flag")
	private boolean  flag  ;
	
	@Column(name="num_bl")
	private String numBl;
	
	@Column(name="date_enr")
	@Temporal(TemporalType.DATE)
	private Date dateEnr;
	
	@Column(name="num_cts")
	private String numCts;

	@Column(name="code_bur")
	private short codeBur;
	
	@Column(name="an_manif")
	@Temporal(TemporalType.DATE)
	private Date anManif;
	
	@Column(name="num_manif")
	private int numManif;
	
	@Column(name="num_ligne")
	private short numLigne;
	
	@Column(name="num_group")
	private short numGroup;
	
	@Column(name="type_controle")
	private String typeControle;
	

	@Column(name="wuser")
	private String user;
	

	

}