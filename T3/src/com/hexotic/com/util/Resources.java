package com.hexotic.com.util;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Resources {

	private static Resources instance;
	private ClassLoader cldr = this.getClass().getClassLoader();
	
	private Resources(){
		
	}
	
	public Image getExtImage(String fileName){
		String type = "unknown";
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    type = fileName.substring(i+1);
		}
		return getImage("exts/"+type+".png");
	}
	
	public Image getImage(String resource){
		resource = resource.toLowerCase();
		java.net.URL iconPth   = cldr.getResource("images/"+resource);
		Log.getInstance().debug(this, "Resource Loaded: "+iconPth.getFile());
		return new ImageIcon(iconPth).getImage();
	}
	
	public static Resources getInstance(){
		if (instance == null){
			instance = new Resources();
		}
		return instance;		
	}
	
}
