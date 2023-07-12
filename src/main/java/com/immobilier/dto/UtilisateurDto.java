package com.immobilier.dto;

import java.util.ArrayList;
import java.util.List;

import com.immobilier.enumeration.EnumRole; 


public class UtilisateurDto extends ResponseDto {

    private String uuid;

    private String password;

    private String email;
    private String nom;
	private String prenom;
	private String telephone;
	private boolean online;
    private boolean nonExpired ;
    private boolean nonLocked;
    private boolean Enabled;
    private List<EnumRole> roles = new ArrayList<EnumRole>();
 
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

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EnumRole> getRoles() {
        return roles;
    }

    public void setRoles(List<EnumRole> roles) {
        this.roles = roles;
    }

    public String getUuid() {
        return uuid;
    }

    

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

	public boolean isNonExpired() {
		return nonExpired;
	}

	public void setNonExpired(boolean nonExpired) {
		this.nonExpired = nonExpired;
	}

	public boolean isNonLocked() {
		return nonLocked;
	}

	public void setNonLocked(boolean nonLocked) {
		this.nonLocked = nonLocked;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
    
    

    

}
