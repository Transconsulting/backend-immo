package com.immobilier.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum StatutDomaine {
	
	ANNONCE,LOUER,VENDU,BAYER,MIXTE,AUCUN;
	 public static List<StatutDomaine> getValues(){
        return new ArrayList<StatutDomaine>(Arrays.asList(values()));
	 }
}
