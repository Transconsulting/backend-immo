package com.immobilier.service;
 
import java.util.List;

import com.immobilier.dto.ChangerPasswordDto;
import com.immobilier.dto.UtilisateurDto;
 
public interface UtilisateurService {

	UtilisateurDto save(UtilisateurDto userDto);
    UtilisateurDto updateUtilisateur(UtilisateurDto utilisateurDto,String uuid);
	void deleteUtilisateur(String uuid);
	UtilisateurDto getUtilisateur(String uuid);
	UtilisateurDto getUtilisateurByEmail(String email);
	void  deconnecterUtilisateur();
	List<UtilisateurDto> getByUserOnLigne();
	List<UtilisateurDto> findAll();

	ChangerPasswordDto changerPassword(ChangerPasswordDto dto);
}
