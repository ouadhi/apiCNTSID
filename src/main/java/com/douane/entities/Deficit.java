package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deficit")
public class Deficit implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ; 
	private String numero_vi ; 
	private Date date_accostage ;  
	private int code_bur ;  
	private Date an_manif  ; 
	private int  num_manif ; 
	private int  nb_tcs ;
	private boolean  flag ; 
	
	public Deficit() {
		
	}

	public Deficit(String numero_vi, Date date_accostage, int code_bur, Date an_manif, int num_manif, int nb_tcs , boolean  flag) {
		this.numero_vi = numero_vi;
		this.date_accostage = date_accostage;
		this.code_bur = code_bur;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.nb_tcs = nb_tcs;
		this.flag  = flag  ;  
		
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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

	public Date getDate_accostage() {
		return date_accostage;
	}

	public void setDate_accostage(Date date_accostage) {
		this.date_accostage = date_accostage;
	}

	public int getCode_bur() {
		return code_bur;
	}

	public void setCode_bur(int code_bur) {
		this.code_bur = code_bur;
	}

	public Date getAn_manif() {
		return an_manif;
	}

	public void setAn_manif(Date an_manif) {
		this.an_manif = an_manif;
	}

	public int getNum_manif() {
		return num_manif;
	}

	public void setNum_manif(int num_manif) {
		this.num_manif = num_manif;
	}

	public int getNb_tcs() {
		return nb_tcs;
	}

	public void setNb_tcs(int nb_tcs) {
		this.nb_tcs = nb_tcs;
	} 
	
	
	
	
	
	
}
