package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.immobilier.dto.ContratDto;
import com.immobilier.dto.PaiementContratDto;
import com.immobilier.enumeration.StatutDomaine;
import com.immobilier.enumeration.TypeContrat; 
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Client;
import com.immobilier.model.Contrat;
import com.immobilier.model.ContratDetail;
import com.immobilier.model.ParcelleAppartemnt;
import com.immobilier.repository.ClientRepository;
import com.immobilier.repository.ContratDetailRepository;
import com.immobilier.repository.ContratRepository;
import com.immobilier.repository.ParcelleAppartemntRepository;
import com.immobilier.service.ContratService;
import com.immobilier.service.PaiementContratService; 

@Service
public class ContratServiceImple implements ContratService {
	
	@Autowired
	ContratRepository contratRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	ContratDetailRepository contratDetailRepository;
	@Autowired 
	ParcelleAppartemntRepository parcelleAppRepository;
	@Autowired
	private PaiementContratService paiementContratService; 

	@Override
	public ContratDto add(ContratDto dto) {
		ContratDto response=new ContratDto(); 
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Information du contrat");
			response.setStatut("Error");
			response.setDescription("Veuillez entrer les informations du contrat");
			return response;
		} 
		
		Client client=clientRepository.getById(dto.getUuidClient()); 
		if (client==null) {
			response.setCode(305);
			response.setTitre("Client introuvable..."); 
			response.setStatut("Error");
			response.setDescription("Ce client n'a pas été trouver dans la base des données");
			return response;
		} 
		
		dto.setStatutContrat(true);
		//TODO Enregistrer le contrat
		Contrat contrat=contratRepository.save(Mapper.toContrat(dto,client));
		
