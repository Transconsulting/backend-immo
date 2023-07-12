package com.immobilier.repository;
 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.CommandeClient; 

public interface CommandeClientRepository extends JpaRepository<CommandeClient, String> {
	Optional<CommandeClient> findCommandeClientByNumCmd(String numero);
}
