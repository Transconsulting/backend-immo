package com.immobilier.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.immobilier.model.Utilisateur; 


public interface UtilisateurRepository extends CrudRepository<Utilisateur, String> {

    Page<Utilisateur> findAll(Pageable pageable);
    
    @Query("select u from Utilisateur u where u.email=:x")
    Optional<Utilisateur> findByEmail(@Param("x") String email);
    @Query("select u from Utilisateur u where u.online=1")
    public List<Utilisateur> getByUserOnLigne();
    @Query("select u from Utilisateur u")
    List<Utilisateur> findAll();

}
