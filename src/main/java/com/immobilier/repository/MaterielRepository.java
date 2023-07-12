package com.immobilier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.immobilier.model.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, String>{
	public Materiel findByLibelle(String libelle);
}
