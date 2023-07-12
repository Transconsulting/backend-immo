package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.immobilier.dto.IntereseDto; 
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Interese;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.model.Utilisateur;
import com.immobilier.repository.IntereseRepository; 
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.repository.UtilisateurRepository;
import com.immobilier.service.IntereseService;


@Service
public class IntereseServiseImple implements IntereseService {

	@Autowired
	private ParcelleAppartemntRepository parcelAppRepository;
	@Autowired
	private UtilisateurRepository userRepository;
	@Autowired
	private IntereseRepository intereseRepository;
	
	@Override
	public IntereseDto add(String uuidParceApp) { 
		IntereseDto response=new IntereseDto();
		if (uuidParceApp.isEmpty()) {
			response.setCode(305);
			response.setTitre("Information introuvable");
			response.setStatut("Error");
			response.setDescription("Les inforamtions non pas été trouver");
			return response;
		}  
		Optional<ParcelleAppartemnt> parcelApp= parcelAppRepository.findById(uuidParceApp);
		if (!parcelApp.isPresent()) {
			response.setCode(305);
			response.setTitre("Information introuvable");
			response.setStatut("Error");
			response.setDescription("Les inforamtions de l'appartement non pas été trouver");
			return response;
		} 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Optional<Utilisateur> user=userRepository.findByEmail(auth.getName());
		if (!user.isPresent()) {
			response.setCode(305);
			response.setTitre("Information introuvable");
			response.setStatut("Error");
			response.setDescription("vos inforamtions non pas été trouver");
			return response;
		} 
		
		if (intereseRepository.existsByParcelleAppartemntUuidAndUtilisateurUuid(uuidParceApp, user.get().getUuid())) {
			response.setCode(305);
			response.setTitre("Interesé déjà");
			response.setStatut("Error");
			response.setDescription("Interesé déjà a l'annonce");
			return response;
		}  
		Interese interese=new Interese();
		interese.setUtilisateur(user.get());
		interese.setParcelleAppartemnt(parcelApp.get()); 
		
		return Mapper.toIntereseDto(intereseRepository.save(interese));
	}

	@Override
	public void delete(String uuid) {
		IntereseDto response=new IntereseDto();
		if (uuid.isEmpty()) {
			response.setCode(305);
			response.setTitre("Information introuvable");
			response.setStatut("Error");
			response.setDescription("Les inforamtions non pas été trouver");
			return ;
		}
		intereseRepository.deleteById(uuid);
	}

	@Override
	public long totalByUuidPacelle(String uuid) { 
		if (uuid.isEmpty()) {
			return 0;
		} 
		return intereseRepository.countAllByParcelleAppartemntUuid(uuid);
	}

	@Override
	public List<IntereseDto> listeUserInterseByParcelApp(String uuid) {
			List<IntereseDto> dto=new ArrayList<IntereseDto>();
			List<Interese> interese= this.intereseRepository.findAllByParcelleAppartemntUuid(uuid);
			interese.forEach(val->{
				dto.add(Mapper.toIntereseDto(val));
			}); 
		return dto;
	}

	@Override
	public List<IntereseDto> findAll() {
		List<IntereseDto> dto=new ArrayList<IntereseDto>();
		List<Interese> interese= this.intereseRepository.findAllByOrderByDateCreatedDesc();
		interese.forEach(val->{
			dto.add(Mapper.toIntereseDto(val));
		}); 
		return dto;
	}

}
