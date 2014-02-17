package com.hexotic.com.typefactory.types;

import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;

import com.hexotic.com.util.Resources;

public class PNG  extends ImageIcon implements Type{
	
	private File file;
	
	public PNG(String file){
		this.setImage(Resources.getInstance().getExtImage(file));
		this.file = new File(file);
	}
	
	@Override
	public List<Type> conversionTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public File getFile() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public File convertTo(Type type) {
		// TODO Auto-generated method stub
		return null;
	}
}