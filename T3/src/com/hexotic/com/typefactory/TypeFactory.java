package com.hexotic.com.typefactory;

import com.hexotic.com.typefactory.types.MPG;
import com.hexotic.com.typefactory.types.PNG;
import com.hexotic.com.typefactory.types.TXT;
import com.hexotic.com.typefactory.types.Type;

public class TypeFactory {

	private static TypeFactory instance;
	
	private TypeFactory(){
	}

	public Type getType(String fileName){
		Type type = null;
		switch(Extensions.getExtension(fileName)){
		case Extensions.MPG: 
			type = new MPG(fileName);
			break;
		case Extensions.TXT:
			type = new TXT(fileName);
			break;
		case Extensions.PNG: 
			type = new PNG(fileName);
			break;
		}
		return type;
	}
	
	public static TypeFactory getInstance(){
		if(instance == null)  {
			instance = new TypeFactory();
		}
		return instance;
	}
	
}
