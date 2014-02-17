package com.hexotic.com.typefactory.types;

import java.awt.Image;
import java.io.File;
import java.util.List;

public interface Type {
	
	public List<Type> conversionTypes();
	public File getFile();
	public File convertTo(Type type);
	public Image getImage();
	
}
