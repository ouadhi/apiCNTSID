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
	
	@Column(name="num_reference")
	private String numReference;
	
	@Column(name="date_enr")
	private Timestamp dateEnr;
	
	@Column(name="num_cts")
	private String numCts;

	@Column(name="code_bur")
	private short codeBur;
	
	@Column(name="an_manif")
	private Timestamp anManif;
	
	@Column(name="num_manif")
	private int numManif;
	
	@Column(name="num_ligne")
	private short numLigne;
	
	@Column(name="num_group")
	private short numGroup;
	
	@Column(name="type_controle")
	private String typeControle;
	
	@Column(name="date_ajout")
	private Timestamp dateAjout;

	@Column(name="wuser")
	private String user;
	

	

}