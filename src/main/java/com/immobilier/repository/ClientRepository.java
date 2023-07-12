package com.immobilier.repository;
 
 

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.immobilier.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
 
	public Client findByTelephone(String telephone);
	public long count();
	
}
