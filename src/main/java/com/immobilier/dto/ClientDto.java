package com.immobilier.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
 
public class ClientDto extends ResponseDto{

	private String uuid;
	private String nom;
	private String prenom;
	private String telephone; 
	private LocalDate dateNaissance; 
	private String etatCivil; 
	private String nombreEnfant; 
	@JsonIgnore
	private  List<ContratDto> listeContratDTO=new ArrayList<>();
	@JsonIgnore
	private  List<CommandeClientDto> listeCommandeClient=new ArrayList<>();
	
	public ClientDto() { 
	}

	
	public String getUuid() {
		return uuid;
	}


	public void setUuid(String uuid) { 
		this.uuid = uuid;
	}


	public List<ContratDto> getListeContratDTO() {
		return listeContratDTO;
	}


	public void setListeContratDTO(List<ContratDto> listeContratDTO) {
		this.listeContratDTO = listeContratDTO;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEtatCivil() {
		return etatCivil;
	}

	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}

	public String getNombreEnfant() {
		return nombreEnfant;
	}

	public void setNombreEnfant(String nombreEnfant) {
		this.nombreEnfant = nombreEnfant;
	}

	public List<ContratDto> getListeContrat() {
		return listeContratDTO;
	}

	public void setListeContrat(List<ContratDto> listeContratDTO) {
		this.listeContratDTO = listeContratDTO;
	}


	public List<CommandeClientDto> getListeCommandeClient() {
		return listeCommandeClient;
	}


	public void setListeCommandeClient(List<CommandeClientDto> listeCommandeClient) {
		this.listeCommandeClient = listeCommandeClient;
	}

	
}
