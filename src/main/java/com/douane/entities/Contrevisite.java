package com.douane.entities;
import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@NamedQuery(name="Contrevisite.findAll", query="SELECT c FROM Contrevisite c")
public class Contrevisite implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long   id ; 

	@Column(name="an_manif")
	private Timestamp anManif;

	@Column(name="code_bur")
	private short codeBur;

	@Column(name="date_ajout")
	private Timestamp dateAjout;

	@Column(name="date_enr")
	private Timestamp dateEnr;

	@Column(name="num_cts")
	private String numCts;

	@Column(name="num_decl")
	private int numDecl;

	@Column(name="num_group")
	private short numGroup;

	@Column(name="num_ligne")
	private short numLigne;

	@Column(name="num_manif")
	private int numManif;

	@Column(name="num_reference")
	private String numReference;

	@Column(name="type_controle")
	private String typeControle;

	private String user;
	private boolean flag  ;
	@Column(name = "date_markage")
	@Temporal(TemporalType.DATE)
	private Date dateMarkage  ; 
	

	public Contrevisite() {
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

	public Timestamp getDateAjout() {
		return this.dateAjout;
	}

	public void setDateAjout(Timestamp dateAjout) {
		this.dateAjout = dateAjout;
	}

	public Timestamp getDateEnr() {
		return this.dateEnr;
	}

	public void setDateEnr(Timestamp dateEnr) {
		this.dateEnr = dateEnr;
	}

	public String getNumCts() {
		return this.numCts;
	}

	public void setNumCts(String numCts) {
		this.numCts = numCts;
	}

	public int getNumDecl() {
		return this.numDecl;
	}

	public void setNumDecl(int numDecl) {
		this.numDecl = numDecl;
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

	public String getNumReference() {
		return this.numReference;
	}

	public void setNumReference(String numReference) {
		this.numReference = numReference;
	}

	public String getTypeControle() {
		return this.typeControle;
	}

	public void setTypeControle(String typeControle) {
		this.typeControle = typeControle;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	

}