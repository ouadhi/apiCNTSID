package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@NamedQuery(name="Manifeste.findAll", query="SELECT m FROM Manifeste m")
public class Manifeste implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="date_arrive")
	private Timestamp dateArrive;

	@Column(name="date_enr")
	private Timestamp dateEnr;

	@Column(name="date_entre")
	private Timestamp dateEntre;

	private String entree;

	@Column(name="lieu_debarq")
	private String lieuDebarq;

	@Column(name="nat_manif")
	private String natManif;

	@Column(name="nbre_lig")
	private short nbreLig;

	@Column(name="num_consig")
	private int numConsig;

	@Column(name="num_magasin")
	private short numMagasin;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="num_transp")
	private String numTransp;

	@Column(name="poidsb_t")
	private BigDecimal poidsbT;

	@Column(name="poidsm_t")
	private BigDecimal poidsmT;

	private String transport;

	@Column(name="type_manif")
	private String typeManif;
	
	@Column(name="flag")
	private boolean  flag  ;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_markage")
	private Date dateMarkage;

	public Manifeste() {
	}

	public Timestamp getAnManif() {
		return this.anManif;
	}

	public void setAnManif(Timestamp anManif) {
		this.anManif = anManif;
	}

	public short getCodeBur() {
		return this.codeBur;
	}

	public void setCodeBur(short codeBur) {
		this.codeBur = codeBur;
	}

	public Timestamp getDateArrive() {
		return this.dateArrive;
	}

	public void setDateArrive(Timestamp dateArrive) {
		this.dateArrive = dateArrive;
	}

	public Timestamp getDateEnr() {
		return this.dateEnr;
	}

	public void setDateEnr(Timestamp dateEnr) {
		this.dateEnr = dateEnr;
	}

	public Timestamp getDateEntre() {
		return this.dateEntre;
	}

	public void setDateEntre(Timestamp dateEntre) {
		this.dateEntre = dateEntre;
	}

	public String getEntree() {
		return this.entree;
	}

	public void setEntree(String entree) {
		this.entree = entree;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLieuDebarq() {
		return this.lieuDebarq;
	}

	public void setLieuDebarq(String lieuDebarq) {
		this.lieuDebarq = lieuDebarq;
	}

	public String getNatManif() {
		return this.natManif;
	}

	public void setNatManif(String natManif) {
		this.natManif = natManif;
	}

	public short getNbreLig() {
		return this.nbreLig;
	}

	public void setNbreLig(short nbreLig) {
		this.nbreLig = nbreLig;
	}

	public int getNumConsig() {
		return this.numConsig;
	}

	public void setNumConsig(int numConsig) {
		this.numConsig = numConsig;
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

	public String getNumTransp() {
		return this.numTransp;
	}
	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setNumTransp(String numTransp) {
		this.numTransp = numTransp;
	}

	public BigDecimal getPoidsbT() {
		return this.poidsbT;
	}

	public void setPoidsbT(BigDecimal poidsbT) {
		this.poidsbT = poidsbT;
	}

	public BigDecimal getPoidsmT() {
		return this.poidsmT;
	}

	public void setPoidsmT(BigDecimal poidsmT) {
		this.poidsmT = poidsmT;
	}

	public String getTransport() {
		return this.transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getTypeManif() {
		return this.typeManif;
	}

	public void setTypeManif(String typeManif) {
		this.typeManif = typeManif;
	}

	public Date getDateMarkage() {
		return dateMarkage;
	}

	public void setDateMarkage(Date dateMarkage) {
		this.dateMarkage = dateMarkage;
	}
	
	
	

}