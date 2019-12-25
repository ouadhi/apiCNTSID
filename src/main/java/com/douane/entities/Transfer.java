package com.douane.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the transfer database table.
 * 
 */
@Entity
@NamedQuery(name="Transfer.findAll", query="SELECT t FROM Transfer t")
public class Transfer implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Long  id ; 

	@Column(name="adr_oper")
	private String adrOper;

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="an_trans")
	private Timestamp anTrans;

	private String chassis;

	@Column(name="code_bur")
	private short codeBur;

	@Temporal(TemporalType.DATE)
	@Column(name="date_apur")
	private Date dateApur;

	@Temporal(TemporalType.DATE)
	@Column(name="date_depot")
	private Date dateDepot;

	@Temporal(TemporalType.DATE)
	@Column(name="date_trans")
	private Date dateTrans;

	@Column(name="design_march")
	private String designMarch;

	@Column(name="lieu_stock")
	private String lieuStock;

	@Column(name="lieu_trans")
	private String lieuTrans;

	@Column(name="nbr_colisd")
	private int nbrColisd;

	@Column(name="nbr_colist")
	private int nbrColist;

	@Column(name="nom_oper")
	private String nomOper;

	@Column(name="num_apur")
	private int numApur;

	@Column(name="num_depot")
	private String numDepot;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="num_trans")
	private int numTrans;

	@Column(name="poidsb_d")
	private BigDecimal poidsbD;

	private String provenance;
	
	private boolean flag ;
	
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date dateMarkage ; 

	public Transfer() {
	}

	public String getAdrOper() {
		return this.adrOper;
	}

	public void setAdrOper(String adrOper) {
		this.adrOper = adrOper;
	}

	public Timestamp getAnManif() {
		return this.anManif;
	}

	public void setAnManif(Timestamp anManif) {
		this.anManif = anManif;
	}

	public Timestamp getAnTrans() {
		return this.anTrans;
	}

	public void setAnTrans(Timestamp anTrans) {
		this.anTrans = anTrans;
	}

	public String getChassis() {
		return this.chassis;
	}

	public void setChassis(String chassis) {
		this.chassis = chassis;
	}

	public short getCodeBur() {
		return this.codeBur;
	}

	public void setCodeBur(short codeBur) {
		this.codeBur = codeBur;
	}

	public Date getDateApur() {
		return this.dateApur;
	}

	public void setDateApur(Date dateApur) {
		this.dateApur = dateApur;
	}

	public Date getDateDepot() {
		return this.dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public Date getDateTrans() {
		return this.dateTrans;
	}

	public void setDateTrans(Date dateTrans) {
		this.dateTrans = dateTrans;
	}

	public String getDesignMarch() {
		return this.designMarch;
	}

	public void setDesignMarch(String designMarch) {
		this.designMarch = designMarch;
	}

	public String getLieuStock() {
		return this.lieuStock;
	}

	public void setLieuStock(String lieuStock) {
		this.lieuStock = lieuStock;
	}

	public String getLieuTrans() {
		return this.lieuTrans;
	}

	public void setLieuTrans(String lieuTrans) {
		this.lieuTrans = lieuTrans;
	}

	public int getNbrColisd() {
		return this.nbrColisd;
	}

	public void setNbrColisd(int nbrColisd) {
		this.nbrColisd = nbrColisd;
	}

	public int getNbrColist() {
		return this.nbrColist;
	}

	public void setNbrColist(int nbrColist) {
		this.nbrColist = nbrColist;
	}

	public String getNomOper() {
		return this.nomOper;
	}

	public void setNomOper(String nomOper) {
		this.nomOper = nomOper;
	}

	public int getNumApur() {
		return this.numApur;
	}

	public void setNumApur(int numApur) {
		this.numApur = numApur;
	}

	public String getNumDepot() {
		return this.numDepot;
	}

	public void setNumDepot(String numDepot) {
		this.numDepot = numDepot;
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

	public int getNumManif() {
		return this.numManif;
	}

	public void setNumManif(int numManif) {
		this.numManif = numManif;
	}

	public int getNumTrans() {
		return this.numTrans;
	}

	public void setNumTrans(int numTrans) {
		this.numTrans = numTrans;
	}

	public BigDecimal getPoidsbD() {
		return this.poidsbD;
	}

	public void setPoidsbD(BigDecimal poidsbD) {
		this.poidsbD = poidsbD;
	}

	public String getProvenance() {
		return this.provenance;
	}

	public void setProvenance(String provenance) {
		this.provenance = provenance;
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