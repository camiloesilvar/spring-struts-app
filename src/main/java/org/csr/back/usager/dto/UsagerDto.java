package org.csr.back.usager.dto;

import java.util.ArrayList;
import java.util.List;

public class UsagerDto {

	private Long id;
	private String nom;
	private String prenom;
	private List<AdresseDto> adresses = new ArrayList<>();
	private List<ContactDTo> contacts= new ArrayList<>();
	
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
	public List<AdresseDto> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<AdresseDto> adresses) {
		this.adresses = adresses;
	}
	public List<ContactDTo> getContacts() {
		return contacts;
	}
	public void setContacts(List<ContactDTo> contacts) {
		this.contacts = contacts;
	}
}
