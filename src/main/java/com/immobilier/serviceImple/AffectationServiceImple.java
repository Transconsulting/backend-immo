package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import com.immobilier.dto.AffectationDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Affectation;
import com.immobilier.model.Agent;
import com.immobilier.model.Quartier;
import com.immobilier.repository.AffectationRepository;
import com.immobilier.repository.AgentRepository;
import com.immobilier.repository.QuartierRepository;
import com.immobilier.service.AffectationService;
 
@Service
public class AffectationServiceImple implements AffectationService {

	@Autowired
	AffectationRepository affectationRepository;
	@Autowired
	AgentRepository agentRepository;
	@Autowired
	QuartierRepository quartierRepository;
	 
	@Override
	public AffectationDto saveAffectation(AffectationDto affectationDto) {
		
		Affectation affectation = new Affectation();
		AffectationDto responseDto = new AffectationDto();
		Agent agent = agentRepository.findById(affectationDto.getUuidAgent()).orElseThrow(null);
		Optional<Quartier> quartier = quartierRepository.findById(affectationDto.getUuidQuartier());
		if(!quartier.isPresent()){	 
			responseDto.setCode(305);
			responseDto.setTitre("Quartier invalide");
			responseDto.setStatut("Error");
			responseDto.setDescription("Ce nom de quartier n'a pas été trouver dans la basse de données"); 
			responseDto.setUuid(affectationDto.getUuid());
			responseDto.setUuidQuartier(affectationDto.getUuidQuartier()); 
			return responseDto;
		}
		affectation.setQuartier(quartier.get());
		affectation.setNomClient(affectationDto.getNomClient());
		affectation.setTelClient(affectationDto.getTelClient());
		affectation.setDateAffectation(affectationDto.getDateAffectation());
		affectation.setDescripTravau(affectationDto.getDescripTravau());
		affectation.setTypeTravaux(affectationDto.getTypeTravaux());
		affectation.setAgent(agent);
		Affectation affectationSave = affectationRepository.save(affectation);
		responseDto = Mapper.toAffectationDto(affectationSave);
		responseDto.setCode(200);
		responseDto.setTitre("ENREGISTREMENT");
		responseDto.setStatut("INFORMATION");
		responseDto.setDescription(" AFFECTATION AJOUT SUCCED !");
		return responseDto;
	}

	@Override
	public AffectationDto updateAffectation(AffectationDto affectationDto, String uuid) {
		// TODO Auto-generated method stub
		Affectation affectation = new Affectation();
		AffectationDto responseDto = new AffectationDto();
		affectation = affectationRepository.findById(uuid).orElseThrow(null);
		Agent agent = agentRepository.findById(affectationDto.getUuidAgent()).orElseThrow(null);
		Optional<Quartier> quartier = quartierRepository.findById(affectationDto.getUuidQuartier());
		if(!quartier.isPresent()){	 
			responseDto.setCode(305);
			responseDto.setTitre("Quartier invalide");
			responseDto.setStatut("Error");
			responseDto.setDescription("Ce nom de quartier n'a pas été trouver dans la basse de données"); 
			responseDto.setUuid(affectationDto.getUuid());
			responseDto.setUuidQuartier(affectationDto.getUuidQuartier()); 
			return responseDto;
		}
		affectation.setQuartier(quartier.get());
		affectation.setNomClient(affectationDto.getNomClient());
		affectation.setTelClient(affectationDto.getTelClient()); 
		affectation.setDateAffectation(affectationDto.getDateAffectation());
		affectation.setDescripTravau(affectationDto.getDescripTravau());
		affectation.setTypeTravaux(affectationDto.getTypeTravaux());
		affectation.setAgent(agent);
		Affectation affectationUpdate = affectationRepository.save(affectation);
		responseDto = Mapper.toAffectationDto(affectationUpdate);
		responseDto.setCode(200);
		responseDto.setTitre("MODIFICATION");
		responseDto.setStatut("INFORMATION");
		responseDto.setDescription(" AFFECTATION UPDATE SUCCED !");
		return responseDto;
	}

	@Override
	public AffectationDto getByuuidAffectation(String uuid) {
		// TODO Auto-generated method stub
		Affectation affectation = new Affectation();
		affectation = affectationRepository.findById(uuid).orElseThrow(null);
		return Mapper.toAffectationDto(affectation);
	}

	@Override
	public void deleteAffectation(String uuid) {
		// TODO Auto-generated method stub
		affectationRepository.deleteById(uuid);
	}

	@Override
	public List<AffectationDto> findAllAffectation() {
		// TODO Auto-generated method stub
		List<Affectation> affectations = affectationRepository.findAll();
		List<AffectationDto> affectationDtos = new ArrayList<AffectationDto>();
		affectations.forEach(affectation -> affectationDtos.add(Mapper.toAffectationDto(affectation)));
		return affectationDtos;
	}

}
