package com.hexotic.com.ui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConvertPanel extends JPanel{
	
	public ConvertPanel(){
		this.add(new JLabel("Convert"));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0xf8f8f8), new Point(0,
				getHeight()), new Color(0xfefefe)));  
		g2d.fillRect(0,0, getWidth(), getHeight());
		g2d.setPaint(new GradientPaint(new Point(0, getHeight()-10), new Color(0x00CCFF), new Point(0, getHeight()), new Color(0x212121)));
		g2d.fillRect(0, getHeight()-4, getWidth(), 4);
		g2d.dispose();
	}
}
