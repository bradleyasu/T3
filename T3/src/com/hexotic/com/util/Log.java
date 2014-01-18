package com.hexotic.com.util;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Singleton class for writing software logs
 * 
 * @author Bradley Sheets
 *
 */
public class Log {

	private static Log instance;
	private Logger logger = Logger.getLogger(Log.class);
		
	private Log(){
		DOMConfigurator.configure("T3Log.xml");
	}
	
	public void debug(Object parent, String message){
		logger.debug(parent.getClass().getSimpleName()+" [ " + message +" ]");
	}
	
	public void warn(Object parent, String message) {
		logger.warn(parent.getClass().getSimpleName()+" [ " + message +" ]");
	}
	
	public void error(Object parent, String message){
		error(parent, message, new Exception("UNSPECIFIED EXCEPTION"));
	}
	
	public void error(Object parent, String message, Exception ex){
		logger.fatal(parent.getClass().getSimpleName()+" [ " + message +" ]", ex);
	}
	
	public static Log getInstance(){
		if (instance ==  null){
			instance = new Log();
		}
		return instance;
	}
}
