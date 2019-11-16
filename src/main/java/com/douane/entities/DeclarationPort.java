package com.douane.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;



@Entity
@Table(name="declaration_port")
@NamedQuery(name="DeclarationPort.findAll", query="SELECT d FROM DeclarationPort d")
public class DeclarationPort implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue  
	private Long  id  ; 

	@Column(name="adr_frs")
	private String adrFrs;

	@Column(name="adr_rangee")
	private String adrRangee;

	@Column(name="agence_dom")
	private String agenceDom;

	@Column(name="an_agrt")
	private Timestamp anAgrt;

	@Column(name="an_decl")
	private Timestamp anDecl;

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="an_oper")
	private Timestamp anOper;

	private short articles;

	@Column(name="at_et")
	private int atEt;

	@Column(name="bnq_dom")
	private String bnqDom;

	@Column(name="bur_arrive")
	private short burArrive;

	@Column(name="bur_code_bur")
	private short burCodeBur;

	@Column(name="bur_depart")
	private short burDepart;

	@Column(name="bur2_code_bur")
	private short bur2CodeBur;

	private String circuit;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="code_bur_manif")
	private short codeBurManif;

	@Column(name="code_eng")
	private String codeEng;

	@Column(name="code_oper")
	private int codeOper;

	@Column(name="code_reg")
	private short codeReg;

	@Column(name="coeff_ajust")
	private BigDecimal coeffAjust;

	@Column(name="colis_decl")
	private int colisDecl;

	@Column(name="cpt_tint")
	private short cptTint;

	@Column(name="dat_date_heur")
	private Timestamp datDateHeur;

	@Column(name="date_bae")
	private Timestamp dateBae;

	@Column(name="date_cotation")
	private Timestamp dateCotation;

	@Column(name="date_heur")
	private Timestamp dateHeur;

	@Column(name="date_inspect")
	private Timestamp dateInspect;

	@Column(name="date_primo")
	private Timestamp datePrimo;

	@Column(name="date_verif")
	private Timestamp dateVerif;

	@Column(name="dec_an_decl")
	private Timestamp decAnDecl;

	@Column(name="dec_code_bur")
	private short decCodeBur;

	@Column(name="dec_num_decl")
	private int decNumDecl;

	@Column(name="dossier_dcl")
	private String dossierDcl;

	@Column(name="duree_at")
	private short dureeAt;

	@Column(name="etat_dcl")
	private String etatDcl;

	@Column(name="etat_rcv")
	private String etatRcv;

	@Column(name="ident_tint")
	private String identTint;

	@Column(name="kg_douane")
	private BigDecimal kgDouane;

	private BigDecimal lavaleur;

	@Column(name="lc_ass")
	private BigDecimal lcAss;

	@Column(name="lc_frais")
	private BigDecimal lcFrais;

	@Column(name="lc_fret")
	private BigDecimal lcFret;

	@Column(name="lc_ptfn")
	private BigDecimal lcPtfn;

	@Column(name="lieu_at")
	private String lieuAt;

	@Column(name="mat_agt")
	private int matAgt;

	@Column(name="mod_tint")
	private String modTint;

	@Column(name="mode_finance")
	private String modeFinance;

	@Column(name="mode_paiement")
	private String modePaiement;

	@Column(name="mon_dcl")
	private BigDecimal monDcl;

	@Column(name="monnaie_ass")
	private String monnaieAss;

	@Column(name="monnaie_frais")
	private String monnaieFrais;

	@Column(name="monnaie_fret")
	private String monnaieFret;

	@Column(name="monnaie_ptfn")
	private String monnaiePtfn;

	@Column(name="mt_ass")
	private BigDecimal mtAss;

	@Column(name="mt_ass2")
	private BigDecimal mtAss2;

	@Column(name="mt_caution")
	private BigDecimal mtCaution;

	@Column(name="mt_coef")
	private BigDecimal mtCoef;

	@Column(name="mt_frais")
	private BigDecimal mtFrais;

	@Column(name="mt_frais2")
	private BigDecimal mtFrais2;

	@Column(name="mt_fret")
	private BigDecimal mtFret;

	@Column(name="mt_fret2")
	private BigDecimal mtFret2;

	@Column(name="mt_ptfn")
	private BigDecimal mtPtfn;

	@Column(name="mt_ptfn2")
	private BigDecimal mtPtfn2;

	@Column(name="nat_contrat")
	private String natContrat;

	@Column(name="nbr_art")
	private short nbrArt;

	@Column(name="nom_frs")
	private String nomFrs;

	@Column(name="num_agrt")
	private int numAgrt;

	@Column(name="num_cred")
	private short numCred;

	@Column(name="num_decl")
	private int numDecl;

	@Column(name="num_dom")
	private String numDom;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="num_rep")
	private int numRep;

	private short passage;

	@Column(name="pay_prov")
	private String payProv;

	@Column(name="pays_frs")
	private String paysFrs;

	@Column(name="plus_value")
	private BigDecimal plusValue;

	@Column(name="poids_decl")
	private BigDecimal poidsDecl;

	@Column(name="poidsn_dcl")
	private BigDecimal poidsnDcl;

	@Column(name="rec_dcl")
	private String recDcl;

	@Column(name="rec_verif")
	private String recVerif;

	@Column(name="rec_visit")
	private String recVisit;

	@Column(name="rel_av")
	private String relAv;

	@Column(name="res_verif")
	private String resVerif;

	@Column(name="res_visit")
	private String resVisit;

	private short revue;

	@Column(name="tx_susp")
	private BigDecimal txSusp;

	@Column(name="type_dcl")
	private String typeDcl;

	@Column(name="type_ded")
	private String typeDed;

	@Column(name="type_manif")
	private String typeManif;

	@Column(name="type_operat")
	private String typeOperat;

	@Column(name="val_douane")
	private BigDecimal valDouane;
	
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date  dateMarkage   ; 

	private int valider;
	
	private boolean   flag  ; 

	public DeclarationPort() {
	}

	public String getAdrFrs() {
		return this.adrFrs;
	}

	public void setAdrFrs(String adrFrs) {
		this.adrFrs = adrFrs;
	}

	public String getAdrRangee() {
		return this.adrRangee;
	}

	public void setAdrRangee(String adrRangee) {
		this.adrRangee = adrRangee;
	}

	public String getAgenceDom() {
		return this.agenceDom;
	}

	public void setAgenceDom(String agenceDom) {
		this.agenceDom = agenceDom;
	}

	public Timestamp getAnAgrt() {
		return this.anAgrt;
	}

	public void setAnAgrt(Timestamp anAgrt) {
		this.anAgrt = anAgrt;
	}

	public Timestamp getAnDecl() {
		return this.anDecl;
	}

	public void setAnDecl(Timestamp anDecl) {
		this.anDecl = anDecl;
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

	public short getArticles() {
		return this.articles;
	}

	public void setArticles(short articles) {
		this.articles = articles;
	}

	public int getAtEt() {
		return this.atEt;
	}

	public void setAtEt(int atEt) {
		this.atEt = atEt;
	}

	public String getBnqDom() {
		return this.bnqDom;
	}

	public void setBnqDom(String bnqDom) {
		this.bnqDom = bnqDom;
	}

	public short getBurArrive() {
		return this.burArrive;
	}

	public void setBurArrive(short burArrive) {
		this.burArrive = burArrive;
	}

	public short getBurCodeBur() {
		return this.burCodeBur;
	}

	public void setBurCodeBur(short burCodeBur) {
		this.burCodeBur = burCodeBur;
	}

	public short getBurDepart() {
		return this.burDepart;
	}

	public void setBurDepart(short burDepart) {
		this.burDepart = burDepart;
	}

	public short getBur2CodeBur() {
		return this.bur2CodeBur;
	}

	public void setBur2CodeBur(short bur2CodeBur) {
		this.bur2CodeBur = bur2CodeBur;
	}

	public String getCircuit() {
		return this.circuit;
	}

	public void setCircuit(String circuit) {
		this.circuit = circuit;
	}

	public short getCodeBur() {
		return this.codeBur;
	}

	public void setCodeBur(short codeBur) {
		this.codeBur = codeBur;
	}

	public short getCodeBurManif() {
		return this.codeBurManif;
	}

	public void setCodeBurManif(short codeBurManif) {
		this.codeBurManif = codeBurManif;
	}

	public String getCodeEng() {
		return this.codeEng;
	}

	public void setCodeEng(String codeEng) {
		this.codeEng = codeEng;
	}

	public int getCodeOper() {
		return this.codeOper;
	}

	public void setCodeOper(int codeOper) {
		this.codeOper = codeOper;
	}

	public short getCodeReg() {
		return this.codeReg;
	}

	public void setCodeReg(short codeReg) {
		this.codeReg = codeReg;
	}

	public BigDecimal getCoeffAjust() {
		return this.coeffAjust;
	}

	public void setCoeffAjust(BigDecimal coeffAjust) {
		this.coeffAjust = coeffAjust;
	}

	public int getColisDecl() {
		return this.colisDecl;
	}

	public void setColisDecl(int colisDecl) {
		this.colisDecl = colisDecl;
	}

	public short getCptTint() {
		return this.cptTint;
	}

	public void setCptTint(short cptTint) {
		this.cptTint = cptTint;
	}

	public Timestamp getDatDateHeur() {
		return this.datDateHeur;
	}

	public void setDatDateHeur(Timestamp datDateHeur) {
		this.datDateHeur = datDateHeur;
	}

	public Timestamp getDateBae() {
		return this.dateBae;
	}

	public void setDateBae(Timestamp dateBae) {
		this.dateBae = dateBae;
	}

	public Timestamp getDateCotation() {
		return this.dateCotation;
	}

	public void setDateCotation(Timestamp dateCotation) {
		this.dateCotation = dateCotation;
	}

	public Timestamp getDateHeur() {
		return this.dateHeur;
	}

	public void setDateHeur(Timestamp dateHeur) {
		this.dateHeur = dateHeur;
	}

	public Timestamp getDateInspect() {
		return this.dateInspect;
	}

	public void setDateInspect(Timestamp dateInspect) {
		this.dateInspect = dateInspect;
	}

	public Timestamp getDatePrimo() {
		return this.datePrimo;
	}

	public void setDatePrimo(Timestamp datePrimo) {
		this.datePrimo = datePrimo;
	}

	public Timestamp getDateVerif() {
		return this.dateVerif;
	}

	public void setDateVerif(Timestamp dateVerif) {
		this.dateVerif = dateVerif;
	}

	public Timestamp getDecAnDecl() {
		return this.decAnDecl;
	}

	public void setDecAnDecl(Timestamp decAnDecl) {
		this.decAnDecl = decAnDecl;
	}

	public short getDecCodeBur() {
		return this.decCodeBur;
	}

	public void setDecCodeBur(short decCodeBur) {
		this.decCodeBur = decCodeBur;
	}

	public int getDecNumDecl() {
		return this.decNumDecl;
	}

	public void setDecNumDecl(int decNumDecl) {
		this.decNumDecl = decNumDecl;
	}

	public String getDossierDcl() {
		return this.dossierDcl;
	}

	public void setDossierDcl(String dossierDcl) {
		this.dossierDcl = dossierDcl;
	}

	public short getDureeAt() {
		return this.dureeAt;
	}

	public void setDureeAt(short dureeAt) {
		this.dureeAt = dureeAt;
	}

	public String getEtatDcl() {
		return this.etatDcl;
	}

	public void setEtatDcl(String etatDcl) {
		this.etatDcl = etatDcl;
	}

	public String getEtatRcv() {
		return this.etatRcv;
	}

	public void setEtatRcv(String etatRcv) {
		this.etatRcv = etatRcv;
	}

	public String getIdentTint() {
		return this.identTint;
	}

	public void setIdentTint(String identTint) {
		this.identTint = identTint;
	}

	public BigDecimal getKgDouane() {
		return this.kgDouane;
	}

	public void setKgDouane(BigDecimal kgDouane) {
		this.kgDouane = kgDouane;
	}

	public BigDecimal getLavaleur() {
		return this.lavaleur;
	}

	public void setLavaleur(BigDecimal lavaleur) {
		this.lavaleur = lavaleur;
	}

	public BigDecimal getLcAss() {
		return this.lcAss;
	}

	public void setLcAss(BigDecimal lcAss) {
		this.lcAss = lcAss;
	}

	public BigDecimal getLcFrais() {
		return this.lcFrais;
	}

	public void setLcFrais(BigDecimal lcFrais) {
		this.lcFrais = lcFrais;
	}

	public BigDecimal getLcFret() {
		return this.lcFret;
	}

	public void setLcFret(BigDecimal lcFret) {
		this.lcFret = lcFret;
	}

	public BigDecimal getLcPtfn() {
		return this.lcPtfn;
	}

	public void setLcPtfn(BigDecimal lcPtfn) {
		this.lcPtfn = lcPtfn;
	}

	public String getLieuAt() {
		return this.lieuAt;
	}

	public void setLieuAt(String lieuAt) {
		this.lieuAt = lieuAt;
	}

	public int getMatAgt() {
		return this.matAgt;
	}

	public void setMatAgt(int matAgt) {
		this.matAgt = matAgt;
	}

	public String getModTint() {
		return this.modTint;
	}

	public void setModTint(String modTint) {
		this.modTint = modTint;
	}

	public String getModeFinance() {
		return this.modeFinance;
	}

	public void setModeFinance(String modeFinance) {
		this.modeFinance = modeFinance;
	}

	public String getModePaiement() {
		return this.modePaiement;
	}

	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}

	public BigDecimal getMonDcl() {
		return this.monDcl;
	}

	public void setMonDcl(BigDecimal monDcl) {
		this.monDcl = monDcl;
	}

	public String getMonnaieAss() {
		return this.monnaieAss;
	}

	public void setMonnaieAss(String monnaieAss) {
		this.monnaieAss = monnaieAss;
	}

	public String getMonnaieFrais() {
		return this.monnaieFrais;
	}

	public void setMonnaieFrais(String monnaieFrais) {
		this.monnaieFrais = monnaieFrais;
	}

	public String getMonnaieFret() {
		return this.monnaieFret;
	}

	public void setMonnaieFret(String monnaieFret) {
		this.monnaieFret = monnaieFret;
	}

	public String getMonnaiePtfn() {
		return this.monnaiePtfn;
	}

	public void setMonnaiePtfn(String monnaiePtfn) {
		this.monnaiePtfn = monnaiePtfn;
	}

	public BigDecimal getMtAss() {
		return this.mtAss;
	}

	public void setMtAss(BigDecimal mtAss) {
		this.mtAss = mtAss;
	}

	public BigDecimal getMtAss2() {
		return this.mtAss2;
	}

	public void setMtAss2(BigDecimal mtAss2) {
		this.mtAss2 = mtAss2;
	}

	public BigDecimal getMtCaution() {
		return this.mtCaution;
	}

	public void setMtCaution(BigDecimal mtCaution) {
		this.mtCaution = mtCaution;
	}

	public BigDecimal getMtCoef() {
		return this.mtCoef;
	}

	public void setMtCoef(BigDecimal mtCoef) {
		this.mtCoef = mtCoef;
	}

	public BigDecimal getMtFrais() {
		return this.mtFrais;
	}

	public void setMtFrais(BigDecimal mtFrais) {
		this.mtFrais = mtFrais;
	}

	public BigDecimal getMtFrais2() {
		return this.mtFrais2;
	}

	public void setMtFrais2(BigDecimal mtFrais2) {
		this.mtFrais2 = mtFrais2;
	}

	public BigDecimal getMtFret() {
		return this.mtFret;
	}

	public void setMtFret(BigDecimal mtFret) {
		this.mtFret = mtFret;
	}

	public BigDecimal getMtFret2() {
		return this.mtFret2;
	}

	public void setMtFret2(BigDecimal mtFret2) {
		this.mtFret2 = mtFret2;
	}

	public BigDecimal getMtPtfn() {
		return this.mtPtfn;
	}

	public void setMtPtfn(BigDecimal mtPtfn) {
		this.mtPtfn = mtPtfn;
	}

	public BigDecimal getMtPtfn2() {
		return this.mtPtfn2;
	}

	public void setMtPtfn2(BigDecimal mtPtfn2) {
		this.mtPtfn2 = mtPtfn2;
	}

	public String getNatContrat() {
		return this.natContrat;
	}

	public void setNatContrat(String natContrat) {
		this.natContrat = natContrat;
	}

	public short getNbrArt() {
		return this.nbrArt;
	}

	public void setNbrArt(short nbrArt) {
		this.nbrArt = nbrArt;
	}

	public String getNomFrs() {
		return this.nomFrs;
	}

	public void setNomFrs(String nomFrs) {
		this.nomFrs = nomFrs;
	}

	public int getNumAgrt() {
		return this.numAgrt;
	}

	public void setNumAgrt(int numAgrt) {
		this.numAgrt = numAgrt;
	}

	public short getNumCred() {
		return this.numCred;
	}

	public void setNumCred(short numCred) {
		this.numCred = numCred;
	}

	public int getNumDecl() {
		return this.numDecl;
	}

	public void setNumDecl(int numDecl) {
		this.numDecl = numDecl;
	}

	public String getNumDom() {
		return this.numDom;
	}

	public void setNumDom(String numDom) {
		this.numDom = numDom;
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

	public int getNumRep() {
		return this.numRep;
	}

	public void setNumRep(int numRep) {
		this.numRep = numRep;
	}

	public short getPassage() {
		return this.passage;
	}

	public void setPassage(short passage) {
		this.passage = passage;
	}

	public String getPayProv() {
		return this.payProv;
	}

	public void setPayProv(String payProv) {
		this.payProv = payProv;
	}

	public String getPaysFrs() {
		return this.paysFrs;
	}

	public void setPaysFrs(String paysFrs) {
		this.paysFrs = paysFrs;
	}

	public BigDecimal getPlusValue() {
		return this.plusValue;
	}

	public void setPlusValue(BigDecimal plusValue) {
		this.plusValue = plusValue;
	}

	public BigDecimal getPoidsDecl() {
		return this.poidsDecl;
	}

	public void setPoidsDecl(BigDecimal poidsDecl) {
		this.poidsDecl = poidsDecl;
	}

	public BigDecimal getPoidsnDcl() {
		return this.poidsnDcl;
	}

	public void setPoidsnDcl(BigDecimal poidsnDcl) {
		this.poidsnDcl = poidsnDcl;
	}

	public String getRecDcl() {
		return this.recDcl;
	}

	public void setRecDcl(String recDcl) {
		this.recDcl = recDcl;
	}

	public String getRecVerif() {
		return this.recVerif;
	}

	public void setRecVerif(String recVerif) {
		this.recVerif = recVerif;
	}

	public String getRecVisit() {
		return this.recVisit;
	}

	public void setRecVisit(String recVisit) {
		this.recVisit = recVisit;
	}

	public String getRelAv() {
		return this.relAv;
	}

	public void setRelAv(String relAv) {
		this.relAv = relAv;
	}

	public String getResVerif() {
		return this.resVerif;
	}

	public void setResVerif(String resVerif) {
		this.resVerif = resVerif;
	}

	public String getResVisit() {
		return this.resVisit;
	}

	public void setResVisit(String resVisit) {
		this.resVisit = resVisit;
	}

	public short getRevue() {
		return this.revue;
	}

	public void setRevue(short revue) {
		this.revue = revue;
	}

	public BigDecimal getTxSusp() {
		return this.txSusp;
	}

	public void setTxSusp(BigDecimal txSusp) {
		this.txSusp = txSusp;
	}

	public String getTypeDcl() {
		return this.typeDcl;
	}

	public void setTypeDcl(String typeDcl) {
		this.typeDcl = typeDcl;
	}

	public String getTypeDed() {
		return this.typeDed;
	}

	public void setTypeDed(String typeDed) {
		this.typeDed = typeDed;
	}

	public String getTypeManif() {
		return this.typeManif;
	}

	public void setTypeManif(String typeManif) {
		this.typeManif = typeManif;
	}

	public String getTypeOperat() {
		return this.typeOperat;
	}

	public void setTypeOperat(String typeOperat) {
		this.typeOperat = typeOperat;
	}

	public BigDecimal getValDouane() {
		return this.valDouane;
	}

	public void setValDouane(BigDecimal valDouane) {
		this.valDouane = valDouane;
	}

	public int getValider() {
		return this.valider;
	}

	public void setValider(int valider) {
		this.valider = valider;
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