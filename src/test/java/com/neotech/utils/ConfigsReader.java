package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	private static Properties prop;

	/**
	 * This method reads the properties of object files
	 * 
	 * @param filePath
	 */

	public static void readPorperties(String filePath) {

		FileInputStream fis;

		try {

			fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Returns the value of the provided key.
	 * 
	 * @param key
	 * @return value
	 */
	public static String getProperty(String key) {

		return prop.getProperty(key);

	}

}
