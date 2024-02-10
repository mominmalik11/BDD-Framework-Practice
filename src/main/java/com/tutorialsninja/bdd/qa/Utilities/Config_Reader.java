package com.tutorialsninja.bdd.qa.Utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class Config_Reader {// this cucumber doesnt use a TestBase class, in order to read from properties file you have to create a file that reads it aka this
	
	
	public static Properties prop;
	public static FileInputStream ip;
	
	public static Properties initializeConfigPropertiesFile() throws Exception {
		
		 prop = new Properties();
		 ip = new FileInputStream(System.getProperty("user.dir") +"\\src\\test\\resources\\properties_files\\config.properties");
		
		prop.load(ip);
		
		return prop;
		
		
	}

}