		//TODO Enregistrer les appartements lié au contrat 
		if (dto.getListeContratDetailsDTO()!=null) {
			dto.getListeContratDetailsDTO().forEach(val->{
				//TODO Verifier l'existance des appartements concerner
				Optional<ParcelleAppartemnt> parcelleAppartemnt=parcelleAppRepository.findById(val.getUuidParcelApp());
				if (parcelleAppartemnt.isPresent()) {
					ContratDetail detail=Mapper.toContratDetail(val, contrat,parcelleAppartemnt.get());  
					contratDetailRepository.save(detail);
				} 
			});
		} 
		response=Mapper.toContratDTO(contrat);
		response.setCode(200);
		response.setTitre("Enregistrement");
		response.setDescription("L'enregistrement a bien reussi!");
		response.setStatut("Success");  
		return response;
	}

	@Override
	public ContratDto update(ContratDto dto, String uuid) {
		ContratDto response=new ContratDto();
		if (dto==null || uuid.isEmpty()) {
			response.setCode(305);
			response.setTitre("Information du contrat");
			response.setStatut("Error");
			response.setDescription("Veuillez entrer les informations du contrat");
			response.setUuid(uuid);
			return response;
		}
		
		Contrat contrat=contratRepository.getById(uuid);
		if (contrat==null) {
			response.setCode(305);
			response.setTitre("Information du contrat");
			response.setStatut("Error");
			response.setDescription("Ce contrat n'a pas été trouver dans la base des données");
			response.setUuid(uuid);
			return response;
		}
		if (!contrat.isStatutContrat()) {
			response.setCode(305);
			response.setTitre("Contrat cloturer...");
			response.setStatut("Error");
			response.setDescription("Un contrat cloturé ne pas être modifier");
			return response;
		} 
		
		Client client=clientRepository.getById(dto.getUuidClient());
		if (client==null) {
			response.setCode(305);
			response.setTitre("Client introuvable...");
			response.setStatut("Error");
			response.setDescription("Ce client n'a pas été trouver dans la base des données");
			return response;
		}
		
		
		//TODO Enregistrer le contrat
		dto.setUuid(uuid);
		contrat=contratRepository.save(Mapper.toContrat(dto,client));
		/**
		//TODO Supprimer d'abort les anciens apartement avant d'affecter les nouveaux
		 contratDetailRepository.deleteByUuidContrat(contrat.getUuid());
		//TODO Enregistrer les appartements lié au contrat 
		if (dto.getListeContratDetailsDTO()!=null) {
			dto.getListeContratDetailsDTO().forEach(val->{
				//TODO Verifier l'existance des appartements concerner
				ParcelleAppartemnt parcelleAppartemnt=parcelleAppRepository.getById(val.getUuidParcelApp());
				if (parcelleAppartemnt!=null) {
					ContratDetail detail=Mapper.toContratDetail(val, contrat,parcelleAppartemnt);  
					contratDetailRepository.save(detail);
				} 
			});
		} 
		*/
		response=Mapper.toContratDTO(contrat);
		response.setCode(200);
		response.setTitre("Modification");
		response.setDescription("La modification a bien reussi!");
		response.setStatut("Success");  
		return response;
	}

	@Override
	public List<ContratDto> findAll() {
		List<Contrat> liste = contratRepository.findAll();  
		List<ContratDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toContratDTO(el)));
		return listeDTO;
	}

	@Override
	public ContratDto getByUuid(String uuid) {
		Contrat contrat=contratRepository.getById(uuid);
		return Mapper.toContratDTO(contrat);
	}

	@Override
	public ContratDto delete(String uuid) {
		ContratDto response=new ContratDto();
		if (uuid.isEmpty()) {
			response.setTitre("Suppression...");
			response.setDescription("La suppression a échoué!");
			response.setCode(350);
			response.setStatut("Error");  
			return response;
		} 
		
		Contrat contrat=contratRepository.getById(uuid);
		if (contrat==null) {
			response.setTitre("Suppression...");
			response.setDescription("Le contrat à supprimer n'a pas été trouver!");
			response.setCode(350);
			response.setStatut("Error"); 
			return response;
		} 
		//TODO Effectuer l'action de su
		contratDetailRepository.deleteByUuidContrat(uuid);
		contratRepository.deleteById(uuid);
		
		response.setTitre("Suppression...");
		response.setDescription("Le contrat a été bien supprimer!");
		response.setCode(200);
		response.setStatut("Success"); 
		return response;
	}

	
	@Override
	public List<ContratDto> findAllByClientUuid(String uuidClient) {
		List<Contrat> liste = contratRepository.findAllByClientUuid(uuidClient);  
		List<ContratDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toContratDTO(el)));
		return listeDTO;
	}

	@Override
	public ContratDto validerAvance(PaiementContratDto dto,String uuidContrat) { 
		if (uuidContrat.isEmpty()) {
			return null;
		}
		
		Contrat contrat=contratRepository.getById(uuidContrat);
		if (contrat!=null) { 
			dto.setUuidContrat(contrat.getUuid());
			paiementContratService.add(dto); 
			contrat.setEtatAvance(true);
			contratRepository.save(contrat);
		}
		return Mapper.toContratDTO(contrat);
	}

	@Override
	public ContratDto cloturer(String uuidContrat) {
		ContratDto response=new ContratDto();
		if (uuidContrat.isEmpty()) {
			response.setTitre("Fermeture de contrat...");
			response.setDescription("La fermeture a échoué!");
			response.setCode(350);
			response.setStatut("Error");  
			return response;
		}
		
		Optional<Contrat> contratOp=contratRepository.findById(uuidContrat);
		if (!contratOp.isPresent()) {
			response.setCode(305);
			response.setTitre("Information du contrat");
			response.setStatut("Error");
			response.setDescription("Le contrat a fermé n'a pas été trouver dans la base des données");
			return response;
		}
		if (contratOp.get().getTypeContrat().equals(TypeContrat.VENTE)) {
			response.setCode(305);
			response.setTitre("Contrat de vente");
			response.setStatut("Error");
			response.setDescription("Impossible de fermer un contrat de vente");
			return response;
		}
		
		List<ContratDetail> contratDetail=contratDetailRepository.getDetailByContrat(uuidContrat);
		if (contratDetail.isEmpty()) {
			response.setCode(305);
			response.setTitre("Détails du contrat");
			response.setStatut("Error");
			response.setDescription("Aucun detail n'a été trouver pour ce contrat");
			return response;
		} 
		 
		contratOp.get().setStatutContrat(false);
		contratRepository.save(contratOp.get());
		
		contratDetail.forEach(val->{
			ParcelleAppartemnt app=parcelleAppRepository.getById(val.getParcelleAppartemnt().getUuid());
			app.setStatut(StatutDomaine.AUCUN);
			parcelleAppRepository.save(app);
		});
		
		return Mapper.toContratDTO(contratOp.get());
	}
}
