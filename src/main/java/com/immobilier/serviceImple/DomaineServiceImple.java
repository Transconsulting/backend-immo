package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.immobilier.dto.DomaineDto;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Agent;
import com.immobilier.model.Domaine;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.model.Proprietaire;
import com.immobilier.model.Quartier;
import com.immobilier.repository.AgentRepository;
import com.immobilier.repository.DomaineRepository;
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.repository.ProprietaireRepository;
import com.immobilier.repository.QuartierRepository;
import com.immobilier.service.DomaineService;


@Service
public class DomaineServiceImple implements DomaineService{
	
	@Autowired
	DomaineRepository domaineRepository;
	@Autowired
	ProprietaireRepository proprietaireRepository;
	@Autowired
	AgentRepository agentRepository;
	@Autowired
	QuartierRepository quartierRepository;
	@Autowired
	ParcelleAppartemntRepository parcelleAppartemntRepository;

	@Override
	public DomaineDto saveDomaine(DomaineDto domaineDto) { 
				
		if(domaineDto==null){	
			domaineDto=new DomaineDto();
			domaineDto.setCode(305);
			domaineDto.setTitre("Information invalide");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Saisissez les informations du domaine");  
			return domaineDto;
		}
		Optional<Quartier> quartier = quartierRepository.findById(domaineDto.getUuidQuartier());
		if(!quartier.isPresent()){	
			domaineDto.setCode(305);
			domaineDto.setTitre("Quartier invalide");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Ce nom de quartier n'a pas été trouver dans la basse de données");  
			return domaineDto;
		}
					
		Optional<Proprietaire> proprietaire = proprietaireRepository.findById(domaineDto.getUuidProprietaire());
		if(!proprietaire.isPresent()){	
			domaineDto.setCode(305);
			domaineDto.setTitre("Propriétaire introuvable");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Ce propriétaire n'a pas été trouver dans la basse de données");  
			return domaineDto;
		}
		
		Optional<Agent> agent = agentRepository.findById(domaineDto.getUuidAgent());
		if(!agent.isPresent()){
			domaineDto.setCode(305);
			domaineDto.setTitre("Agent introuvable");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Cet agent n'a pas été trouver dans la basse de données");  
			return domaineDto;
		}
		Domaine domaine = new Domaine();
		domaine.setLibelle(domaineDto.getLibelle()); 
		domaine.setLongitude(domaineDto.getLongitude());
		domaine.setLattitude(domaineDto.getLattitude());
		domaine.setStatut(domaineDto.getStatutDomaine()); 
		domaine.setTypeAnonce(domaineDto.getTypeAnonce()); 
		domaine.setType(domaineDto.getType()); 
		domaine.setQuartier(quartier.get());
		domaine.setAgent(agent.get());
		domaine.setProprietaire(proprietaire.get());
		Domaine domaineSave=domaineRepository.save(domaine);
		domaineDto=Mapper.toDomaineDto(domaineSave);
		domaineDto.setCode(200);
		domaineDto.setTitre("Domaine enregistrer");
		domaineDto.setStatut("Success");
		domaineDto.setDescription("L'enregistrement a bien reussi."); 
		return domaineDto;
	}

	@Override
	public DomaineDto updateDomaine(DomaineDto domaineDto, String uuid) { 
				
		if(domaineDto==null){	
			domaineDto=new DomaineDto();
			domaineDto.setCode(305);
			domaineDto.setTitre("Information invalide");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Saisissez les informations du domaine");  
			return domaineDto;
		}
		Optional<Quartier> quartier = quartierRepository.findById(domaineDto.getUuidQuartier());
		if(!quartier.isPresent()){	
			domaineDto.setCode(305);
			domaineDto.setTitre("Quartier invalide");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Ce nom de quartier n'a pas été trouver dans la basse de données");  
			return domaineDto;
		}
		
		Optional<Agent> agent = agentRepository.findById(domaineDto.getUuidAgent());
		if(!agent.isPresent()){
			domaineDto.setCode(305);
			domaineDto.setTitre("Agent introuvable");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Cet agent n'a pas été trouver dans la basse de données");  
			return domaineDto;
		}
					
		Optional<Proprietaire> proprietaire = proprietaireRepository.findById(domaineDto.getUuidProprietaire());
		if(!proprietaire.isPresent()){	
			domaineDto.setCode(305);
			domaineDto.setTitre("Propriétaire introuvable");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Ce propriétaire n'a pas été trouver dans la basse de données");  
			return domaineDto;
		}
		
		Optional<Domaine> domaineOp = domaineRepository.findById(uuid);
		if(!domaineOp.isPresent()){
			domaineDto.setCode(305);
			domaineDto.setTitre("Domaine introuvable");
			domaineDto.setStatut("Error");
			domaineDto.setDescription("Le dommaine a modifié n'a pas été trouver dans la basse de données");  
			return domaineDto;
		}
		
		Domaine domaine = domaineOp.get();				
		domaine.setLibelle(domaineDto.getLibelle()); 
		domaine.setLongitude(domaineDto.getLongitude());
		domaine.setLattitude(domaineDto.getLattitude());
		domaine.setStatut(domaineDto.getStatutDomaine());
		domaine.setTypeAnonce(domaineDto.getTypeAnonce()); 
		domaine.setType(domaineDto.getType()); 
		domaine.setAgent(agent.get());
		domaine.setQuartier(quartier.get());
		domaine.setProprietaire(proprietaire.get());
		domaine = domaineRepository.save(domaine);
		domaineDto.setCode(200);
		domaineDto.setTitre("Modification du Domaine");
		domaineDto.setStatut("Success");
		domaineDto.setDescription("La modification a bien reussi."); 
		return domaineDto;
	}

