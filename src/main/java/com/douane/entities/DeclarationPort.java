package com.douane.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="declaration_port")
public class DeclarationPort implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id  ;
	private int code_bur ;  
	private Date an_decl  ;  
	private int num_decl ;  
	private Date date_cotation ; 
	private int mat_agt ; 
	private int code_reg ; 
	private Date an_agrt ; 
	private int num_agrt ;  
	private int num_rep  ;  
	private Date an_oper ;
	private int code_oper ; 
	private String code_eng ; 
	private int dec_code_bur ; 
	private Date dec_an_decl ; 
	private int dec_num_decl ; 
	private int num_cred ;  
	private int code_bur_manif ; 
	private char type_manif ; 
	private Date an_manif ; 
	private int num_manif  ; 
	private int num_ligne ; 
	private int num_group ;  
	private String pay_prov ;  
	private int bur_code_bur  ;  
	private int bur2_code_bur  ;  
	private char mode_paiement ;  
	private char mode_finance  ; 
	private String nom_frs ; 
	private String adr_frs ; 
	private String pays_frs ; 
	private String nbq_dom  ; 
	private String agence_dom ; 
	private int num_dom ; 
	private double poids_decl ; 
	private int clois_decl ;  
	private double mon_decl ;  
	private char circuit ; 
	private char etat_rcv ;  
	private Date date_bae ;  
	private char rel_av  ;  
	private char monnaie_ptfn  ;  
	private double mt_ptfn  ;  
	private double lc_ptfn ;  
	private double mt_ptfn2 ; 
	private String  monnaie_ass ; 
	private double mt_ass ;  
	private double lc_ass ;  
	private double mt_ass2 ;  
	private String monnaie_fret  ; 
	private double mt_fret ;  
	private double lc_fret ; 
	private double mt_fret2 ; 
	private String monnaie_frais ;  
	private double mt_frais  ;  
	private double lc_frais  ;  
	private double mt_frais2 ; 
	private String nat_contrat ; 
	private String type_contrat ;
	private String type_operat  ;  
	private String etat_dcl ; 
	private String mod_tint ; 
	private String type_dcl ; 
	private String type_ded ;  
	private String ident_tint ; 
	private int nbr_art  ;
	private double plus_value; 
	private double coeff_ajust ; 
	private double  mt_coef  ; 
	private int cpt_tint ; 
	private String  rec_dcl ; 
	private String dossier_dcl ; 
	private Date  date_verif ; 
	private String res_verif ; 
	private String rec_verif ; 
	private String res_visit ; 
	private String rec_visit ; 
	private int bur_depart ; 
	private int bur_arrive ; 
	private int at_et ;  
	private double tx_susp ; 
	private double mt_caution ; 
	private int duree_at  ; 
	private String lieu_at  ; 
	private int valider ;  
	private double val_douane ; 
	private double kg_douane ; 
	private double poidsn_dcl ; 
	private String adr_rangee ; 
	private double lavaleur ; 
	private int articles ; 
	private Date date_inspect ; 
	private Date date_primo ; 
	private int passage ; 
	private int revue  ;
	private boolean  flag   ;
	private Date date_mark  ; 
	
	public DeclarationPort(Long id, int code_bur, Date an_decl, int num_decl, Date date_cotation, int mat_agt,
			int code_reg, Date an_agrt, int num_agrt, int num_rep, Date an_oper, int code_oper, String code_eng,
			int dec_code_bur, Date dec_an_decl, int dec_num_decl, int num_cred, int code_bur_manif, char type_manif,
			Date an_manif, int num_manif, int num_ligne, int num_group, String pay_prov, int bur_code_bur,
			int bur2_code_bur, char mode_paiement, char mode_finance, String nom_frs, String adr_frs, String pays_frs,
			String nbq_dom, String agence_dom, int num_dom, double poids_decl, int clois_decl, double mon_decl,
			char circuit, char etat_rcv, Date date_bae, char rel_av, char monnaie_ptfn, double mt_ptfn,
			double lc_ptfn, double mt_ptfn2, String monnaie_ass, double mt_ass, double lc_ass, double mt_ass2,
			String monnaie_fret, double mt_fret, double lc_fret, double mt_fret2, String monnaie_frais,
			double mt_frais, double lc_frais, double mt_frais2, String nat_contrat, String type_contrat,
			String type_operat, String etat_dcl, String mod_tint, String type_dcl, String type_ded, String ident_tint,
			int nbr_art, double plus_value, double coeff_ajust, double mt_coef, int cpt_tint, String rec_dcl,
			String dossier_dcl, Date date_verif, String res_verif, String rec_verif, String res_visit, String rec_visit,
			int bur_depart, int bur_arrive, int at_et, double tx_susp, double mt_caution, int duree_at,
			String lieu_at, int valider, double val_douane, double kg_douane, double poidsn_dcl, String adr_rangee,
			double lavaleur, int articles, Date date_inspect, Date date_primo, int passage, int revue) {
		this.id = id;
		this.code_bur = code_bur;
		this.an_decl = an_decl;
		this.num_decl = num_decl;
		this.date_cotation = date_cotation;
		this.mat_agt = mat_agt;
		this.code_reg = code_reg;
		this.an_agrt = an_agrt;
		this.num_agrt = num_agrt;
		this.num_rep = num_rep;
		this.an_oper = an_oper;
		this.code_oper = code_oper;
		this.code_eng = code_eng;
		this.dec_code_bur = dec_code_bur;
		this.dec_an_decl = dec_an_decl;
		this.dec_num_decl = dec_num_decl;
		this.num_cred = num_cred;
		this.code_bur_manif = code_bur_manif;
		this.type_manif = type_manif;
		this.an_manif = an_manif;
		this.num_manif = num_manif;
		this.num_ligne = num_ligne;
		this.num_group = num_group;
		this.pay_prov = pay_prov;
		this.bur_code_bur = bur_code_bur;
		this.bur2_code_bur = bur2_code_bur;
		this.mode_paiement = mode_paiement;
		this.mode_finance = mode_finance;
		this.nom_frs = nom_frs;
		this.adr_frs = adr_frs;
		this.pays_frs = pays_frs;
		this.nbq_dom = nbq_dom;
		this.agence_dom = agence_dom;
		this.num_dom = num_dom;
		this.poids_decl = poids_decl;
		this.clois_decl = clois_decl;
		this.mon_decl = mon_decl;
		this.circuit = circuit;
		this.etat_rcv = etat_rcv;
		this.date_bae = date_bae;
		this.rel_av = rel_av;
		this.monnaie_ptfn = monnaie_ptfn;
		this.mt_ptfn = mt_ptfn;
		this.lc_ptfn = lc_ptfn;
		this.mt_ptfn2 = mt_ptfn2;
		this.monnaie_ass = monnaie_ass;
		this.mt_ass = mt_ass;
		this.lc_ass = lc_ass;
		this.mt_ass2 = mt_ass2;
		this.monnaie_fret = monnaie_fret;
		this.mt_fret = mt_fret;
		this.lc_fret = lc_fret;
		this.mt_fret2 = mt_fret2;
		this.monnaie_frais = monnaie_frais;
		this.mt_frais = mt_frais;
		this.lc_frais = lc_frais;
		this.mt_frais2 = mt_frais2;
		this.nat_contrat = nat_contrat;
		this.type_contrat = type_contrat;
		this.type_operat = type_operat;
		this.etat_dcl = etat_dcl;
		this.mod_tint = mod_tint;
		this.type_dcl = type_dcl;
		this.type_ded = type_ded;
		this.ident_tint = ident_tint;
		this.nbr_art = nbr_art;
		this.plus_value = plus_value;
		this.coeff_ajust = coeff_ajust;
		this.mt_coef = mt_coef;
		this.cpt_tint = cpt_tint;
		this.rec_dcl = rec_dcl;
		this.dossier_dcl = dossier_dcl;
		this.date_verif = date_verif;
		this.res_verif = res_verif;
		this.rec_verif = rec_verif;
		this.res_visit = res_visit;
		this.rec_visit = rec_visit;
		this.bur_depart = bur_depart;
		this.bur_arrive = bur_arrive;
		this.at_et = at_et;
		this.tx_susp = tx_susp;
		this.mt_caution = mt_caution;
		this.duree_at = duree_at;
		this.lieu_at = lieu_at;
		this.valider = valider;
		this.val_douane = val_douane;
		this.kg_douane = kg_douane;
		this.poidsn_dcl = poidsn_dcl;
		this.adr_rangee = adr_rangee;
		this.lavaleur = lavaleur;
		this.articles = articles;
		this.date_inspect = date_inspect;
		this.date_primo = date_primo;
		this.passage = passage;
		this.revue = revue;
	}

	public DeclarationPort() {
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

	public Date getDate_cotation() {
		return date_cotation;
	}

	public void setDate_cotation(Date date_cotation) {
		this.date_cotation = date_cotation;
	}

	public int getMat_agt() {
		return mat_agt;
	}

	public void setMat_agt(int mat_agt) {
		this.mat_agt = mat_agt;
	}

	public int getCode_reg() {
		return code_reg;
	}

	public void setCode_reg(int code_reg) {
		this.code_reg = code_reg;
	}

	public Date getAn_agrt() {
		return an_agrt;
	}

	public void setAn_agrt(Date an_agrt) {
		this.an_agrt = an_agrt;
	}

	public int getNum_agrt() {
		return num_agrt;
	}

	public void setNum_agrt(int num_agrt) {
		this.num_agrt = num_agrt;
	}

	public int getNum_rep() {
		return num_rep;
	}

	public void setNum_rep(int num_rep) {
		this.num_rep = num_rep;
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

	public String getCode_eng() {
		return code_eng;
	}

	public void setCode_eng(String code_eng) {
		this.code_eng = code_eng;
	}

	public int getDec_code_bur() {
		return dec_code_bur;
	}

	public void setDec_code_bur(int dec_code_bur) {
		this.dec_code_bur = dec_code_bur;
	}

	public Date getDec_an_decl() {
		return dec_an_decl;
	}

	public void setDec_an_decl(Date dec_an_decl) {
		this.dec_an_decl = dec_an_decl;
	}

	public int getDec_num_decl() {
		return dec_num_decl;
	}

	public void setDec_num_decl(int dec_num_decl) {
		this.dec_num_decl = dec_num_decl;
	}

	public int getNum_cred() {
		return num_cred;
	}

	public void setNum_cred(int num_cred) {
		this.num_cred = num_cred;
	}

	public int getCode_bur_manif() {
		return code_bur_manif;
	}

	public void setCode_bur_manif(int code_bur_manif) {
		this.code_bur_manif = code_bur_manif;
	}

	public char getType_manif() {
		return type_manif;
	}

	public void setType_manif(char type_manif) {
		this.type_manif = type_manif;
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

	public int getNum_group() {
		return num_group;
	}

	public void setNum_group(int num_group) {
		this.num_group = num_group;
	}

	public String getPay_prov() {
		return pay_prov;
	}

	public void setPay_prov(String pay_prov) {
		this.pay_prov = pay_prov;
	}

	public int getBur_code_bur() {
		return bur_code_bur;
	}

	public void setBur_code_bur(int bur_code_bur) {
		this.bur_code_bur = bur_code_bur;
	}

	public int getBur2_code_bur() {
		return bur2_code_bur;
	}

	public void setBur2_code_bur(int bur2_code_bur) {
		this.bur2_code_bur = bur2_code_bur;
	}

	public char getMode_paiement() {
		return mode_paiement;
	}

	public void setMode_paiement(char mode_paiement) {
		this.mode_paiement = mode_paiement;
	}

	public char getMode_finance() {
		return mode_finance;
	}

	public void setMode_finance(char mode_finance) {
		this.mode_finance = mode_finance;
	}

	public String getNom_frs() {
		return nom_frs;
	}

	public void setNom_frs(String nom_frs) {
		this.nom_frs = nom_frs;
	}

	public String getAdr_frs() {
		return adr_frs;
	}

	public void setAdr_frs(String adr_frs) {
		this.adr_frs = adr_frs;
	}

	public String getPays_frs() {
		return pays_frs;
	}

	public void setPays_frs(String pays_frs) {
		this.pays_frs = pays_frs;
	}

	public String getNbq_dom() {
		return nbq_dom;
	}

	public void setNbq_dom(String nbq_dom) {
		this.nbq_dom = nbq_dom;
	}

	public String getAgence_dom() {
		return agence_dom;
	}

	public void setAgence_dom(String agence_dom) {
		this.agence_dom = agence_dom;
	}

	public int getNum_dom() {
		return num_dom;
	}

	public void setNum_dom(int num_dom) {
		this.num_dom = num_dom;
	}

	public double getPoids_decl() {
		return poids_decl;
	}

	public void setPoids_decl(double poids_decl) {
		this.poids_decl = poids_decl;
	}

	public int getClois_decl() {
		return clois_decl;
	}

	public void setClois_decl(int clois_decl) {
		this.clois_decl = clois_decl;
	}

	public double getMon_decl() {
		return mon_decl;
	}

	public void setMon_decl(double mon_decl) {
		this.mon_decl = mon_decl;
	}

	public char getCircuit() {
		return circuit;
	}

	public void setCircuit(char circuit) {
		this.circuit = circuit;
	}

	public char getEtat_rcv() {
		return etat_rcv;
	}

	public void setEtat_rcv(char etat_rcv) {
		this.etat_rcv = etat_rcv;
	}

	public Date getDate_bae() {
		return date_bae;
	}

	public void setDate_bae(Date date_bae) {
		this.date_bae = date_bae;
	}

	public char getRel_av() {
		return rel_av;
	}

	public void setRel_av(char rel_av) {
		this.rel_av = rel_av;
	}

	public char getMonnaie_ptfn() {
		return monnaie_ptfn;
	}

	public void setMonnaie_ptfn(char monnaie_ptfn) {
		this.monnaie_ptfn = monnaie_ptfn;
	}

	public double getMt_ptfn() {
		return mt_ptfn;
	}

	public void setMt_ptfn(double mt_ptfn) {
		this.mt_ptfn = mt_ptfn;
	}

	public double getLc_ptfn() {
		return lc_ptfn;
	}

	public void setLc_ptfn(double lc_ptfn) {
		this.lc_ptfn = lc_ptfn;
	}

	public double getMt_ptfn2() {
		return mt_ptfn2;
	}

	public void setMt_ptfn2(double mt_ptfn2) {
		this.mt_ptfn2 = mt_ptfn2;
	}

	public String getMonnaie_ass() {
		return monnaie_ass;
	}

	public void setMonnaie_ass(String monnaie_ass) {
		this.monnaie_ass = monnaie_ass;
	}

	public double getMt_ass() {
		return mt_ass;
	}

	public void setMt_ass(double mt_ass) {
		this.mt_ass = mt_ass;
	}

	public double getLc_ass() {
		return lc_ass;
	}

	public void setLc_ass(double lc_ass) {
		this.lc_ass = lc_ass;
	}

	public double getMt_ass2() {
		return mt_ass2;
	}

	public void setMt_ass2(double mt_ass2) {
		this.mt_ass2 = mt_ass2;
	}

	public String getMonnaie_fret() {
		return monnaie_fret;
	}

	public void setMonnaie_fret(String monnaie_fret) {
		this.monnaie_fret = monnaie_fret;
	}

	public double getMt_fret() {
		return mt_fret;
	}

	public void setMt_fret(double mt_fret) {
		this.mt_fret = mt_fret;
	}

	public double getLc_fret() {
		return lc_fret;
	}

	public void setLc_fret(double lc_fret) {
		this.lc_fret = lc_fret;
	}

	public double getMt_fret2() {
		return mt_fret2;
	}

	public void setMt_fret2(double mt_fret2) {
		this.mt_fret2 = mt_fret2;
	}

	public String getMonnaie_frais() {
		return monnaie_frais;
	}

	public void setMonnaie_frais(String monnaie_frais) {
		this.monnaie_frais = monnaie_frais;
	}

	public double getMt_frais() {
		return mt_frais;
	}

	public void setMt_frais(double mt_frais) {
		this.mt_frais = mt_frais;
	}

	public double getLc_frais() {
		return lc_frais;
	}

	public void setLc_frais(double lc_frais) {
		this.lc_frais = lc_frais;
	}

	public double getMt_frais2() {
		return mt_frais2;
	}

	public void setMt_frais2(double mt_frais2) {
		this.mt_frais2 = mt_frais2;
	}

	public String getNat_contrat() {
		return nat_contrat;
	}

	public void setNat_contrat(String nat_contrat) {
		this.nat_contrat = nat_contrat;
	}

	public String getType_contrat() {
		return type_contrat;
	}

	public void setType_contrat(String type_contrat) {
		this.type_contrat = type_contrat;
	}

	public String getType_operat() {
		return type_operat;
	}

	public void setType_operat(String type_operat) {
		this.type_operat = type_operat;
	}

	public String getEtat_dcl() {
		return etat_dcl;
	}

	public void setEtat_dcl(String etat_dcl) {
		this.etat_dcl = etat_dcl;
	}

	public String getMod_tint() {
		return mod_tint;
	}

	public void setMod_tint(String mod_tint) {
		this.mod_tint = mod_tint;
	}

	public String getType_dcl() {
		return type_dcl;
	}

	public void setType_dcl(String type_dcl) {
		this.type_dcl = type_dcl;
	}

	public String getType_ded() {
		return type_ded;
	}

	public void setType_ded(String type_ded) {
		this.type_ded = type_ded;
	}

	public String getIdent_tint() {
		return ident_tint;
	}

	public void setIdent_tint(String ident_tint) {
		this.ident_tint = ident_tint;
	}

	public int getNbr_art() {
		return nbr_art;
	}

	public void setNbr_art(int nbr_art) {
		this.nbr_art = nbr_art;
	}

	public double getPlus_value() {
		return plus_value;
	}

	public void setPlus_value(double plus_value) {
		this.plus_value = plus_value;
	}

	public double getCoeff_ajust() {
		return coeff_ajust;
	}

	public void setCoeff_ajust(double coeff_ajust) {
		this.coeff_ajust = coeff_ajust;
	}

	public double getMt_coef() {
		return mt_coef;
	}

	public void setMt_coef(double mt_coef) {
		this.mt_coef = mt_coef;
	}

	public int getCpt_tint() {
		return cpt_tint;
	}

	public void setCpt_tint(int cpt_tint) {
		this.cpt_tint = cpt_tint;
	}

	public String getRec_dcl() {
		return rec_dcl;
	}

	public void setRec_dcl(String rec_dcl) {
		this.rec_dcl = rec_dcl;
	}

	public String getDossier_dcl() {
		return dossier_dcl;
	}

	public void setDossier_dcl(String dossier_dcl) {
		this.dossier_dcl = dossier_dcl;
	}

	public Date getDate_verif() {
		return date_verif;
	}

	public void setDate_verif(Date date_verif) {
		this.date_verif = date_verif;
	}

	public String getRes_verif() {
		return res_verif;
	}

	public void setRes_verif(String res_verif) {
		this.res_verif = res_verif;
	}

	public String getRec_verif() {
		return rec_verif;
	}

	public void setRec_verif(String rec_verif) {
		this.rec_verif = rec_verif;
	}

	public String getRes_visit() {
		return res_visit;
	}

	public void setRes_visit(String res_visit) {
		this.res_visit = res_visit;
	}

	public String getRec_visit() {
		return rec_visit;
	}

	public void setRec_visit(String rec_visit) {
		this.rec_visit = rec_visit;
	}

	public int getBur_depart() {
		return bur_depart;
	}

	public void setBur_depart(int bur_depart) {
		this.bur_depart = bur_depart;
	}

	public int getBur_arrive() {
		return bur_arrive;
	}

	public void setBur_arrive(int bur_arrive) {
		this.bur_arrive = bur_arrive;
	}

	public int getAt_et() {
		return at_et;
	}

	public void setAt_et(int at_et) {
		this.at_et = at_et;
	}

	public double getTx_susp() {
		return tx_susp;
	}

	public void setTx_susp(double tx_susp) {
		this.tx_susp = tx_susp;
	}

	public double getMt_caution() {
		return mt_caution;
	}

	public void setMt_caution(double mt_caution) {
		this.mt_caution = mt_caution;
	}

	public int getDuree_at() {
		return duree_at;
	}

	public void setDuree_at(int duree_at) {
		this.duree_at = duree_at;
	}

	public String getLieu_at() {
		return lieu_at;
	}

	public void setLieu_at(String lieu_at) {
		this.lieu_at = lieu_at;
	}

	public int getValider() {
		return valider;
	}

	public void setValider(int valider) {
		this.valider = valider;
	}

	public double getVal_douane() {
		return val_douane;
	}

	public void setVal_douane(double val_douane) {
		this.val_douane = val_douane;
	}

	public double getKg_douane() {
		return kg_douane;
	}

	public void setKg_douane(double kg_douane) {
		this.kg_douane = kg_douane;
	}

	public double getPoidsn_dcl() {
		return poidsn_dcl;
	}

	public void setPoidsn_dcl(double poidsn_dcl) {
		this.poidsn_dcl = poidsn_dcl;
	}

	public String getAdr_rangee() {
		return adr_rangee;
	}

	public void setAdr_rangee(String adr_rangee) {
		this.adr_rangee = adr_rangee;
	}

	public double getLavaleur() {
		return lavaleur;
	}

	public void setLavaleur(double lavaleur) {
		this.lavaleur = lavaleur;
	}

	public int getArticles() {
		return articles;
	}

	public void setArticles(int articles) {
		this.articles = articles;
	}

	public Date getDate_inspect() {
		return date_inspect;
	}

	public void setDate_inspect(Date date_inspect) {
		this.date_inspect = date_inspect;
	}

	public Date getDate_primo() {
		return date_primo;
	}

	public void setDate_primo(Date date_primo) {
		this.date_primo = date_primo;
	}

	public int getPassage() {
		return passage;
	}

	public void setPassage(int passage) {
		this.passage = passage;
	}

	public int getRevue() {
		return revue;
	}

	public void setRevue(int revue) {
		this.revue = revue;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Date getDate_mark() {
		return date_mark;
	}

	public void setDate_mark(Date date_mark) {
		this.date_mark = date_mark;
	}  
	
	 
	
	
	
	
	
	
	
	

}
