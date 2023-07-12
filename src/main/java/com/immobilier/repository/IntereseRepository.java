package com.immobilier.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.immobilier.model.Interese;

public interface IntereseRepository extends JpaRepository<Interese, String> {
	public long countAllByParcelleAppartemntUuid(String uuidParcelApp);
	public boolean existsByParcelleAppartemntUuidAndUtilisateurUuid(String uuidParcel,String uuidUser);
	public List<Interese> findAllByParcelleAppartemntUuid(String uuid);
	public List<Interese> findAllByOrderByDateCreatedDesc(); 
}
