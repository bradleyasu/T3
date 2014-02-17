package com.hexotic.com.typefactory;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Extensions {

	public static final int UNKNOWN = -1;
	public static final int OTHER = 0;
	public static final int AAC = 1;
	public static final int AI = 2;
	public static final int AIFF = 3;
	public static final int AVI = 4;
	public static final int BMP = 5;
	public static final int C = 6;
	public static final int CPP = 7;
	public static final int CSS = 8;
	public static final int DAT = 9;
	public static final int DMG = 10;
	public static final int DOC = 11;
	public static final int DOTX = 12;
	public static final int DWG = 13;
	public static final int DXF = 14;
	public static final int EPS = 15;
	public static final int EXE = 16;
	public static final int FLV = 17;
	public static final int GIF = 18;
	public static final int H = 19;
	public static final int HPP = 20;
	public static final int HTML = 21;
	public static final int ICS = 22;
	public static final int ISO = 23;
	public static final int JAVA = 24;
	public static final int JPG = 25;;
	public static final int JS = 26;
	public static final int KEY = 27;
	public static final int LESS = 28;
	public static final int MID = 29;
	public static final int MP3 = 30;
	public static final int MP4 = 31;
	public static final int MPG = 32;
	public static final int ODF = 33;
	public static final int ODS = 34;
	public static final int ODT = 35;
	public static final int OTP = 36;
	public static final int OTS = 37;
	public static final int OTT = 38;
	public static final int PDF = 39;
	public static final int PHP = 40;
	public static final int PNG = 41;
	public static final int PPT = 42;
	public static final int PSD = 43;
	public static final int PY = 44;
	public static final int QT = 45;
	public static final int RAR = 46;
	public static final int RB = 47;
	public static final int RTF = 48;
	public static final int SASS = 49;
	public static final int SCSS = 50;
	public static final int SQL = 51;
	public static final int TGA = 52;
	public static final int TGZ = 53;
	public static final int TIFF = 54;
	public static final int TXT = 55;
	public static final int WAV = 56;
	public static final int XLS = 57;
	public static final int XLSX = 58;
	public static final int XML = 59;
	public static final int YML = 60;
	public static final int ZIP = 61;
	private static final Map<String, Integer> TYPES;
	static {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("AAC", AAC); 
		map.put("AI", AI); 
		map.put("AIFF", AIFF); 
		map.put("AVI", AVI); 
		map.put("BMP", BMP); 
		map.put("C", C); 
		map.put("CPP", CPP); 
		map.put("CSS", CSS); 
		map.put("DAT", DAT); 
		map.put("DMG", DMG); 
		map.put("DOC", DOC); 
		map.put("DOTX", DOTX); 
		map.put("DWG", DWG); 
		map.put("DXF", DXF); 
		map.put("EPS", EPS); 
		map.put("EXE", EXE); 
		map.put("FLV", FLV); 
		map.put("GIF", GIF); 
		map.put("H", H); 
		map.put("HPP", HPP); 
		map.put("HTML", HTML); 
		map.put("ICS", ICS); 
		map.put("ISO", ISO); 
		map.put("JAVA", JAVA); 
		map.put("JPG", JPG); 
		map.put("JS", JS); 
		map.put("KEY", KEY); 
		map.put("LESS", LESS); 
		map.put("MID", MID); 
		map.put("MP3", MP3); 
		map.put("MP4", MP4); 
		map.put("MPG", MPG); 
		map.put("ODF", ODF); 
		map.put("ODS", ODS); 
		map.put("ODT", ODT); 
		map.put("OTP", OTP); 
		map.put("OTS", OTS); 
		map.put("OTT", OTT); 
		map.put("PDF", PDF); 
		map.put("PHP", PHP); 
		map.put("PNG", PNG); 
		map.put("PPT", PPT); 
		map.put("PSD", PSD); 
		map.put("PY", PY); 
		map.put("QT", QT); 
		map.put("RAR", RAR); 
		map.put("RB", RB); 
		map.put("RTF", RTF); 
		map.put("SASS", SASS); 
		map.put("SCSS", SCSS); 
		map.put("SQL", SQL); 
		map.put("TGA", TGA); 
		map.put("TGZ", TGZ); 
		map.put("TIFF", TIFF); 
		map.put("TXT", TXT); 
		map.put("WAV", WAV); 
		map.put("XLS", XLS); 
		map.put("XLSX", XLSX); 
		map.put("XML", XML); 
		map.put("YML", YML); 
		map.put("ZIP", ZIP); 
		map.put("UNKNOWN", UNKNOWN); 
		map.put("OTHER", OTHER); 
		TYPES = Collections.unmodifiableMap(map);
	}
	
	public static int getExtension(String fileName){
		fileName = fileName.toUpperCase();
		int type = UNKNOWN;
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			String ex = fileName.substring(i+1);
			if(TYPES.containsKey(ex)){
				type = TYPES.get(ex);
			} else {
				type = TYPES.get("UNKNOWN");
			}
		}
		return type;
	}
}
