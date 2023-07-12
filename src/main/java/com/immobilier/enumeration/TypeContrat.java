package com.immobilier.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypeContrat {
	VENTE,LOCATION,BAIE;
	
	public static List<TypeContrat> getValues(){
        return new ArrayList<TypeContrat>(Arrays.asList(values()));
	}
}
