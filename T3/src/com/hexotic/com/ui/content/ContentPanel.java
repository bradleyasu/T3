package com.hexotic.com.ui.content;

import java.awt.CardLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class ContentPanel extends JPanel implements Observer{
	
	private CardLayout layout;
	
	public ContentPanel(){
		layout = new CardLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		this.setLayout(layout);
		this.add("Convert", new ConvertPanel());
		this.add("Combine", new CombinePanel());
		this.add("Create", new CreatePanel());
	}

	@Override
	public void update(Observable o, Object arg) {
		String panel = (String)arg;
		layout.show(this, panel);
	}
}
