package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.immobilier.dto.ChangerPasswordDto;
import com.immobilier.dto.ResponseDto;
import com.immobilier.dto.UtilisateurDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Utilisateur;
import com.immobilier.repository.UtilisateurRepository;
import com.immobilier.service.UtilisateurService; 



@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UtilisateurDto save(UtilisateurDto userDto) {
    	 UtilisateurDto response=new UtilisateurDto();
    	 Optional<Utilisateur> users=utilisateurRepository.findByEmail(userDto.getEmail());
    	 if (users.isPresent()) {
    		 response.setUuid(userDto.getUuid());
    		 response.setCode(350);		
    		 response.setStatut("Error");
    		 response.setTitre("Adresse emeil...");
    		 response.setDescription("Cette adresse existe déjà dans la base des données");
    		 return response;
		 } 
    	 
    	 Utilisateur utilisateur = new Utilisateur(); 
    	 utilisateur.setPassword(passwordEncoder.encode(userDto.getPassword()));
		 utilisateur.setEnabled(true);
		 utilisateur.setNonExpired(true);
		 utilisateur.setNonLocked(true);
		 utilisateur.setRoles(userDto.getRoles());
		 utilisateur.setEmail(userDto.getEmail());
		 utilisateur.setTelephone(userDto.getTelephone());
		 utilisateur.setNom(userDto.getNom());
		 utilisateur.setPrenom(userDto.getPrenom());
		 utilisateur.setOnline(false);
		 Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
		 return Mapper.toUtilisateurDto(savedUtilisateur);
    }

	@Override
	public UtilisateurDto getUtilisateurByEmail(String email) { 
		Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmail(email);
		Utilisateur utilisateur = utilisateurOptional.get();
		return Mapper.toUtilisateurDto(utilisateur);
	}

	

	@Override
	public UtilisateurDto updateUtilisateur(UtilisateurDto userDto, String uuid) {
		UtilisateurDto response=new UtilisateurDto();
   	 Optional<Utilisateur> users=utilisateurRepository.findByEmail(userDto.getEmail());
	   	 if (users.isPresent()) {
	   		 if (!users.get().getUuid().equals(uuid)) {
	   			response.setUuid(userDto.getUuid());
		   		 response.setCode(350);		
		   		 response.setStatut("Error");
		   		 response.setTitre("Adresse emeil...");
		   		 response.setDescription("Cette adresse existe déjà dans la base des données");
		   		 return response;
			}
		 }
		 Utilisateur utilisateur = new Utilisateur();
		 utilisateur.setUuid(uuid);
   	     utilisateur.setPassword(passwordEncoder.encode(userDto.getPassword()));
		 utilisateur.setEnabled(true);
		 utilisateur.setNonExpired(true);
		 utilisateur.setNonLocked(true);
		 utilisateur.setRoles(userDto.getRoles());
		 utilisateur.setEmail(userDto.getEmail());
		 utilisateur.setTelephone(userDto.getTelephone());
		 utilisateur.setNom(userDto.getNom());
		 utilisateur.setPrenom(userDto.getPrenom());
		 utilisateur.setOnline(false);
		 Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
		 return Mapper.toUtilisateurDto(savedUtilisateur);
	}

	@Override
	public void deleteUtilisateur(String uuid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UtilisateurDto getUtilisateur(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UtilisateurDto> getByUserOnLigne() {
		List<Utilisateur> liste =utilisateurRepository.getByUserOnLigne(); 
		final List<UtilisateurDto> listeDto = new ArrayList<>();
		liste.forEach(el -> listeDto.add(Mapper.toUtilisateurDto(el)));
		return listeDto;
	}

	@Override
	public List<UtilisateurDto> findAll() {
		// TODO Auto-generated method stub
		List<Utilisateur> liste =utilisateurRepository.findAll();
		final List<UtilisateurDto> listeDto = new ArrayList<UtilisateurDto>();
		liste.forEach(el -> listeDto.add(Mapper.toUtilisateurDto(el)));
		return listeDto;
	}

	@Override
	public void deconnecterUtilisateur() {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Utilisateur utilisateur = utilisateurRepository.findByEmail(auth.getName()).orElseThrow(null);
		utilisateur.setOnline(false);
		utilisateurRepository.save(utilisateur);
		
	}

	@Override
	public ChangerPasswordDto changerPassword(ChangerPasswordDto dto) {
		ChangerPasswordDto response=new ChangerPasswordDto();
		if (dto==null) {
			new ResponseDto(305, "Champs vide", "Veuillez renseigner les champs à saisie", "Errors");
			return response;
		}
		Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(dto.getEmail());
		if (!utilisateur.isPresent()) {
			new ResponseDto(305, "Compte utilisateur introuvable", "Ce compte n'a pas été trouver", "Errors");
			return response;
		}
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		if (!utilisateur.get().getEmail().equals(auth.getName())) {
			new ResponseDto(305, "Compte utilisateur", "Ce compte utilisateur ne vous appartient pas", "Errors");
			return response;
		}
		if (!dto.getNouveauPassword().equals(dto.getConfirmer())) {
			new ResponseDto(305, "Confirmation", "Mot de passe incorrect", "Errors");
			return response;
		}
		
		
		return null;
	}
}
