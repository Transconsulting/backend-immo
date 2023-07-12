package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.immobilier.dto.ProfessionDto; 
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Profession; 
import com.immobilier.repository.ProfessionRepository;
import com.immobilier.service.ProfessionService;

@Service
public class ProfessionServiceImple implements ProfessionService {

	@Autowired
	private ProfessionRepository professionRepository;
	
	@Override
	public ProfessionDto add(ProfessionDto dto) { 
		ProfessionDto response=new ProfessionDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Information");
			response.setStatut("Error");
			response.setDescription("Saisissez la profession");
			return response;
		}
		Profession profession=professionRepository.findByLibelle(dto.getLibelle());
		if (profession!=null) {
			response.setCode(305);
			response.setTitre("Profession existe");
			response.setStatut("Error");
			response.setDescription("La profession a été déjà ajouter");
			return response;
		}
				
		response= Mapper.toProfessionDto(professionRepository.save(Mapper.toProfession(dto)));
		response.setCode(200);
		response.setTitre("Profession");
		response.setStatut("Success");
		response.setDescription("La profession à été bien enregistrer");
		return response;
	}

	@Override
	public ProfessionDto update(ProfessionDto dto, String uuid) { 
		ProfessionDto response=new ProfessionDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Information");
			response.setStatut("Error");
			response.setDescription("Saisissez la profession");
			return response;
		}
		Optional<Profession> profession=professionRepository.findById(uuid);
		if (profession==null) {
			response.setCode(305);
			response.setTitre("Profession introuvable");
			response.setStatut("Error");
			response.setDescription("La profession n'a pas été trouver dans base de données");
			return response;
		} 
		dto.setUuid(uuid);
		response= Mapper.toProfessionDto(professionRepository.save(Mapper.toProfession(dto)));
		response.setCode(200);
		response.setTitre("Profession");
		response.setStatut("Success");
		response.setDescription("La profession à été bien enregistrer");
		return response;  
	}

	@Override
	public List<ProfessionDto> findAll() {
		List<Profession> profession = professionRepository.findAll();
		List<ProfessionDto> professionDto = new ArrayList<>();
		profession.forEach(val -> professionDto.add(Mapper.toProfessionDto(val)));
		return professionDto;
	}

	@Override
	public ProfessionDto getByUuid(String uuid) { 
		Optional<Profession> profession = professionRepository.findById(uuid);
		if (!profession.isPresent()) {
			return new ProfessionDto();
		} 
		return Mapper.toProfessionDto(profession.get());
	}

	@Override
	public void delete(String uuid) { 
		
	}

}
