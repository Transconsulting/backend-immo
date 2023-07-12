package com.immobilier.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypeDomaine {
	PARCELLE,IMMEUBLE,VILLA;
	
	public static List<TypeDomaine> getValues(){
        return new ArrayList<TypeDomaine>(Arrays.asList(values()));
	}
}
