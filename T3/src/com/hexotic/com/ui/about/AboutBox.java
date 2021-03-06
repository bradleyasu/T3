package com.hexotic.com.ui.about;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jdesktop.swingx.JXEditorPane;
import org.jdesktop.swingx.border.DropShadowBorder;

import com.hexotic.com.ui.msgbox.MessageBox;
import com.hexotic.com.ui.msgbox.XButton;
import com.hexotic.com.util.Constants;
/**
 * The about box.  Where all things about T3 are displayed.
 * No one ever looks at the about box, yet somehow you're looking at the 
 * code for the about box.  You're weird.  But anyway, it's just a simple
 * window that reads in a text document in the 'docs' resource folder that
 * is named 'about.txt'
 * 
 * @author Bradley Sheets
 *
 */
public class AboutBox extends JFrame{

	public AboutBox(){
		setTitle("About");
		setUndecorated(true);
		ClassLoader cldr = this.getClass().getClassLoader();
		java.net.URL iconPth   = cldr.getResource("images/icon.png");
		this.setIconImage(new ImageIcon(iconPth).getImage());
		this.setLayout(new BorderLayout());
		this.setContentPane(new AboutPanel(this));
		this.setBackground(new Color(0, 255, 0, 0));
		pack();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(new Dimension(500, 500));
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		this.setLocation(x, y);
		this.setVisible(true);
	}
}

class AboutPanel extends JPanel{
	private JFrame parent;
	public AboutPanel(JFrame p){
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
        this.setLayout(new FlowLayout());
		ClassLoader cldr = this.getClass().getClassLoader();
		java.net.URL thumb   = cldr.getResource("images/icon.png");
		ImageIcon icon = new ImageIcon(thumb);
		Image img = icon.getImage() ;  
		Image newimg = img.getScaledInstance( 128, 128,  java.awt.Image.SCALE_SMOOTH ) ;  
		icon = new ImageIcon( newimg );
		this.add(new JLabel(icon));
		JLabel titleLabel = new JLabel(Constants.LONG_NAME+" "+Constants.VERSION);
		this.add(titleLabel);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
		java.net.URL aboutDoc   = cldr.getResource("docs/about.txt");
		JXEditorPane info = null;
		try{
			info = new JXEditorPane(aboutDoc);
		}catch(Exception e){ 
			info = new JXEditorPane();
			new MessageBox(MessageBox.MSG_2, "I Dunno how this happens", "I couldn't find the help document",e.toString());			
		}
		info.setPreferredSize(new Dimension(450,250));
		info.setBorder(BorderFactory.createLineBorder(new Color(0xe0e0e0)));
		info.setEditable(false);
		this.add(info);
		JLabel spaceLabel = new JLabel("");
		spaceLabel.setPreferredSize(new Dimension(450,35));
		XButton close = new XButton("    Close");
		close.setPreferredSize(new Dimension(100, 22));
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				parent.dispose();
			}
		});
		this.add(spaceLabel);
		this.add(close);
		
	}
	
	 protected void paintComponent(Graphics g) {
		// Allow super to paint
		super.paintComponent(g);
		
		// Apply our own painting effect
		Graphics2D g2d = (Graphics2D) g.create();
		
        g2d.setPaint(new GradientPaint(new Point(0, 0), new Color(0xf8f8f8), new Point(0,
                getHeight()), new Color(0xfefefe)));  
		g2d.fillRect(5,5, getWidth()-10, getHeight()-10);
		
		g2d.dispose();
		
		Color[] colors = { new Color(0x212121),
	 			new Color(0x424242),
	 			new Color(0x424222),
				new Color(0x224242),
		};
		
		for(int i = 2; i < (getWidth()/2)-6; i++){
			 Random rand = new Random();
			 int index = rand.nextInt(colors.length);
			 g.setColor(colors[index]);
			 g.fillRect(i*2, getHeight()-7, 10, 2);
		}
	 }
}

