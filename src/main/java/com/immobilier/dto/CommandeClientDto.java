package com.immobilier.dto;

import java.util.Date;
import java.util.List;
 



public class CommandeClientDto extends ResponseDto {
	
	private String uuid;
	private String numCmd;
	private Date datCmd;
	private double montantCmd;
	private double payer;
	private String uuidClient;
	private List<DetailCommandeClientDto> listDetailCommandeDto;
	private List<PaiementFactureDto> listPaiementFactureDto;
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getNumCmd() {
		return numCmd;
	}
	public void setNumCmd(String numCmd) {
		this.numCmd = numCmd;
	}
	public Date getDatCmd() {
		return datCmd;
	}
	
	public void setDatCmd(Date datCmd) {
		this.datCmd = datCmd;
	}
	
	public double getMontantCmd() {
		return montantCmd;
	}
	
	public void setMontantCmd(double montantCmd) {
		this.montantCmd = montantCmd;
	}
	
	public String getUuidClient() {
		return uuidClient;
	}
	
	public void setUuidClient(String uuidClient) {
		this.uuidClient = uuidClient;
	}

	public double getPayer() {
		return payer;
	}

	public void setPayer(double payer) {
		this.payer = payer;
	}

	public List<DetailCommandeClientDto> getListDetailCommandeDto() {
		return listDetailCommandeDto;
	}

	public void setListDetailCommandeDto(List<DetailCommandeClientDto> listDetailCommandeDto) {
		this.listDetailCommandeDto = listDetailCommandeDto;
	}

	public List<PaiementFactureDto> getListPaiementFactureDto() {
		return listPaiementFactureDto;
	}

	public void setListPaiementFactureDto(List<PaiementFactureDto> listPaiementFactureDto) {
		this.listPaiementFactureDto = listPaiementFactureDto;
	}
	
	
	
}
