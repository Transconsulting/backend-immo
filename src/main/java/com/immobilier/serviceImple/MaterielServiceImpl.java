package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.immobilier.dto.MaterielDto;
import com.immobilier.mapper.Mapper; 
import com.immobilier.model.Materiel; 
import com.immobilier.repository.MaterielRepository; 
import com.immobilier.service.MaterielService;

@Service
public class MaterielServiceImpl implements MaterielService{
	
	@Autowired
	private MaterielRepository materielRepository;

	@Override
	public MaterielDto add(MaterielDto dto) { 
		MaterielDto response=new MaterielDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Information du materiel");
			response.setStatut("Error");
			response.setDescription("Veuillez entrer les caractéristique du matériel");
			return response;
		} 
		
		Materiel materiel=materielRepository.findByLibelle(dto.getLibelle());
		
		if (materiel!=null) {
			response=Mapper.toMaterielDto(materiel);
			response.setUuid(materiel.getUuid());
			response.setCode(305);
			response.setTitre("Nom du materiel...");
			response.setStatut("Error");
			response.setDescription("Ce matériel existe déjà dans la base des données");
			return response;
		}
		
		materiel=materielRepository.save(Mapper.toMateriel(dto));
		response=Mapper.toMaterielDto(materiel);
		response.setCode(200);
		response.setTitre("Enregistrement");
		response.setDescription("L'enregistrement a bien reussi!");
		response.setStatut("Success");
		
		return response;
	}

	@Override
	public MaterielDto update(MaterielDto dto, String uuid) {
		Materiel materiel=new Materiel();
		MaterielDto response=new MaterielDto();
		try {
			if (uuid.isEmpty()) {
				response.setTitre("Indentifiant...");
				response.setCode(305);
				response.setStatut("Error");
				response.setDescription("L'identifiant du matériel ne peut pas être null!");  
				return response;
			}
			dto.setUuid(uuid);
			materiel=materielRepository.save(Mapper.toMateriel(dto));
			response=Mapper.toMaterielDto(materiel);
			response.setTitre("Modification...");
			response.setCode(200);
			response.setStatut("Success");
			response.setDescription("La modification a bien reussi!");  
			return response;
		} catch (Exception e) { 
			response.setCode(305);
			response.setTitre("Error internal");
			response.setStatut("Error");
			response.setDescription(e.getMessage());  
			return response;
		}
	}

	@Override 
	public List<MaterielDto> findAll() { 
		List<Materiel> liste = materielRepository.findAll();
		final List<MaterielDto> clientDtos = new ArrayList<>();
		liste.forEach(el -> clientDtos.add(Mapper.toMaterielDto(el)));
		return clientDtos;
	}

	@Override
	public MaterielDto getByUuid(String uuid) { 
		MaterielDto response=new MaterielDto();
		Materiel materiel = materielRepository.getById(uuid);
		if (materiel==null) {
			response.setCode(305);
			response.setTitre("Indentifiant");
			response.setStatut("Error");
			response.setDescription("Ce materiel n'a pas été trouver...");
			return response;
		}  
		response=Mapper.toMaterielDto(materiel);
		response.setCode(200); 
		return response; 
	}

	@Override
	public void delete(String uuid) { 
		materielRepository.deleteById(uuid);
	}
}
