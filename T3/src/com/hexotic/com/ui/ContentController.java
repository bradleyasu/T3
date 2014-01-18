package com.hexotic.com.ui;

import java.util.Observable;

public class ContentController extends Observable{

	private static ContentController instance;
	private String selectedPanel = "Convert";
	
	
	private ContentController(){
		
	}

	public void setSelectedPanel(String panel){
		selectedPanel = panel;
		this.notifyObservers(selectedPanel);
		this.setChanged();
	}
	
	public String getSelectedPanel(){
		return selectedPanel;
	}
	
	public static ContentController getInstance(){
		if(instance == null){
			instance = new ContentController();
		}
		return instance;
	}
}
