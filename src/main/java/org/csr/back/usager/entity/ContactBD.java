package org.csr.back.usager.entity;

import java.io.Serializable;

public class ContactBD implements Serializable{
	private static final long serialVersionUID = 1834493489012927401L;
	
	private Long id;
	private String nom;
	private String prenom;
	private Long idLien;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Long getIdLien() {
		return idLien;
	}
	public void setIdLien(Long idLien) {
		this.idLien = idLien;
	}
}
