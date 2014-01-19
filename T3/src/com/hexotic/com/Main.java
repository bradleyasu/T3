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
			JFrame main = new MainWindow();
			new Ribbon(main);
			Object n = null;
			n.toString();
		} catch (Exception e){
			new MessageBox(MessageBox.MSG_2, "Good God","An unknown terrible error happened", e.toString()+"\n\n"+Constants.SUPPORT_INFO);
			Log.getInstance().error(new Object(), "CRITICAL SOFTWARE ERROR", e);
		}
	}
}
