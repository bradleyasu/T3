package com.hexotic.com;

import javax.swing.JFrame;

import com.hexotic.com.ui.MainWindow;
import com.hexotic.com.ui.Ribbon;

public class Main {

	public static void main(String[] args){
		System.out.println("Starting up...");
		JFrame main = new MainWindow();
		new Ribbon(main);
	}
}
