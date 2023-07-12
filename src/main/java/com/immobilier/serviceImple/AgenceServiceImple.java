package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.immobilier.dto.AgenceDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Agence;
import com.immobilier.repository.AgenceRepository;
import com.immobilier.service.AgenceService;
 
@Service
public class AgenceServiceImple implements AgenceService {

	@Autowired
	AgenceRepository agenceRepository;
	
	@Override
	public AgenceDto saveAgence(AgenceDto agenceDto) {
		// TODO Auto-generated method stub
		AgenceDto responsedto = new AgenceDto();
		Agence agence = new Agence();
		agence.setNomAgence(agenceDto.getNomAgence());
		agence.setTel(agenceDto.getTel());
		agence.setAddress(agenceDto.getAddress());
		agence.setMail(agenceDto.getMail());
	//	agence.setLogo(agenceDto.getLogo());
		Agence agenceSave = agenceRepository.save(agence);
		responsedto=Mapper.toAgenceDto(agenceSave);
		responsedto.setCode(200);
		responsedto.setTitre("ENREGISTREMENT");
		responsedto.setStatut("INFORMATION");
		responsedto.setDescription(" AGENCE AJOUT SUCCED !");
		return responsedto;
	}

	@Override
	public AgenceDto updateAgence(AgenceDto agenceDto, String uuid) {
		// TODO Auto-generated method stub
		AgenceDto responsedto = new AgenceDto();
		Agence agence = new Agence();
		agence = agenceRepository.findById(uuid).orElseThrow(null);
		agence.setNomAgence(agenceDto.getNomAgence());
		agence.setTel(agenceDto.getTel());
		agence.setAddress(agenceDto.getAddress());
		agence.setMail(agenceDto.getMail());
		//agence.setLogo(agenceDto.getLogo());
		Agence agenceUpdate = agenceRepository.save(agence);
		responsedto=Mapper.toAgenceDto(agenceUpdate);
		responsedto.setCode(200);
		responsedto.setTitre("Modification");
		responsedto.setStatut("INFORMATION");
		responsedto.setDescription(" AGENCE UPDATE SUCCED !");
		return responsedto;
	}

	@Override
	public AgenceDto getByuuidAgence(String uuid) {
		// TODO Auto-generated method stub
		Agence agence = new Agence();
		agence = agenceRepository.findById(uuid).orElseThrow(null);
		return Mapper.toAgenceDto(agence);
	}

	@Override
	public void deleteAgence(String uuid) {
		// TODO Auto-generated method stub
		agenceRepository.deleteById(uuid);
	}

	@Override
	public List<AgenceDto> findAllAgence() {
		// TODO Auto-generated method stub
		List<Agence> agences = agenceRepository.findAll();
		List<AgenceDto> agenceDtos = new ArrayList<AgenceDto>();
		agences.forEach(agence -> agenceDtos.add(Mapper.toAgenceDto(agence)));
		return agenceDtos;
	}

}
