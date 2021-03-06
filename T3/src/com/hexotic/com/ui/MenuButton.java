package com.hexotic.com.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
/**
 * These buttons can be added to a MenuBar object
 * 
 * @author Bradley Sheets
 *
 */
public class MenuButton extends JButton implements Observer{

	private String label = "";
	boolean isClicked = false;
	
	public MenuButton(String text){
		super(text);
		super.setContentAreaFilled(false);
		this.setFocusPainted(false);
		label = text;
		this.setPreferredSize(new Dimension(150,100));
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setBackground(new Color(0xf8f8f8));
		this.setFont(new Font("Arial", Font.BOLD, 24));
//		this.setHorizontalAlignment(SwingConstants.LEFT);
	}

	/**
	 * Sets the current state of the button.  Is it clicked?
	 */
	public void setClicked(boolean click){
		isClicked = click;
	}
	
	 protected void paintComponent(Graphics g) {
		 Graphics2D g2d = (Graphics2D) g.create();
		 
		 // If the button is clicked paint it like this
         if (getModel().isPressed()) {
        	 g2d.setPaint(new GradientPaint(new Point(0, 10), new Color(0xf8f8f8), new Point(0, 0), new Color(0xe8e8e8)));
        	 setClicked(true);
         } else if (getModel().isRollover() && !isClicked) {
        	// If the button hasn't been clicked yet, but the mouse rolls over, paint it like this
        	g2d.setPaint(new GradientPaint(new Point(0, 10), new Color(0xf8f8f8), new Point(0, 0), new Color(0xe8e8e8)));
         } else {
        	 if(isClicked){ // If it is clicked, just paint it like this to show it's clicked
        		 g2d.setPaint(new GradientPaint(new Point(0, 2), new Color(0xf8f8f8), new Point(0, 0), new Color(0xdadada)));
        	 } else { // Otherwise, just paint the button as normal
        		 g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0xf8f8f8), new Point(0, getHeight()), new Color(0xf8f8f8)));
        	 }
         }
         g2d.fillRect(0, 0, getWidth(), getHeight());
         super.paintComponent(g);
     }

	public void update(Observable o, Object arg) {
		String panel = (String)arg;
		isClicked = panel.equals(this.getText());
		this.revalidate();
		this.repaint();
	}
}
