package com.immobilier.model;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractDomainClass {
	
	@Id 
	@Column(name = "UUID", updatable = false, nullable = false)
	protected String uuid;  

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated;

	@PrePersist
	public void prePersit() {
		uuid = UUID.randomUUID().toString();
		dateCreated = new Date();
		lastUpdated = new Date(); 
	}

	@PreUpdate
	public void updateTimeStamps() { 
		lastUpdated = new Date();
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public boolean equals(Object o) { 
		if (this == o)
			return true;
		if (o == null)
			return false; 
		String oname = o.getClass().getName();
		String myName = this.getClass().getName();
		if (oname.contains("$$_javassist") || oname.contains("_$$_jvst") || oname.contains("$HibernateProxy")) {
			oname = o.getClass().getSuperclass().getName();
		}
		if (myName.contains("$$_javassist") || myName.contains("_$$_jvst") || myName.contains("$HibernateProxy")) {
			myName = o.getClass().getSuperclass().getName();
		} 

		if (!(oname.equals(myName)))
			return false;
		if (!(o instanceof AbstractDomainClass))
			return false;
		AbstractDomainClass book = (AbstractDomainClass) o;
		return (getUuid() != null && Objects.equals(getUuid(), book.getUuid()));
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	

}
