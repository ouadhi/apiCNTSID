package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="bae_dpw")
public class BaeDpw implements  Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id ; 
	private String numero_vi ; 
	private String num_cts ; 
	private int code_bur ;  
	private Date an_manif ; 
	private int num_manif ;
	private int num_ligne ; 
	private int num_decl ; 
	private char type_declaration  ;  
	private Date date_bae ;
	private boolean flag  ; 
	
	public BaeDpw(String numero_vi, String num_cts, int code_bur, Date an_manif, int num_manif, int num_ligne,
			int num_decl, char type_declaration, Date date_bae) {
		this.numero_vi = numero_vi;
		this.num_cts = num_cts;
		this.code_bur = code_bur;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.num_ligne = num_ligne;
		this.num_decl = num_decl;
		this.type_declaration = type_declaration;
		this.date_bae = date_bae;
	}
	public BaeDpw() {
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
	public String getNum_cts() {
		return num_cts;
	}
	public void setNum_cts(String num_cts) {
		this.num_cts = num_cts;
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
	public int getNum_ligne() {
		return num_ligne;
	}
	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}
	public int getNum_decl() {
		return num_decl;
	}
	public void setNum_decl(int num_decl) {
		this.num_decl = num_decl;
	}
	public char getType_declaration() {
		return type_declaration;
	}
	public void setType_declaration(char type_declaration) {
		this.type_declaration = type_declaration;
	}
	public Date getDate_bae() {
		return date_bae;
	}
	public void setDate_bae(Date date_bae) {
		this.date_bae = date_bae;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	} 
	
	
	
}
