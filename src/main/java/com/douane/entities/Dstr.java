package com.douane.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@NamedQuery(name="Dstr.findAll", query="SELECT d FROM Dstr d")
public class Dstr implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue 
	private  Long  id ; 

	@Column(name="adr_frs")
	private String adrFrs;

	@Column(name="adr_oper")
	private String adrOper;

	@Column(name="an_agrt")
	private Timestamp anAgrt;

	@Column(name="an_dst")
	private Timestamp anDst;

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="bur_dst")
	private short burDst;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="date_apure")
	private Timestamp dateApure;

	@Temporal(TemporalType.DATE)
	@Column(name="date_dst")
	private Date dateDst;

	@Temporal(TemporalType.DATE)
	@Column(name="date_transf")
	private Date dateTransf;

	@Column(name="design_march")
	private String designMarch;

	private String document;

	private String lieu;

	@Column(name="nbr_colisd")
	private int nbrColisd;

	@Column(name="nom_frs")
	private String nomFrs;

	@Column(name="nom_oper")
	private String nomOper;

	@Column(name="num_agrt")
	private int numAgrt;

	@Column(name="num_apure")
	private int numApure;

	@Column(name="num_dst")
	private int numDst;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="pays_frs")
	private String paysFrs;

	@Column(name="poidsb_d")
	private BigDecimal poidsbD;

	@Column(name="type_dst")
	private String typeDst;
	
	private boolean   flag  ;
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date  dateMarkage ; 

	public Dstr() {
	}

	public String getAdrFrs() {
		return this.adrFrs;
	}

	public void setAdrFrs(String adrFrs) {
		this.adrFrs = adrFrs;
	}

	public String getAdrOper() {
		return this.adrOper;
	}

	public void setAdrOper(String adrOper) {
		this.adrOper = adrOper;
	}

	public Timestamp getAnAgrt() {
		return this.anAgrt;
	}

	public void setAnAgrt(Timestamp anAgrt) {
		this.anAgrt = anAgrt;
	}

	public Timestamp getAnDst() {
		return this.anDst;
	}

	public void setAnDst(Timestamp anDst) {
		this.anDst = anDst;
	}

	public Timestamp getAnManif() {
		return this.anManif;
	}

	public void setAnManif(Timestamp anManif) {
		this.anManif = anManif;
	}

	public short getBurDst() {
		return this.burDst;
	}

	public void setBurDst(short burDst) {
		this.burDst = burDst;
	}

	public short getCodeBur() {
		return this.codeBur;
	}

	public void setCodeBur(short codeBur) {
		this.codeBur = codeBur;
	}

	public Timestamp getDateApure() {
		return this.dateApure;
	}

	public void setDateApure(Timestamp dateApure) {
		this.dateApure = dateApure;
	}

	public Date getDateDst() {
		return this.dateDst;
	}

	public void setDateDst(Date dateDst) {
		this.dateDst = dateDst;
	}

	public Date getDateTransf() {
		return this.dateTransf;
	}

	public void setDateTransf(Date dateTransf) {
		this.dateTransf = dateTransf;
	}

	public String getDesignMarch() {
		return this.designMarch;
	}

	public void setDesignMarch(String designMarch) {
		this.designMarch = designMarch;
	}

	public String getDocument() {
		return this.document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getLieu() {
		return this.lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public int getNbrColisd() {
		return this.nbrColisd;
	}

	public void setNbrColisd(int nbrColisd) {
		this.nbrColisd = nbrColisd;
	}

	public String getNomFrs() {
		return this.nomFrs;
	}

	public void setNomFrs(String nomFrs) {
		this.nomFrs = nomFrs;
	}

	public String getNomOper() {
		return this.nomOper;
	}

	public void setNomOper(String nomOper) {
		this.nomOper = nomOper;
	}

	public int getNumAgrt() {
		return this.numAgrt;
	}

	public void setNumAgrt(int numAgrt) {
		this.numAgrt = numAgrt;
	}

	public int getNumApure() {
		return this.numApure;
	}

	public void setNumApure(int numApure) {
		this.numApure = numApure;
	}

	public int getNumDst() {
		return this.numDst;
	}

	public void setNumDst(int numDst) {
		this.numDst = numDst;
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

	public String getPaysFrs() {
		return this.paysFrs;
	}

	public void setPaysFrs(String paysFrs) {
		this.paysFrs = paysFrs;
	}

	public BigDecimal getPoidsbD() {
		return this.poidsbD;
	}

	public void setPoidsbD(BigDecimal poidsbD) {
		this.poidsbD = poidsbD;
	}

	public String getTypeDst() {
		return this.typeDst;
	}

	public void setTypeDst(String typeDst) {
		this.typeDst = typeDst;
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