package com.immobilier.serviceImple;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.immobilier.dto.ClientDto;
import com.immobilier.mapper.Mapper;
import com.immobilier.model.Client;
import com.immobilier.repository.ClientRepository;
import com.immobilier.repository.ContratRepository;
import com.immobilier.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepos;
	@Autowired
	private  ContratRepository contratRepository;

	@Override
	public ClientDto add(ClientDto dto) { 
		ClientDto response=new ClientDto();
		if (dto==null) {
			response.setCode(305);
			response.setTitre("Information du client");
			response.setStatut("Error");
			response.setDescription("Veuillez entrer les informations du client");
			return response;
		}
		
		Client client=clientRepos.findByTelephone(dto.getTelephone());
		
		if (client!=null) { 
			response.setCode(305);
			response.setTitre("Numéro de téléphone...");
			response.setStatut("Error");
			response.setDescription("Ce numéro de téléphone existe déjà dans la base des données");
			return response;
		}
		client=clientRepos.save(Mapper.toClient(dto));
		response=Mapper.toClientDTO(client);
		response.setCode(200);
		response.setTitre("Enregistrement");
		response.setDescription("L'enregistrement a bien reussi!");
		response.setStatut("Success");
		
		return response;
	}

	@Override
	public ClientDto update(ClientDto dto, String uuid) {
		Client client=new Client();
		ClientDto response=new ClientDto();
		
		if (uuid.isEmpty()) {
			response.setTitre("Indentifiant...");
			response.setCode(305);
			response.setStatut("Error");
			response.setDescription("L'identifiant client ne peut pas être null!");  
			return response;
		}
				
		Optional<Client> clientOp=clientRepos.findById(uuid);
		if (!clientOp.isPresent()) {
			response.setTitre("Client introuvable...");
			response.setCode(305);
			response.setStatut("Error");
			response.setDescription("Le client n'a pas été dans la base de données");  
			return response;
		}
		
		dto.setUuid(uuid);
		client=clientOp.get();
		client=Mapper.toClient(dto); 
		response=Mapper.toClientDTO(clientRepos.save(client));
		response.setCode(200);
		response.setTitre("Modification...");
		response.setStatut("Success");
		response.setDescription("La modification a bien reussi!");
		return response; 
	}

	@Override 
	public List<ClientDto> findAll() { 
		List<Client> client = clientRepos.findAll();
		final List<ClientDto> clientDtos = new ArrayList<ClientDto>();
		client.forEach(el -> clientDtos.add(Mapper.toClientDTO(el)));
		return clientDtos;
	}

	@Override
	public ClientDto getByUuid(String uuid) { 
		ClientDto response=new ClientDto();
		Optional<Client> client = clientRepos.findById(uuid);
		if (client.isPresent()) { 
			return new ClientDto();
		}  
		response=Mapper.toClientDTO(client.get()); 
		return response; 
	}

	@Override
	public ClientDto delete(String uuid) { 
		ClientDto response=new ClientDto();
		if (!contratRepository.findAllByClientUuid(uuid).isEmpty()) {
			response.setCode(305);
			response.setTitre("Suppression Impossible...");
			response.setStatut("Error");
			response.setDescription("Impossible de supprimer un client qui a déjà éffectué un contrat!");
			return response;
		}
		clientRepos.deleteById(uuid);
		response.setCode(200);
		response.setTitre("Suppression...");
		response.setStatut("Success");
		response.setDescription("La suppression a bien reussi");
		return response;
	}

	@Override
	public long getTotalClient() { 
		return clientRepos.count();
	}
}
