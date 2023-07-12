package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.immobilier.dto.ModePaiementDto;
import com.immobilier.mapper.Mapper; 
import com.immobilier.model.ModePaiement;
import com.immobilier.repository.ModePaiementRepository;
import com.immobilier.service.ModePaiementService; 

@Service
public class ModePaiementServiceImple implements ModePaiementService {

	@Autowired
	ModePaiementRepository modePaiementRepository;
	@Override
	public ModePaiementDto add(ModePaiementDto dto) {
		ModePaiementDto response=new ModePaiementDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Mode de paiement");
			response.setStatut("Error");
			response.setDescription("Veuillez entrer le mode de paiement");
			return response;
		}
		ModePaiement mp=modePaiementRepository.findByLibelle(dto.getLibelle());
		if (mp!=null) {
			response.setCode(305);
			response.setTitre("Mode de paiement");
			response.setStatut("Error");
			response.setDescription("Ce mode de paiement a été déjà ajouter");
			return response;
		}
		mp=new ModePaiement();
		mp.setLibelle(dto.getLibelle()); 
		mp=modePaiementRepository.save(mp);
		
		response.setUuid(mp.getUuid());
		response.setLibelle(dto.getLibelle());
		response.setCode(200);
		response.setTitre("Mode de paiement");
		response.setStatut("Success");
		response.setDescription("Le nouveau mode de paiement a été ajouter");
		return response;
	}

	@Override
	public ModePaiementDto update(ModePaiementDto dto, String uuid) {
		ModePaiementDto response=new ModePaiementDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Mode de paiement");
			response.setStatut("Error");
			response.setDescription("Veuillez entrer le mode de paiement");
			return response;
		}
		Optional<ModePaiement> mpOp=modePaiementRepository.findById(uuid);
		if (!mpOp.isPresent()) {
			response.setCode(305);
			response.setTitre("Mode de paiement");
			response.setStatut("Error");
			response.setDescription("Ce mode de paiement n'a pas été trouver dans la base de données");
			return response;
		}
		
		ModePaiement mp=mpOp.get();
		mp.setUuid(uuid);
		mp.setLibelle(dto.getLibelle()); 
		modePaiementRepository.save(mp);
		
		response.setUuid(uuid);
		response.setLibelle(dto.getLibelle());
		response.setCode(200);
		response.setTitre("Mode de paiement");
		response.setStatut("Success");
		response.setDescription("La modification a bien reusi");
		return response;
	}

	@Override
	public List<ModePaiementDto> findAll() {
		List<ModePaiement> liste = modePaiementRepository.findAll();  
		List<ModePaiementDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toModePaiementDTO(el)));
		return listeDTO;
	}

	@Override
	public ModePaiementDto getByUuid(String uuid) {
		Optional<ModePaiement> cmd = modePaiementRepository.findById(uuid);
		if (!cmd.isPresent()) {
			return new ModePaiementDto();
		}
		return Mapper.toModePaiementDTO(cmd.get());
	}

	@Override
	public void delete(String uuid) {
		
	}

}
