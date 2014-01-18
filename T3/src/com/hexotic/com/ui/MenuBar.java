package com.hexotic.com.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.hexotic.com.util.VerticalFlowLayout;

public class MenuBar extends JPanel{

	private ArrayList<MenuButton> buttons;
	
	public MenuBar(){
		buttons = new ArrayList<MenuButton>();
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(20, 110));
		VerticalFlowLayout layout = new VerticalFlowLayout();
		layout.setAlignment(VerticalFlowLayout.TOP);
		layout.setVgap(0);
		layout.setHgap(0);
		this.setLayout(layout);
		
		JLabel space = new JLabel("");
		space.setPreferredSize(new Dimension(100,20));
		space.setOpaque(false);
		this.add(space);
		
		addButton(new MenuButton("Convert"));
		addButton(new MenuButton("Combine"));
		addButton(new MenuButton("Create"));
		
		JLabel spaceTwo = new JLabel("");
		spaceTwo.setPreferredSize(new Dimension(450,20));
		spaceTwo.setOpaque(false);
		this.add(spaceTwo);
		
		
		JLabel exit = new JLabel("X");
		exit.setForeground(new Color(0x484848));
		exit.setHorizontalAlignment(SwingConstants.RIGHT);
		exit.setVerticalAlignment(SwingConstants.TOP);
		exit.setPreferredSize(new Dimension(30,30));
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		exit.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		this.add(exit);
	}
	
	public ArrayList<MenuButton> getButtons(){
		return buttons;
	}
	
	public void addButton(MenuButton button){
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ContentController.getInstance().setSelectedPanel(((JButton)e.getSource()).getText());
			}
		});
		this.add(button);
		buttons.add(button);
	}
}
