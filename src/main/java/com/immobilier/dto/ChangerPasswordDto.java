package com.immobilier.dto;
 


public class ChangerPasswordDto extends ResponseDto {

    private String uuid;
    private String email;
    private String ancienPassword;
	private String nouveauPassword;
	private String confirmer;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	} 
	public String getConfirmer() {
		return confirmer;
	}
	public void setConfirmer(String confirmer) {
		this.confirmer = confirmer;
	}
	public String getAncienPassword() {
		return ancienPassword;
	}
	public void setAncienPassword(String ancienPassword) {
		this.ancienPassword = ancienPassword;
	}
	public String getNouveauPassword() {
		return nouveauPassword;
	}
	public void setNouveauPassword(String nouveauPassword) {
		this.nouveauPassword = nouveauPassword;
	}
	 
	
}
