package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilsFile {

	public static Properties readPropertyFile(String FilePath){
		
		Properties prop = new Properties();
		
		try {
			FileInputStream fis = new FileInputStream(FilePath);
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");

		} catch (IOException e) {
			System.out.println("unable to load file");
		}
		return prop;
	}
}
	