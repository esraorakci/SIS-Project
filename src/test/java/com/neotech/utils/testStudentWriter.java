package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class testStudentWriter {

	/**
	 * This method writes properties to newStudent.properties file
	 * 
	 * @param filePath
	 */

	public static void writePorperties(String key, String newValue) {

		// 1.Location: this is where the file is located, from parameters
		String filePath = Constants.NEW_STUDENT_FILPATH;

		// if I start writing directly on the file, then I overwrite
		// So, I will read then add new properties, then write

		try {
			// 2. create a fileInputStream
			FileInputStream fis = new FileInputStream(filePath);

			// 3. create a Properties object()
			Properties prop = new Properties();

			// 4. load the data from the .properties file
			prop.load(fis);

			// 5. Change the data
			prop.setProperty(key, newValue);

			// now that I changed it, I can write

			// to write these into the file I need a FileOutputStream
			FileOutputStream fos = new FileOutputStream(filePath);

			// writes the changes to the file
			prop.store(fos, "Updated " + key);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
