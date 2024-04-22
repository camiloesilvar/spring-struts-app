package org.csr.back.model.usager.entity;

import java.io.Serializable;

public class AdresseBD implements Serializable{
	private static final long serialVersionUID = 453192313965514226L;
	
	private Long id;
	private String codePostal;
	private String ligne1;
	private String ligne2;
	private String ligne3;
	private Long idMunicipalite;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getLigne1() {
		return ligne1;
	}
	public void setLigne1(String ligne1) {
		this.ligne1 = ligne1;
	}
	public String getLigne2() {
		return ligne2;
	}
	public void setLigne2(String ligne2) {
		this.ligne2 = ligne2;
	}
	public String getLigne3() {
		return ligne3;
	}
	public void setLigne3(String ligne3) {
		this.ligne3 = ligne3;
	}
	public Long getIdMunicipalite() {
		return idMunicipalite;
	}
	public void setIdMunicipalite(Long idMunicipalite) {
		this.idMunicipalite = idMunicipalite;
	}
}
