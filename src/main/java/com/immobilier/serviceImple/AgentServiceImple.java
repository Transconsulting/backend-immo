package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 

import com.immobilier.dto.AgentDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Agent;
import com.immobilier.model.Profession;
import com.immobilier.model.Quartier;
import com.immobilier.repository.AgentRepository;
import com.immobilier.repository.QuartierRepository;
import com.immobilier.repository.ProfessionRepository;
import com.immobilier.service.AgentService;
 
@Service
public class AgentServiceImple implements AgentService {

	@Autowired
	AgentRepository agentRepository;
	@Autowired
	QuartierRepository quartierRepository;
	@Autowired
	ProfessionRepository professionRepository;

	@Override
	public AgentDto saveAgent(AgentDto agentDto) { 
		AgentDto resonsedto = new AgentDto();
		if(agentDto==null) {
			resonsedto.setCode(305);
			resonsedto.setTitre("CONTROLE DE SAISIE");
			resonsedto.setStatut("Error");
			resonsedto.setDescription(" VEUILLEZ SAISIR LES INFORMATION AGENT !");
			return resonsedto;
		}
		Agent agent = agentRepository.findByTel(agentDto.getTel());
		if(agent!=null){	 
			resonsedto.setCode(305);
			resonsedto.setTitre("CONTROLE DOUBLON");
			resonsedto.setStatut("Error");
			resonsedto.setDescription("CE NUMERO TELEPHONE AGENT EXISTE DEJA !");
			resonsedto.setUuid(agent.getUuid());
			resonsedto.setNom(agent.getNom());
			resonsedto.setPrenoms(agent.getPrenoms()); 
			resonsedto.setTel(agent.getTel());
			return resonsedto;
		}
		
		Optional<Quartier> quartier = quartierRepository.findById(agentDto.getUuidQuartier());
		if(!quartier.isPresent()){	 
			resonsedto.setCode(305);
			resonsedto.setTitre("Quartier invalide");
			resonsedto.setStatut("Error");
			resonsedto.setDescription("Ce nom de quartier n'a pas été trouver dans la basse de données"); 
			resonsedto.setUuid(agentDto.getUuid());
			resonsedto.setUuidQuartier(agentDto.getUuidQuartier()); 
			return resonsedto;
		}
		
		Optional<Profession> profession = professionRepository.findById(agentDto.getUuidProfession());
		if(!quartier.isPresent()){
			resonsedto.setCode(305);
			resonsedto.setTitre("Profession Introuvable");
			resonsedto.setStatut("Error");
			resonsedto.setDescription("Le profession n'a pas été trouver dans la basse de données");  
			resonsedto.setUuidQuartier(agentDto.getUuidProfession()); 
			return resonsedto;
		}
					
		agent = new Agent();
		agent.setNom(agentDto.getNom());
		agent.setPrenoms(agentDto.getPrenoms()); 
		agent.setTel(agentDto.getTel()); 
		agent.setProfession(profession.get());
		agent.setType(agentDto.getType());
		agent.setQuartier(quartier.get());
		
		Agent agentSave=agentRepository.save(agent);
		
		resonsedto=Mapper.toAgentDto(agentSave);
		resonsedto.setCode(200);
		resonsedto.setTitre("ENREGISTREMENT");
		resonsedto.setStatut("INFORMATION");
		resonsedto.setDescription(" AGENT AJOUT SUCCED !");
		return resonsedto;
	}

	@Override
	public AgentDto updateAgent(AgentDto agentDto, String uuid) { 
		AgentDto responseDto = new AgentDto(); 
		Agent agent=new Agent();
		
		Optional<Agent> agentFind = agentRepository.findById(uuid);
		if(!agentFind.isPresent()){	 
			responseDto.setCode(305);
			responseDto.setTitre("Agent invalide");
			responseDto.setStatut("Error");
			responseDto.setDescription("cet agent n'a pas été trouver dans la base de données"); 
			responseDto.setUuid(uuid);
			responseDto.setUuidQuartier(agentDto.getUuidQuartier()); 
			return responseDto;
		}
		
		Optional<Quartier> quartier = quartierRepository.findById(agentDto.getUuidQuartier());
		if(!quartier.isPresent()){	 
			responseDto.setCode(305);
			responseDto.setTitre("Quartier invalide");
			responseDto.setStatut("Error");
			responseDto.setDescription("Ce nom de quartier n'a pas été trouver dans la basse de données"); 
			responseDto.setUuid(uuid);
			responseDto.setUuidQuartier(agentDto.getUuidQuartier()); 
			return responseDto;
		}
		
		Optional<Profession> profession = professionRepository.findById(agentDto.getUuidProfession());
		if(!quartier.isPresent()){
			responseDto.setCode(305);
			responseDto.setTitre("Profession Introuvable");
			responseDto.setStatut("Error");
			responseDto.setDescription("Le profession n'a pas été trouver dans la basse de données");  
			responseDto.setUuidQuartier(agentDto.getUuidProfession()); 
			return responseDto;
		}
		
		agent=agentFind.get();
		agent.setNom(agentDto.getNom());
		agent.setPrenoms(agentDto.getPrenoms());
		agent.setTel(agentDto.getTel());
		agent.setProfession(profession.get());
		agent.setType(agentDto.getType());
		agent.setQuartier(quartier.get());
		
		Agent agentUpdate = agentRepository.save(agent);
		
		responseDto = Mapper.toAgentDto(agentUpdate);
		responseDto.setCode(200);
		responseDto.setTitre("MODIFICATION");
		responseDto.setStatut("INFORMATION");
		responseDto.setDescription(" AGENT UPDATE SUCCED !");
		return responseDto;
	}

	@Override
	public AgentDto getByuuid(String uuid) { 
		Agent agent = new Agent();
		agent=agentRepository.findById(uuid).orElseThrow(null);
		return Mapper.toAgentDto(agent);
	}

	@Override
	public void deleteAgent(String uuid) { 
		agentRepository.deleteById(uuid);
	}

	@Override
	public List<AgentDto> findAllAgent() { 
		List<Agent> agents = agentRepository.findAll();
		List<AgentDto> agentDtos= new ArrayList<AgentDto>();
		agents.forEach(agent -> agentDtos.add(Mapper.toAgentDto(agent)));
		return agentDtos;
	}

	@Override
	public long getTotalAgent() { 
		return  agentRepository.count();
	}

}
