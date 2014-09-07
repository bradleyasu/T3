package com.hexotic.com.controls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ChooserPanel extends JPanel{

	private int width;
	private int height;
	private Color color;
	private List<Option> options;
	
	public ChooserPanel(int width, int height, Color color){
		this.width = width;
		this.height = height;
		this.color = color;
		this.options = new ArrayList<Option>();
				
		this.setPreferredSize(new Dimension(width, height));
		this.setOpaque(false);
	}
	
	public void addOption(Option option){
		options.add(option);
		this.revalidate();
		this.repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		// draw RoundRectangle2D.Double
		if(options.isEmpty()){
			g2.setColor(color);
			g2.setFont(new Font("Arial", Font.BOLD, 14));
			g2.drawString("No Supported Format", width/2-75, height/2);
		} else {
			g2.setColor(color.darker());
			int startY = height/2 - 10;
			g2.fillPolygon(new int[]{0,10,10}, new int[]{startY+10,startY,startY+20}, 3);
			g2.fillPolygon(new int[]{width,width-10,width-10}, new int[]{startY+10,startY,startY+20}, 3);
		}
		g2.setColor(color);
		g2.dispose();
		
	}
	
}

class Option {
	public Option(String option){
		
	}
	
	public void setImageIcon(Image image){
		
	}
}