	@Override
	public DomaineDto getByuuid(String uuid) {
		Optional<Domaine> domaine =domaineRepository.findById(uuid);
		if (!domaine.isPresent()) {
			return new DomaineDto();
		}
		return Mapper.toDomaineDto(domaine.get());
	}

	@Override
	public DomaineDto deleteDomaine(String uuid) { 
		DomaineDto response=new DomaineDto();
		if (uuid.trim().isEmpty()) {
			response.setCode(305);
			response.setTitre("Suppression");
			response.setStatut("Error");
			response.setDescription("L'indentifiant du domaine à supprimer n'a pas été trouver."); 
			return response;
		}
		List<ParcelleAppartemnt> appParcel=parcelleAppartemntRepository.findAllByDomaineUuid(uuid);
		if (!appParcel.isEmpty()) { 
			response.setCode(305);
			response.setTitre("Suppression impossible!");
			response.setStatut("Error");
			response.setDescription("Un domaine attaché a des habitations ne peut-être supprimer"); 
			return response;
		}
		domaineRepository.deleteById(uuid);
		response.setCode(200);
		response.setTitre("Domaine supprimer");
		response.setStatut("Success");
		response.setDescription("La suppression a bien reussi."); 
		return response; 
	}

	@Override
	public List<DomaineDto> findAllDomaine() { 
		List<Domaine> domaines = domaineRepository.findAll();
		List<DomaineDto> domaineDtos = new ArrayList<DomaineDto>();
		domaines.forEach(domaine -> domaineDtos.add(Mapper.toDomaineDto(domaine)));
		return domaineDtos;
	}

	@Override
	public List<DomaineDto> findAllByProprietaireUuid(String uuidProprietaire) {
		List<Domaine> liste = domaineRepository.findAllByProprietaireUuid(uuidProprietaire);
		final List<DomaineDto> listeDto = new ArrayList<>();
		liste.forEach(el -> listeDto.add(Mapper.toDomaineDto(el)));
		return listeDto;
	}

	@Override
	public List<DomaineDto> findAllByStatutAndProprietaire(StatutDomaine statut, String uuidProprietaire) {
		List<Domaine> liste = domaineRepository.findAllByStatutAndProprietaireUuid(statut,uuidProprietaire);
		final List<DomaineDto> listeDto = new ArrayList<>();
		liste.forEach(el -> listeDto.add(Mapper.toDomaineDto(el)));
		return listeDto;
	}

	@Override
	public List<DomaineDto> findAllByStatut(StatutDomaine statut) {
		List<Domaine> liste = domaineRepository.findAllByStatut(statut);
		final List<DomaineDto> listeDto = new ArrayList<>();
		liste.forEach(el -> listeDto.add(Mapper.toDomaineDto(el)));
		return listeDto;
	}

	@Override
	public DomaineDto statutDomaine(StatutDomaine statut,String uuidDommaine){
		DomaineDto response=new DomaineDto();  
		if (StatutDomaine.AUCUN!=statut && StatutDomaine.ANNONCE!=statut ) {
			response.setCode(305);
			response.setTitre("Modification du statut");
			response.setStatut("Error");
			response.setDescription("Le statut du domaine ne peut être : Aucun ou une Annoce");
			return response;
		}
		
		Optional<Domaine> domaineOp=domaineRepository.findById(uuidDommaine); 
		Domaine domaine=new Domaine();
		if (domaineOp.isPresent()) { 
			domaine=domaineOp.get();
			domaine.setStatut(statut);
			domaineRepository.save(domaine);
		}
		response=Mapper.toDomaineDto(domaine);
		response.setCode(200);
		response.setTitre("Modification du statut");
		response.setStatut("Success");
		response.setDescription("Le statut du domaine a été modifier avec succès"); 
		return response;
	}

}
