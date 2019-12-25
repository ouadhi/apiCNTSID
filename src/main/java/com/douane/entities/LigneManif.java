package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the ligne_manif database table.
 * 
 */
@Entity
@Table(name="ligne_manif")
@NamedQuery(name="LigneManif.findAll", query="SELECT l FROM LigneManif l")
public class LigneManif implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ; 

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="an_oper")
	private Timestamp anOper;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="code_oper")
	private int codeOper;

	@Column(name="dat_date")
	private Timestamp datDate;

	@Column(name="date_manif")
	private Timestamp dateManif;

	@Column(name="date_rectif")
	private Timestamp dateRectif;

	@Column(name="date_sit")
	private Timestamp dateSit;

	@Column(name="date_transf")
	private Timestamp dateTransf;

	@Column(name="design_march")
	private String designMarch;

	@Column(name="etat_lign")
	private String etatLign;

	@Column(name="lieu_chgt")
	private String lieuChgt;

	private String motif;

	private String nature;

	@Column(name="nbr_colisd")
	private int nbrColisd;

	@Column(name="nbr_colise")
	private int nbrColise;

	@Column(name="nbr_colism")
	private int nbrColism;

	@Column(name="nbr_colisr")
	private int nbrColisr;

	@Column(name="nbr_coliss")
	private int nbrColiss;

	@Column(name="num_extrait")
	private int numExtrait;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_magasin")
	private short numMagasin;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="num_quitt")
	private int numQuitt;

	@Column(name="num_reference")
	private String numReference;

	@Column(name="num_situation")
	private int numSituation;

	@Column(name="poidsb_m")
	private BigDecimal poidsbM;

	@Column(name="poidsb_r")
	private BigDecimal poidsbR;

	@Column(name="poidsn_m")
	private BigDecimal poidsnM;

	@Column(name="poidsn_r")
	private BigDecimal poidsnR;

	@Column(name="type_manif")
	private String typeManif;
	
	private boolean flag ;  
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date dateMarkage ; 

	public LigneManif() {
	}

	public Timestamp getAnManif() {
		return this.anManif;
	}

	public void setAnManif(Timestamp anManif) {
		this.anManif = anManif;
	}

	public Timestamp getAnOper() {
		return this.anOper;
	}

	public void setAnOper(Timestamp anOper) {
		this.anOper = anOper;
	}

	public short getCodeBur() {
		return this.codeBur;
	}

	public void setCodeBur(short codeBur) {
		this.codeBur = codeBur;
	}

	public int getCodeOper() {
		return this.codeOper;
	}

	public void setCodeOper(int codeOper) {
		this.codeOper = codeOper;
	}

	public Timestamp getDatDate() {
		return this.datDate;
	}

	public void setDatDate(Timestamp datDate) {
		this.datDate = datDate;
	}

	public Timestamp getDateManif() {
		return this.dateManif;
	}

	public void setDateManif(Timestamp dateManif) {
		this.dateManif = dateManif;
	}

	public Timestamp getDateRectif() {
		return this.dateRectif;
	}

	public void setDateRectif(Timestamp dateRectif) {
		this.dateRectif = dateRectif;
	}

	public Timestamp getDateSit() {
		return this.dateSit;
	}

	public void setDateSit(Timestamp dateSit) {
		this.dateSit = dateSit;
	}

	public Timestamp getDateTransf() {
		return this.dateTransf;
	}

	public void setDateTransf(Timestamp dateTransf) {
		this.dateTransf = dateTransf;
	}

	public String getDesignMarch() {
		return this.designMarch;
	}

	public void setDesignMarch(String designMarch) {
		this.designMarch = designMarch;
	}

	public String getEtatLign() {
		return this.etatLign;
	}

	public void setEtatLign(String etatLign) {
		this.etatLign = etatLign;
	}

	public String getLieuChgt() {
		return this.lieuChgt;
	}

	public void setLieuChgt(String lieuChgt) {
		this.lieuChgt = lieuChgt;
	}

	public String getMotif() {
		return this.motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getNature() {
		return this.nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public int getNbrColisd() {
		return this.nbrColisd;
	}

	public void setNbrColisd(int nbrColisd) {
		this.nbrColisd = nbrColisd;
	}

	public int getNbrColise() {
		return this.nbrColise;
	}

	public void setNbrColise(int nbrColise) {
		this.nbrColise = nbrColise;
	}

	public int getNbrColism() {
		return this.nbrColism;
	}

	public void setNbrColism(int nbrColism) {
		this.nbrColism = nbrColism;
	}

	public int getNbrColisr() {
		return this.nbrColisr;
	}

	public void setNbrColisr(int nbrColisr) {
		this.nbrColisr = nbrColisr;
	}

	public int getNbrColiss() {
		return this.nbrColiss;
	}

	public void setNbrColiss(int nbrColiss) {
		this.nbrColiss = nbrColiss;
	}

	public int getNumExtrait() {
		return this.numExtrait;
	}

	public void setNumExtrait(int numExtrait) {
		this.numExtrait = numExtrait;
	}

	public short getNumGroup() {
		return this.numGroup;
	}

	public void setNumGroup(short numGroup) {
		this.numGroup = numGroup;
	}

	public short getNumLigne() {
		return this.numLigne;
	}

	public void setNumLigne(short numLigne) {
		this.numLigne = numLigne;
	}

	public short getNumMagasin() {
		return this.numMagasin;
	}

	public void setNumMagasin(short numMagasin) {
		this.numMagasin = numMagasin;
	}

	public int getNumManif() {
		return this.numManif;
	}

	public void setNumManif(int numManif) {
		this.numManif = numManif;
	}

	public int getNumQuitt() {
		return this.numQuitt;
	}

	public void setNumQuitt(int numQuitt) {
		this.numQuitt = numQuitt;
	}

	public String getNumReference() {
		return this.numReference;
	}

	public void setNumReference(String numReference) {
		this.numReference = numReference;
	}

	public int getNumSituation() {
		return this.numSituation;
	}

	public void setNumSituation(int numSituation) {
		this.numSituation = numSituation;
	}

	public BigDecimal getPoidsbM() {
		return this.poidsbM;
	}

	public void setPoidsbM(BigDecimal poidsbM) {
		this.poidsbM = poidsbM;
	}

	public BigDecimal getPoidsbR() {
		return this.poidsbR;
	}

	public void setPoidsbR(BigDecimal poidsbR) {
		this.poidsbR = poidsbR;
	}

	public BigDecimal getPoidsnM() {
		return this.poidsnM;
	}

	public void setPoidsnM(BigDecimal poidsnM) {
		this.poidsnM = poidsnM;
	}

	public BigDecimal getPoidsnR() {
		return this.poidsnR;
	}

	public void setPoidsnR(BigDecimal poidsnR) {
		this.poidsnR = poidsnR;
	}

	public String getTypeManif() {
		return this.typeManif;
	}

	public void setTypeManif(String typeManif) {
		this.typeManif = typeManif;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public Date getDateMarkage() {
		return dateMarkage;
	}

	public void setDateMarkage(Date dateMarkage) {
		this.dateMarkage = dateMarkage;
	}
	
	
	

}