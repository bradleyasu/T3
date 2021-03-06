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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jdesktop.swingx.border.DropShadowBorder;

import com.hexotic.com.ui.content.ContentController;
import com.hexotic.com.ui.content.ContentPanel;
import com.hexotic.com.util.Constants;
import com.hexotic.com.util.Log;
import com.hexotic.com.util.Resources;

/**
 * Here is the mystical and magical main window.
 * 
 * @author Bradley Sheets
 *
 */
public class MainWindow extends JFrame{

	private Log log = Log.getInstance();
	
	public MainWindow(){
		setTitle("T3");
		setUndecorated(true);
		
		this.setIconImage(Resources.getInstance().getImage("icon.png"));
		
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Alright, so we want a fancy window with no chrome and
		// some shadow.  This is a little trick I'm using to accomplish that.
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
		
		// If we made it here, go ahead and log that the window should be available
		log.debug(this, "Main Window Created");
	}
	
	class MainWindowPanel extends JPanel{
		private JFrame parent;
		public MainWindowPanel(JFrame p){
			parent = p;
			this.setBackground(new Color(0xffffff));
			this.setBorder(BorderFactory.createLineBorder(new Color(0x212121)));
			
			// Put on those fancy shadows
			DropShadowBorder shadow = new DropShadowBorder();
			shadow.setShadowColor(Color.BLACK);
			shadow.setShowLeftShadow(true);
			shadow.setShowRightShadow(true);
			shadow.setShowBottomShadow(true);
			shadow.setShowTopShadow(true);
			this.setBorder(shadow);
			
			// And we do want to be able to see the window
			setOpaque(true);
			this.setLayout(new BorderLayout());

			// Add all of the children components
			MenuBar menuBar = new MenuBar(p);
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
	
