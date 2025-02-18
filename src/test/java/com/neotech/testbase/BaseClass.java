package com.neotech.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;
import com.neotech.utils.testStudentReader;
import com.neotech.utils.testTeacherReader;

public class BaseClass {

	public static WebDriver driver;

	/**
	 * Reads the browser and url from the configuration.properties
	 * file, opens the browser, sets the Implicit wait time and
	 * initializes page factory.
	 * Should run at the start/before all tests.
	 */

	public static void setUp() {

		ConfigsReader.readPorperties(Constants.CONFIGURATION_FILPATH);
		testStudentReader.readPorperties(Constants.NEW_STUDENT_FILPATH);
		testTeacherReader.readPorperties(Constants.NEW_TEACHER_FILPATH);
		String browser = ConfigsReader.getProperty("browser");

		// System.out.println(browser);

		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Using Chrome as default browser");
			driver = new ChromeDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		String url = ConfigsReader.getProperty("url");
		driver.get(url);
		PageInitializer.initialize();

	}

	/**
	 * Closes the browser opened by the Before Hook, reads the browser and
	 * wrongUrl from the configuration.properties file, opens the browser,
	 * sets the Implicit wait time and initializes page factory.
	 * Should ONLY run before a test trying to open a wrong URL.
	 */

	public static void wrongUrlSetUp() {

		tearDown();

		ConfigsReader.readPorperties(Constants.CONFIGURATION_FILPATH);
		String browser = ConfigsReader.getProperty("browser");

		// System.out.println(browser);

		switch (browser.toLowerCase()) {

		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Using Chrome as default browser");
			driver = new ChromeDriver();
			break;

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		String url = ConfigsReader.getProperty("wrongUrl");
		driver.get(url);
		PageInitializer.initialize();

	}

	/**
	 * Closes the browser.
	 * Should run at the end/after all tests.
	 */

	public static void tearDown() {

		if (driver != null) {
			driver.quit();
		}

	}

}
