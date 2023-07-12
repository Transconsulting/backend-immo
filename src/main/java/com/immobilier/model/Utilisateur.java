package com.immobilier.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.immobilier.enumeration.EnumRole; 


@Entity
public class Utilisateur extends AbstractDomainClass {

	private String nom;
	private String prenom;
	private String telephone;
	private boolean online;
    @Column(name = "HASHED_PASSWORD", nullable = true)
    private String password;
     
    @OneToMany(mappedBy = "utilisateur", fetch = FetchType.LAZY)
	private List<Interese> interese;

   //@Column(name = "EMAIL",updatable = true, unique = true, nullable = false)
    @Email(message = "Email should be valid")
    private String email; 
    
    
    @ElementCollection
    @CollectionTable(name = "UTILISATEUR_ROLES", joinColumns = @JoinColumn(name = "USER_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE")
    private List<EnumRole> roles = new ArrayList<EnumRole>();

    boolean nonExpired = true;

    boolean nonLocked = true;

    boolean Enabled = false;
    

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public boolean isNonExpired() {
        return nonExpired;
    }

   

	public boolean isNonLocked() {
        return nonLocked;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
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

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public void setNonExpired(boolean nonExpired) {
        this.nonExpired = nonExpired;
    }

    public void setNonLocked(boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    public void setEnabled(boolean enabled) {
        Enabled = enabled;
    }

    public List<EnumRole> getRoles() {
		return roles;
	}

    public void setRoles(List<EnumRole> roles) {
        this.roles = roles;
    }

	public List<Interese> getInterese() {
		return interese;
	}

	public void setInterese(List<Interese> interese) {
		this.interese = interese;
	}

    
}
