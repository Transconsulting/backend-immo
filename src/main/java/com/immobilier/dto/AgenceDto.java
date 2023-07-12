package com.immobilier.dto;

public class AgenceDto extends ResponseDto{

	private String uuid;
	private String nomAgence;
	private String tel;
	private String address;
	private String mail;
	//private Byte logo;
	
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getNomAgence() {
		return nomAgence;
	}
	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	/*public byte getLogo() {
		return logo;
	}
	public void setLogo(byte logo) {
		this.logo = logo;
	}*/
	
}
