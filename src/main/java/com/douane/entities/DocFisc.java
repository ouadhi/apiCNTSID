package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doc_fisc")
public class DocFisc implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id ; 
	private int code_bur  ;  
	private Date an_decl ; 
	private int num_decl ;
	private int doccod ; 
	private Date date_etab  ;
	
	public DocFisc(int code_bur, Date an_decl, int num_decl, int doccod, Date date_etab) {
		this.code_bur = code_bur;
		this.an_decl = an_decl;
		this.num_decl = num_decl;
		this.doccod = doccod;
		this.date_etab = date_etab;
	}
	
	public DocFisc() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCode_bur() {
		return code_bur;
	}

	public void setCode_bur(int code_bur) {
		this.code_bur = code_bur;
	}

	public Date getAn_decl() {
		return an_decl;
	}

	public void setAn_decl(Date an_decl) {
		this.an_decl = an_decl;
	}

	public int getNum_decl() {
		return num_decl;
	}

	public void setNum_decl(int num_decl) {
		this.num_decl = num_decl;
	}

	public int getDoccod() {
		return doccod;
	}

	public void setDoccod(int doccod) {
		this.doccod = doccod;
	}

	public Date getDate_etab() {
		return date_etab;
	}

	public void setDate_etab(Date date_etab) {
		this.date_etab = date_etab;
	} 
	
	
	

}
