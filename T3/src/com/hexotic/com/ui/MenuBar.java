package com.hexotic.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hexotic.com.ui.content.ContentController;
import com.hexotic.com.util.Log;

public class MenuBar extends JPanel{

	private ArrayList<MenuButton> buttons;
	private TitleBar titleBar;
	private JPanel buttonPanel;
	public MenuBar(JFrame window){
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(20, 120));
		this.setBackground(Color.RED);
		buttons = new ArrayList<MenuButton>();
		this.setLayout(new BorderLayout());

		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setVgap(0);
		layout.setHgap(0);
		buttonPanel = new JPanel(layout);
		JLabel space = new JLabel("");
		space.setOpaque(false);
		space.setPreferredSize(new Dimension(100,100));
		buttonPanel.add(space);
		MenuButton defaultButton = new MenuButton("Convert");
		addButton(defaultButton);
		addButton(new MenuButton("Combine"));
		addButton(new MenuButton("Create"));
		
		buttonPanel.setPreferredSize(new Dimension(20, 110));
		buttonPanel.setOpaque(false);
		
		this.add(new TitleBar("", (MainWindow)window), BorderLayout.NORTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		
		defaultButton.setClicked(true);
		ContentController.getInstance().setSelectedPanel("Convert");
		
	}
	
	public ArrayList<MenuButton> getButtons(){
		return buttons;
	}
	
	public void addButton(MenuButton button){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String selected = ((JButton)e.getSource()).getText();
				Log.getInstance().debug(this, "Action Performed: Selected Menu Button: "+selected);
				ContentController.getInstance().setSelectedPanel(selected);
			}
		});
		buttonPanel.add(button);
		buttons.add(button);
	}
}
