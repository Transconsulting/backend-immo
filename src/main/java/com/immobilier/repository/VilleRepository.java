package com.immobilier.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.model.Ville;

public interface VilleRepository extends JpaRepository<Ville, String> {
	Ville findByNomVille(String ville);
} 
