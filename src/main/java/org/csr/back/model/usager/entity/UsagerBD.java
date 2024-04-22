package org.csr.back.model.usager.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UsagerBD implements Serializable{
	private static final long serialVersionUID = 530554008957503706L;
	
	private Long id;
	private String nom;
	private String prenom;
	private List<AdresseBD> adresses = new ArrayList<>();
	private List<ContactBD> contacts= new ArrayList<>();
	
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
	public List<AdresseBD> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<AdresseBD> adresses) {
		this.adresses = adresses;
	}
	public List<ContactBD> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactBD> contacts) {
		this.contacts = contacts;
	}
}
