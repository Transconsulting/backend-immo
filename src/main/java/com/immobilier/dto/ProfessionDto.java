package com.immobilier.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.immobilier.model.Agent;

public class ProfessionDto extends ResponseDto{
	
	private String uuid;
	private String libelle;
	@JsonIgnore
    private List<Agent> listeAgents=new ArrayList<Agent>();
    
       
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public List<Agent> getListeAgents() {
		return listeAgents;
	}
	public void setListeAgents(List<Agent> listeAgents) {
		this.listeAgents = listeAgents;
	}
		
}
