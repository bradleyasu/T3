package com.hexotic.com.controls;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.util.List;

import javax.swing.JPanel;

import com.hexotic.com.ui.msgbox.MessageBox;
import com.hexotic.com.util.Log;

/**
 * DragNDropPanel
 * 
 * Well, that's what it is.  This is a component that can be added to any other
 * swing component to form a drag and drop panel.  
 * 
 * @author Bradley Sheets
 *
 */

public class DragNDropPanel extends JPanel{

	private List<File> files;
	private int width;
	private int height;
	private Color color; // The panel is transparent, but the squiggles and text aren't
	
	public DragNDropPanel(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = color;
		
		// Create the drag and drop listener
	    DNDListener ddListener = new DNDListener();

	    // Connect the label with a drag and drop listener
	    new DropTarget(this, ddListener);
	    this.setPreferredSize(new Dimension(width, height));
	    this.setOpaque(false);
	    
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		// draw RoundRectangle2D.Double
		g2.setColor(color);
		float dash1[] = {8.0f};
		BasicStroke dashed = new BasicStroke(4.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND,10.0f, dash1, 0.0f);
		g2.setStroke(dashed);
		g2.setFont(new Font("Arial", Font.BOLD, 14));
		g2.drawString("Drag Here",  15, 55); // TODO This cannot be magic.  We need to calculate this
		g2.draw(new RoundRectangle2D.Double(1,1, getWidth()-2, getHeight()-2, 10, 10));
		
		g2.dispose();
		
	}
	
	class DNDListener implements DropTargetListener {
		
		@Override
		public void drop(DropTargetDropEvent event) {
			// Accept copy drops
			event.acceptDrop(DnDConstants.ACTION_COPY);
			// Get the transfer which can provide the dropped item data
			Transferable transferable = event.getTransferable();
			// Get the data formats of the dropped item
			DataFlavor[] flavors = transferable.getTransferDataFlavors();
			// Loop through the flavors
			for (DataFlavor flavor : flavors) {
				try {
					// If the drop items are files
					if (flavor.isFlavorJavaFileListType()) {
						// Get all of the dropped files
						files = (List<File>) transferable.getTransferData(flavor);
						// Loop them through
						for (File file : files) {
							// Print out the file path
							Log.getInstance().debug(this, "File Dropped: "+file.getPath());
						}
					}
				} catch (Exception e) {
					// Weellll poop.  Something happened damn it.  
					Log.getInstance().error(this, "Couldn't Drag And Drop", e);
					new MessageBox(MessageBox.MSG_5, "Error Reading Dropped Data", "Don't panic.  Sometimes shit happens", e.getLocalizedMessage());
				}
			}
			event.dropComplete(true);
		}
		
		@Override
		public void dragEnter(DropTargetDragEvent event) {
		}
		
		@Override
		public void dragExit(DropTargetEvent event) {
		}
		
		@Override
		public void dragOver(DropTargetDragEvent event) {
		}
		
		@Override
		public void dropActionChanged(DropTargetDragEvent event) {
		}
	}
}

