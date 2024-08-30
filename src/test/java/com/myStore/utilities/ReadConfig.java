package com.myStore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	//String path="D:\\Project\\E_Commerce\\MyStoreVersion1\\Configuration\\config.properties";
	String path="D:\\Project\\E_Commerce\\MyStoreVersion1\\Configuration\\config.properties";

	// Constructor 
	
		public ReadConfig() {
			
			properties = new Properties();
			
			FileInputStream fis;
			try {
				fis = new FileInputStream(path);
			
				properties.load(fis);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		
		// To Read Properties File
		// To read base Url
		public String getBaseUrl() {
			
			String value = properties.getProperty("baseUrl");
			
			if(value!=null) {
				return value;
			}
			else {
				
				throw new RuntimeException("url not specified in config file");
			}
		}
		
		// To Read browser
		
	public String getBrowser() {
			
			String value = properties.getProperty("browser");
			
			if(value!=null) {
				return value;
			}
			else {
				
				throw new RuntimeException("Browser not specified in config file");
			}
		}
	
	// TO READ USERNAME OF THE USER
	
	public String getuserName() {
		
		String value = properties.getProperty("userName");
		
		if(value!=null) {
			return value;
		}
		else {
			
			throw new RuntimeException("UserName is  not specified in config file");
		}
	}
		
	// TO READ PASSWORD 
	
	public String getPassword() {
		
		String value = properties.getProperty("password");
		
		if(value!=null) {
			return value;
		}
		else {
			
			throw new RuntimeException("PASSWORD is not specified in config file");
		}
	}

	}
