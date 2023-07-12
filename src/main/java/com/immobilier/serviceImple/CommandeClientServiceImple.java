package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
  
import com.immobilier.dto.DetailCommandeClientDto;
import com.immobilier.dto.CommandeClientDto; 
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Client;
import com.immobilier.model.CommandeClient; 
import com.immobilier.model.DetailCommandeClient;
import com.immobilier.model.Materiel; 
import com.immobilier.repository.ClientRepository;
import com.immobilier.repository.CommandeClientRepository; 
import com.immobilier.repository.DetailCommandeClientRepository;
import com.immobilier.repository.MaterielRepository; 
import com.immobilier.service.CommandeClientService; 

@Service
public class CommandeClientServiceImple implements CommandeClientService {
	
	@Autowired
	CommandeClientRepository commandeClientRepository;
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	MaterielRepository materielRepository; 
	@Autowired
	DetailCommandeClientRepository detailCommandeClientRepository;

	@Override
	public CommandeClientDto add(CommandeClientDto dto) { 
		CommandeClientDto response=new CommandeClientDto(); 
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Detail de la commande");
			response.setStatut("Error");
			response.setDescription("Veuillez choissir les produits pour le client");
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
		//TODO Enregistrer la commande
		CommandeClient commandeClient=commandeClientRepository.save(Mapper.toCommandeClient(dto,client));
		 //TODO Enregistrer les produits lié a la commande
		dto.getListDetailCommandeDto().forEach(val->{
			//TODO Verifier l'existance des appartements concerner
			Materiel materiel=materielRepository.getById(val.getUuidMateriel());
			if (materiel!=null) {
				DetailCommandeClient detail=Mapper.toDetailCommandeClient(val, commandeClient, materiel);  
				detailCommandeClientRepository.save(detail);
			} 
		});
		response=Mapper.toCommandeClientDto(commandeClient);
		response.setCode(200);
		response.setTitre("Enregistrement");
		response.setDescription("L'enregistrement de la commande a bien reussi!");
		response.setStatut("Success");  
		return response;
	}

	@Override
	public CommandeClientDto update(CommandeClientDto dto, String uuid) {
		CommandeClientDto response=new CommandeClientDto(); 
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Detail de la commande");
			response.setStatut("Error");
			response.setDescription("Veuillez choissir les produits pour la commande");
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
		
		//TODO Enregistrer la commande
	    CommandeClient commandeClient=commandeClientRepository.save(Mapper.toCommandeClient(dto,client));
				
		//TODO Supprimer d'abort les anciens produit avant d'affecter les nouveaux
		 detailCommandeClientRepository.deleteDetailCommandeByIdCmd(commandeClient.getUuid());
		 //TODO Enregistrer les produits lié a la commande
			dto.getListDetailCommandeDto().forEach(val->{
				//TODO Verifier l'existance des appartements concerner
				Materiel materiel=materielRepository.getById(val.getUuidMateriel());
				if (materiel!=null) {
					DetailCommandeClient detail=Mapper.toDetailCommandeClient(val, commandeClient, materiel);  
					detailCommandeClientRepository.save(detail);
				} 
			});
		response=Mapper.toCommandeClientDto(commandeClient);
		response.setCode(200);
		response.setTitre("Enregistrement");
		response.setDescription("L'enregistrement de la commande a bien reussi!");
		response.setStatut("Success");  
		return response;
	}

	@Override
	public List<CommandeClientDto> findAll() {
		List<CommandeClient> liste = commandeClientRepository.findAll();  
		List<CommandeClientDto> listeDTO = new ArrayList<>();
		liste.forEach(el -> listeDTO.add(Mapper.toCommandeClientDto(el)));
		return listeDTO;
	}

	@Override
	public CommandeClientDto findByUuid(String uuid) {
		CommandeClient commandeClient=commandeClientRepository.getById(uuid);
		return Mapper.toCommandeClientDto(commandeClient);
	}

	@Override
	public CommandeClientDto findByNumFacture(String numero) {
		Optional<CommandeClient> commandeClient=commandeClientRepository.findCommandeClientByNumCmd(numero);
		return Mapper.toCommandeClientDto(commandeClient.get());
	}

	
	@Override
	public CommandeClientDto delete(String uuid) {
		CommandeClientDto response=new CommandeClientDto();
		if (uuid.isEmpty()) {
			response.setTitre("Suppression...");
			response.setDescription("La suppression a échoué!");
			response.setCode(350);
			response.setStatut("Error");  
			return response;
		} 
		
		CommandeClient commandeClient=commandeClientRepository.getById(uuid);
		if (commandeClient==null) {
			response.setTitre("Suppression...");
			response.setDescription("La commande à supprimer n'a pas été trouver!");
			response.setCode(350);
			response.setStatut("Error"); 
			return response;
		} 
		//TODO Effectuer l'action de suppression
		detailCommandeClientRepository.deleteDetailCommandeByIdCmd(uuid);
		commandeClientRepository.deleteById(uuid);
		
		response.setTitre("Suppression...");
		response.setDescription("Le contrat a été bien supprimer!");
		response.setCode(200);
		response.setStatut("Success"); 
		return response;
	}

	
	@Override
	public List<DetailCommandeClientDto> getDetailCommandeClient(String uuidCmd) {
		List<DetailCommandeClient> liste = detailCommandeClientRepository.getDetailCommandeByIdCmd(uuidCmd);
		List<DetailCommandeClientDto> listeDto = new ArrayList<>();
		liste.forEach(val -> listeDto.add(Mapper.toDetailCommandeClientDto(val)));
		return listeDto;
	}

}
