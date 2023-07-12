package com.immobilier.service;
 
  
import java.util.List;

import com.immobilier.dto.IntereseDto; 

public interface IntereseService { 
	public IntereseDto add(String uuidParceApp);
	public void delete(String uuid);
	public long totalByUuidPacelle(String uuid);
	public List<IntereseDto> findAll();
	public List<IntereseDto> listeUserInterseByParcelApp(String uuid);
}
