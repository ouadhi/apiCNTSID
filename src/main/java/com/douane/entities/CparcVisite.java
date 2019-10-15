package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cparcvisite")
public class CparcVisite implements Serializable   {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long  id;  
	private String  numero_vi ; 
	private String num_bl ; 
	private String num_cts ;  
	private Date  date_transfert ;
	public CparcVisite(String numero_vi, String num_bl, String num_cts, Date date_transfert) {
		this.numero_vi = numero_vi;
		this.num_bl = num_bl;
		this.num_cts = num_cts;
		this.date_transfert = date_transfert;
	}
	public CparcVisite() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero_vi() {
		return numero_vi;
	}
	public void setNumero_vi(String numero_vi) {
		this.numero_vi = numero_vi;
	}
	public String getNum_bl() {
		return num_bl;
	}
	public void setNum_bl(String num_bl) {
		this.num_bl = num_bl;
	}
	public String getNum_cts() {
		return num_cts;
	}
	public void setNum_cts(String num_cts) {
		this.num_cts = num_cts;
	}
	public Date getDate_transfert() {
		return date_transfert;
	}
	public void setDate_transfert(Date date_transfert) {
		this.date_transfert = date_transfert;
	}  
	
	
	
	

}
