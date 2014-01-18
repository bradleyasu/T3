package com.hexotic.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.jdesktop.swingx.JXCollapsiblePane;

public class HistoryBar extends JPanel{

	private boolean collapsed = true;
	private JXCollapsiblePane contentPanel;
	private HistoryBarContent content;
	public HistoryBar(){
		BorderLayout layout = new BorderLayout();
		layout.setHgap(0);
		layout.setVgap(0);
		this.setLayout(layout);
		content = new HistoryBarContent();
		this.add(new HistoryBarHeader(), BorderLayout.NORTH);
		
		 contentPanel = new JXCollapsiblePane();
		 this.add(contentPanel, BorderLayout.CENTER);
		 contentPanel.setCollapsed(true);
		 contentPanel.setAnimated(true);
		 contentPanel.setContentPane(content);
		 contentPanel.setBackground(Color.BLACK);
	}
	
	public void updateHistoryBar(){
		contentPanel.setCollapsed(collapsed);
		this.revalidate();
		this.repaint();
	}
	
	public void setState(boolean state){
		collapsed = state;
	}
			
	class HistoryBarContent extends JPanel{
		public HistoryBarContent(){
			this.setPreferredSize(new Dimension(20,100));
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0x121212), new Point(0, getHeight()), new Color(0x484848)));  
			g2d.fillRect(0,0, getWidth(), getHeight());
			g2d.setColor(new Color(0x313131));
			g2d.drawLine(0,0,getWidth(),0);
			g2d.dispose();
		}
	}
	
	
	class HistoryBarHeader extends JPanel{
		public HistoryBarHeader(){
			this.setPreferredSize(new Dimension(20,20));
			this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			this.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent e) {
					setState(!collapsed);
					updateHistoryBar();
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
		}
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0x484848), new Point(0, getHeight()), new Color(0x121212)));  
			g2d.fillRect(0,0, getWidth(), getHeight());
			
			g2d.setColor(new Color(0x515151));
			g2d.fillRect(getWidth()/2-7,5, 15, 2);
			g2d.fillRect(getWidth()/2-7,9, 15, 2);
			g2d.fillRect(getWidth()/2-7,13, 15, 2);
			
			g2d.setColor(new Color(0x121212));
			g2d.drawLine(0,getHeight()-1,getWidth(),getHeight()-1);
			
			g2d.dispose();
			
		}
	}
}
