package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ligne_manif")
public class LigneManif implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue 
	private Long  id  ; 
	private Date an_manif; 
	private int num_manif ; 
	private int code_bur ; 
	private int  num_ligne  ; 
	private int num_group ;  
	private Date date_manif ;  
	private Date dat_date; 
	private Date an_oper ; 
	private int code_oper ;  
	private Date date_rectif ;
	private Date date_sit ; 
	private String num_reference ; 
	private String design_march ; 
	private String lieu_chgt ;  
	private int nbr_colism ; 
	private int nbr_colise ;  
	private int nbr_coliss ;  
	private int nbr_colisd ; 
	private float poidsb_m ; 
	private float poidsb_r ; 
	private int num_quitt ; 
	private int  num_extrait ; 
	private Date Date_transf ;  
	private int num_situation ; 
	private String motif  ;  
	private int num_magasin ;  
	private String nature  ; 
	private String type_manif ;
	public LigneManif(Long id, Date an_manif, int num_manif, int code_bur, int num_ligne, int num_group,
			Date date_manif, Date dat_date, Date an_oper, int code_oper, Date date_rectif, Date date_sit,
			String num_reference, String design_march, String lieu_chgt, int nbr_colism, int nbr_colise, int nbr_coliss,
			int nbr_colisd, float poidsb_m, float poidsb_r, int num_quitt, int num_extrait, Date date_transf,
			int num_situation, String motif, int num_magasin, String nature, String type_manif) {
		this.id = id;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.code_bur = code_bur;
		this.num_ligne = num_ligne;
		this.num_group = num_group;
		this.date_manif = date_manif;
		this.dat_date = dat_date;
		this.an_oper = an_oper;
		this.code_oper = code_oper;
		this.date_rectif = date_rectif;
		this.date_sit = date_sit;
		this.num_reference = num_reference;
		this.design_march = design_march;
		this.lieu_chgt = lieu_chgt;
		this.nbr_colism = nbr_colism;
		this.nbr_colise = nbr_colise;
		this.nbr_coliss = nbr_coliss;
		this.nbr_colisd = nbr_colisd;
		this.poidsb_m = poidsb_m;
		this.poidsb_r = poidsb_r;
		this.num_quitt = num_quitt;
		this.num_extrait = num_extrait;
		Date_transf = date_transf;
		this.num_situation = num_situation;
		this.motif = motif;
		this.num_magasin = num_magasin;
		this.nature = nature;
		this.type_manif = type_manif;
	}
	public LigneManif() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getCode_bur() {
		return code_bur;
	}
	public void setCode_bur(int code_bur) {
		this.code_bur = code_bur;
	}
	public int getNum_ligne() {
		return num_ligne;
	}
	public void setNum_ligne(int num_ligne) {
		this.num_ligne = num_ligne;
	}
	public int getNum_group() {
		return num_group;
	}
	public void setNum_group(int num_group) {
		this.num_group = num_group;
	}
	public Date getDate_manif() {
		return date_manif;
	}
	public void setDate_manif(Date date_manif) {
		this.date_manif = date_manif;
	}
	public Date getDat_date() {
		return dat_date;
	}
	public void setDat_date(Date dat_date) {
		this.dat_date = dat_date;
	}
	public Date getAn_oper() {
		return an_oper;
	}
	public void setAn_oper(Date an_oper) {
		this.an_oper = an_oper;
	}
	public int getCode_oper() {
		return code_oper;
	}
	public void setCode_oper(int code_oper) {
		this.code_oper = code_oper;
	}
	public Date getDate_rectif() {
		return date_rectif;
	}
	public void setDate_rectif(Date date_rectif) {
		this.date_rectif = date_rectif;
	}
	public Date getDate_sit() {
		return date_sit;
	}
	public void setDate_sit(Date date_sit) {
		this.date_sit = date_sit;
	}
	public String getNum_reference() {
		return num_reference;
	}
	public void setNum_reference(String num_reference) {
		this.num_reference = num_reference;
	}
	public String getDesign_march() {
		return design_march;
	}
	public void setDesign_march(String design_march) {
		this.design_march = design_march;
	}
	public String getLieu_chgt() {
		return lieu_chgt;
	}
	public void setLieu_chgt(String lieu_chgt) {
		this.lieu_chgt = lieu_chgt;
	}
	public int getNbr_colism() {
		return nbr_colism;
	}
	public void setNbr_colism(int nbr_colism) {
		this.nbr_colism = nbr_colism;
	}
	public int getNbr_colise() {
		return nbr_colise;
	}
	public void setNbr_colise(int nbr_colise) {
		this.nbr_colise = nbr_colise;
	}
	public int getNbr_coliss() {
		return nbr_coliss;
	}
	public void setNbr_coliss(int nbr_coliss) {
		this.nbr_coliss = nbr_coliss;
	}
	public int getNbr_colisd() {
		return nbr_colisd;
	}
	public void setNbr_colisd(int nbr_colisd) {
		this.nbr_colisd = nbr_colisd;
	}
	public float getPoidsb_m() {
		return poidsb_m;
	}
	public void setPoidsb_m(float poidsb_m) {
		this.poidsb_m = poidsb_m;
	}
	public float getPoidsb_r() {
		return poidsb_r;
	}
	public void setPoidsb_r(float poidsb_r) {
		this.poidsb_r = poidsb_r;
	}
	public int getNum_quitt() {
		return num_quitt;
	}
	public void setNum_quitt(int num_quitt) {
		this.num_quitt = num_quitt;
	}
	public int getNum_extrait() {
		return num_extrait;
	}
	public void setNum_extrait(int num_extrait) {
		this.num_extrait = num_extrait;
	}
	public Date getDate_transf() {
		return Date_transf;
	}
	public void setDate_transf(Date date_transf) {
		Date_transf = date_transf;
	}
	public int getNum_situation() {
		return num_situation;
	}
	public void setNum_situation(int num_situation) {
		this.num_situation = num_situation;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public int getNum_magasin() {
		return num_magasin;
	}
	public void setNum_magasin(int num_magasin) {
		this.num_magasin = num_magasin;
	}
	public String getNature() {
		return nature;
	}
	public void setNature(String nature) {
		this.nature = nature;
	}
	public String getType_manif() {
		return type_manif;
	}
	public void setType_manif(String type_manif) {
		this.type_manif = type_manif;
	} 
	
	
	
	
	
	
	

}
