package com.hexotic.com;

import javax.swing.JFrame;

import com.hexotic.com.ui.MainWindow;
import com.hexotic.com.ui.Ribbon;
import com.hexotic.com.ui.msgbox.MessageBox;
import com.hexotic.com.util.Constants;
import com.hexotic.com.util.Log;
/**
 * This To That (T3)
 * 
 * Converter software that can convert one type of media into 
 * another.  
 * 
 * This software is a front-end to the open source initiative 'ffmpeg'
 * 
 * @author Bradley Sheets
 *
 */
public class Main {

	public static void main(String[] args){
		try{
			// create the main application window
			JFrame main = new MainWindow(); 
			
			// create a new ribbon and attache it to the window
			new Ribbon(main);
			
		} catch (Exception e) { 
			// If something crazy happens and hell freezes over, let user know.
			new MessageBox(MessageBox.MSG_2, "Good God","An unknown terrible error happened", e.toString()+"\n\n"+Constants.SUPPORT_INFO);
			
			// Since the user won't know what any of that meant, keep it in a log to so they can send it 
			// if the problem is serious.  Because, you know, logs.
			Log.getInstance().error(new Object(), "CRITICAL SOFTWARE ERROR", e);
		}
	}
}
