package com.immobilier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.immobilier.model.Profession;

public interface ProfessionRepository extends JpaRepository<Profession, String>{
	Profession findByLibelle(String profession);
}
