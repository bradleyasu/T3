package com.hexotic.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.border.DropShadowBorder;

import com.hexotic.com.ui.about.AboutBox;
import com.hexotic.com.util.Log;

public class Ribbon extends JDialog{
	
	private JFrame mainWindow;
	private Ribbon ribbon = this;
	private JXCollapsiblePane infoContainer;
	
	public Ribbon(JFrame parent){
		super(parent);
		this.mainWindow = parent;
		setTitle("T3");
		setUndecorated(true);
		ClassLoader cldr = this.getClass().getClassLoader();
		//java.net.URL iconPth   = cldr.getResource("images/icon.png");
		//this.setIconImage(new ImageIcon(iconPth).getImage());
		this.setLayout(new BorderLayout());

		this.setBackground(new Color(255,255,255,0));
		this.setContentPane(new RibbonContentPane());
		pack();
		this.setSize(new Dimension(55, 74));
		int x = this.mainWindow.getLocationOnScreen().x +15;
		int y = this.mainWindow.getLocationOnScreen().y -2;
		this.setLocation(x, y);
		this.setVisible(true);
		Log.getInstance().debug(this, "Ribbon Appended To Window");
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				new AboutBox();
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
		
		parent.addComponentListener(new ComponentListener(){
			@Override
			public void componentHidden(ComponentEvent e) {
			}
			@Override
			public void componentMoved(ComponentEvent e) {
				ribbon.setSize(new Dimension(55, 74));
				int x = mainWindow.getLocationOnScreen().x +15;
				int y = mainWindow.getLocationOnScreen().y -2;
				ribbon.setLocation(x, y);
			}
			@Override
			public void componentResized(ComponentEvent e) {
				// TODO Auto-generated method stub
			}
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	
	class RibbonContentPane extends JPanel{
		public RibbonContentPane(){
			this.setBackground(new Color(0xffffff));
			this.setBorder(BorderFactory.createLineBorder(new Color(0x212121)));
			DropShadowBorder shadow = new DropShadowBorder();
			shadow.setShadowColor(Color.BLACK);
			shadow.setShowLeftShadow(false);
			shadow.setShowRightShadow(true);
			shadow.setShowBottomShadow(true);
			shadow.setShowTopShadow(false);
			this.setBorder(shadow);
			this.setLayout(new FlowLayout());
			this.setOpaque(false);
		}
		protected void paintComponent(Graphics g) {
			// Allow super to paint
			super.paintComponent(g);
			// Apply our own painting effect
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0x282828), new Point(0, getHeight()), new Color(0x353535)));  
			g2d.fillRect(5,5, getWidth()-10, getHeight()-10);
			g2d.setColor(new Color(0xdadada));
			g2d.setFont(new Font("Arial", Font.BOLD, 32));
			g2d.drawString("T", 15, 50);
			g2d.setFont(new Font("Arial", Font.BOLD, 12));
			g2d.drawString("3", 37, 30);
			g2d.setPaint(new Color(0x282828));
			g2d.fillRoundRect(5,4, getWidth()-10, 5, 2, 2);
			g2d.dispose();
			
		}
	}

}
