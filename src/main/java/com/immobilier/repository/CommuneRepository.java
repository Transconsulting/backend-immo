package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.Commune; 

public interface CommuneRepository extends JpaRepository<Commune, String>{
	
	Commune findByNomCommuneAndVilleUuid(String commune,String uuidVille);
	List<Commune> findAllByVilleUuid(String uuid);
}
