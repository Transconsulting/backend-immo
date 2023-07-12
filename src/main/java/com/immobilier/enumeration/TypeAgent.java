package com.immobilier.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypeAgent {
	IMMOBILIER,TECHNICIEN;
	
	public static List<TypeAgent> getValues(){
        return new ArrayList<TypeAgent>(Arrays.asList(values()));
	}
}
