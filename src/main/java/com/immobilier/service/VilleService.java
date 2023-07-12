package com.immobilier.service;

import java.util.List;
 
import com.immobilier.dto.VilleDto;
 

public interface VilleService {

	public VilleDto addVille(VilleDto villedto); 
	public VilleDto updateVille(VilleDto villedto,String uuid);
	public List<VilleDto> findAllVille();
	public VilleDto getByUuid(String uuid);
	void deleteVille(String uuid); 
	public VilleDto findByVille(String ville);
	 
}
