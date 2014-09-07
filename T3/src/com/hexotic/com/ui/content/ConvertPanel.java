package com.hexotic.com.ui.content;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.hexotic.com.controls.ChooserPanel;
import com.hexotic.com.controls.DragNDropPanel;

public class ConvertPanel extends JPanel{
	
	private JPanel leftPanel;
	private JPanel splitPanel;
	private JPanel rightPanel;
	private boolean debug = false;
	
	public ConvertPanel(){
		this.setLayout(new GridLayout(1,2,0,0));
		createLeftPanel();
		//createRightPanel();
		
		
	}
	
	private void createLeftPanel(){
		leftPanel = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		leftPanel.setLayout(layout);
		leftPanel.setBackground(Color.RED);
		leftPanel.setPreferredSize(new Dimension(200, 400));
		leftPanel.setOpaque(debug);
		
		JLabel prepend = new JLabel("Convert: ");
		prepend.setFont(new Font("Arial", Font.BOLD, 27));
		prepend.setPreferredSize(new Dimension(150, 250));
		prepend.setHorizontalAlignment(JLabel.RIGHT);
		leftPanel.add(prepend);
		
		leftPanel.add(new DragNDropPanel(100, 100, new Color(0xdadada)));
		
		JLabel append = new JLabel(" to ");
		append.setFont(new Font("Arial", Font.BOLD, 27));
		append.setPreferredSize(new Dimension(70, 200));
		append.setHorizontalAlignment(JLabel.LEFT);
		leftPanel.add(append);
		
		leftPanel.add(new ChooserPanel(300, 100,  new Color(0xdadada)));
		
		this.add(leftPanel);
	}
	
	public void createSplitPanel(){
		splitPanel = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		splitPanel.setLayout(layout);
		splitPanel.setBackground(Color.BLUE);
		splitPanel.setPreferredSize(new Dimension(40, 400));
		splitPanel.setOpaque(debug);
		
		this.add(splitPanel);
	}
	
	public void createRightPanel(){
		rightPanel = new JPanel();
		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.CENTER);
		rightPanel.setLayout(layout);
		rightPanel.setBackground(Color.GREEN);
		rightPanel.setPreferredSize(new Dimension(200, 400));
		rightPanel.setOpaque(debug);
		
		this.add(rightPanel);
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
