package com.hexotic.com.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hexotic.com.util.Log;

public class TitleBar extends JPanel{
	private JLabel close;
	private int posX = 0;
	private int posY = 0;
	private MainWindow mainWindow; 
	public TitleBar(String title, MainWindow window){
		this.setPreferredSize(new Dimension(100,20));
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		mainWindow = window;
		close = new JLabel("X");
		close.setPreferredSize(new Dimension(10,10));
		close.setVerticalAlignment(JLabel.CENTER);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setForeground(new Color(0xababab));
		close.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Log.getInstance().debug(this, "T3 System Exit From Title Bar X Button");
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				close.setForeground(new Color(0x424242));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				close.setForeground(new Color(0xababab));
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		this.add(close);
		
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				posX = e.getX();
				posY = e.getY();
			}
		});
		
		this.addMouseMotionListener(new MouseAdapter(){
		     public void mouseDragged(MouseEvent e){
				mainWindow.setLocation (e.getXOnScreen()-posX,e.getYOnScreen()-posY);
		     }
		});
		Log.getInstance().debug(this, "Title Bar Created. Location Listeners Active.");
	}

	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Apply our own painting effect
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0xf8f8f8), new Point(0, getHeight()), new Color(0xf8f8f8)));  
		g2d.fillRect(0,0, getWidth(), getHeight());
		g2d.setPaint(new Color(0xdadada));
		g2d.drawLine(0, getHeight()-1, getWidth(), getHeight()-1);
		g2d.dispose();
		
	}
	
}
