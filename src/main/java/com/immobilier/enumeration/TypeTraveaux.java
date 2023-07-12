package com.immobilier.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum TypeTraveaux {
	INCIDENT,REQUEST;
	
	public static List<TypeTraveaux> getValues(){
        return new ArrayList<TypeTraveaux>(Arrays.asList(values()));
	}
}
