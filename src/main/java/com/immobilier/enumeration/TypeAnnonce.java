package com.immobilier.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 public enum TypeAnnonce {
	
	VENTE,LOCATION,BAIE,EN_MIXTE; 
	
	public static List<TypeAnnonce> getValues(){
		
        return new ArrayList<TypeAnnonce>(Arrays.asList(values()));
    }
 }
