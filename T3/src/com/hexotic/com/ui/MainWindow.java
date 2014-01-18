package com.hexotic.com.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdesktop.swingx.border.DropShadowBorder;

import com.hexotic.com.util.Constants;


public class MainWindow extends JFrame{

	public MainWindow(){
		setTitle("T3");
		setUndecorated(true);
		ClassLoader cldr = this.getClass().getClassLoader();
		//java.net.URL iconPth   = cldr.getResource("images/icon.png");
		//this.setIconImage(new ImageIcon(iconPth).getImage());
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new MainWindowPanel(this));
		this.setBackground(new Color(0, 255, 0, 0));
		pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		this.setLocation(x, y);
		this.setVisible(true);
	}
	
	class MainWindowPanel extends JPanel{
		private JFrame parent;
		public MainWindowPanel(JFrame p){
			parent = p;
			this.setBackground(new Color(0xffffff));
			this.setBorder(BorderFactory.createLineBorder(new Color(0x212121)));
			DropShadowBorder shadow = new DropShadowBorder();
			shadow.setShadowColor(Color.BLACK);
			shadow.setShowLeftShadow(true);
			shadow.setShowRightShadow(true);
			shadow.setShowBottomShadow(true);
			shadow.setShowTopShadow(true);
			this.setBorder(shadow);
			setOpaque(true);
			this.setLayout(new BorderLayout());
			
			/* add content */
			MenuBar menuBar = new MenuBar();
			ContentPanel contentPanel = new ContentPanel();
			ContentController.getInstance().addObserver(contentPanel);
			for(MenuButton button : menuBar.getButtons()){
				ContentController.getInstance().addObserver(button);
			}
			this.add(menuBar, BorderLayout.NORTH);
			this.add(new HistoryBar(), BorderLayout.SOUTH);
			this.add(contentPanel, BorderLayout.CENTER);
			
			
		}
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0xf8f8f8), new Point(0,
					getHeight()), new Color(0xfefefe)));  
			g2d.fillRect(5,5, getWidth()-10, getHeight()-10);
			g2d.dispose();
			
		}
	}
}
	
