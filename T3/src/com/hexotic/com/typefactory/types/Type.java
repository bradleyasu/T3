package com.hexotic.com.typefactory.types;

import java.awt.Image;
import java.io.File;
import java.util.List;
/**
 * Type interface provides basic functionality that will be required for conversion
 * by any file type.  The TypeFactory will return any type that implements this interface
 * 
 * @author Bradley Sheets
 *
 */
public interface Type {
	
	public List<Type> conversionTypes();
	public File getFile();
	public File convertTo(Type type);
	public Image getImage();
	
}
