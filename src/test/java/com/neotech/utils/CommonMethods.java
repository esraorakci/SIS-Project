package com.neotech.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	/**
	 * This method clears a text box and send the text parameter to it.
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * This method clears a text box.
	 * 
	 * @param element
	 * @param text
	 */
	public static void clearText(WebElement element) {
		element.clear();
	}

	/**
	 * This method writes properties to the object files
	 * 
	 * @param filePath
	 * @param key
	 * @param newValue
	 */

	public static void writePorperties(String filePath, String key, String newValue) {

		// 1.Location: this is where the file is located, from parameters
		// String filePath = filePath;

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

	/**
	 * This method gets the 'value' attribute of a Web element.
	 * 
	 * @param element
	 * @return
	 */

	public static String getValue(WebElement element) {
		return element.getAttribute("value");
	}

	/**
	 * This method checks if the radio/checkbox is enabled, and then clicks on the
	 * element that have the attribute value as selectValue.
	 * 
	 * @param elementList
	 * @param selectValue
	 */
	public static void clickRadioOrCheckbox(List<WebElement> elementList, String selectValue) {
		for (WebElement el : elementList) {
			String elementValue = el.getAttribute("value").trim();

			if (elementValue.equals(selectValue) && el.isEnabled()) {
				el.click();
				break;
			}
		}
	}

	/**
	 * This method pauses the execution for a certain amount of seconds.
	 * 
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method selects a drop down element based on visible text.
	 * 
	 * @param element
	 * @param visibleText
	 */
	public static void selectDropdown(WebElement element, String visibleText) {
		try {

			Select sl = new Select(element);
			sl.selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method selects a drop down element based on index.
	 * 
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) {
		try {
			Select sl = new Select(element);
			sl.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches the focus of the driver to an Alert and accepts it if
	 * found. If not found, the NoAlertPresentException is handled.
	 * 
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches the focus of the driver to an Alert and dismisses it if
	 * found. If not found, the NoAlertPresentException is handled.
	 * 
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch the focus of the driver to an alert and return its
	 * text. If alert is not found, the NoAlertPresentException is handled.
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	/**
	 * This method will switch the focus of the driver to an alert and send text to
	 * it. If alert is not found, the NoAlertPresentException is handled.
	 * 
	 * @param text
	 */
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * This method switches to a frame using its name or id.
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * This method switches to a frame using its index.
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using a WebElement.
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches the focus of the driver to window with the passed handle.
	 * 
	 */
	public static void switchWindow(String handle) {
		driver.switchTo().window(handle);

	}

	/**
	 * This method switches the focus of the driver to the child window and returns
	 * the main window handle.
	 * 
	 * @return Main window handle
	 */

	public static String switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {
			if (!mainWindow.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}

		return mainWindow;
	}

	/**
	 * This method creates a wait object based on the driver and the
	 * EXPLICIT_WAIT_TIME.
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		return new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
	}

	/**
	 * This method creates a wait object based on the driver and the given amount of
	 * time.
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject(int secondsToWait) {
		return new WebDriverWait(driver, Duration.ofSeconds(secondsToWait));
	}

	/**
	 * This method will wait for the element to be visible.
	 * 
	 * @param element
	 */
	public static WebElement waitForVisibility(By locator) {
		return getWaitObject().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * This method will wait for the element to be visible.
	 * 
	 * @param element
	 */
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait for the element to be clickable.
	 * 
	 * @param element
	 */
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will wait for clickability and then click on the passed element.
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * This method will cast the driver to a JavascriptExecutor object and return it.
	 * 
	 * @return
	 */
	public static JavascriptExecutor getJSObject() {
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// return js;

		return (JavascriptExecutor) driver;
	}

	/**
	 * This method will click on an element using JavascriptExecutor.
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click()", element);
	}

	/**
	 * This method will scroll the page until a specific element is in view.
	 * 
	 * @param element
	 */
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * This method scrolls the page up based on the pixel parameter.
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method scrolls the page down based on the pixel parameter.
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will select a day corresponding to the date on a calendar given the
	 * List<WebElement> containing all the day elements and the date to select.
	 * 
	 * @param elements
	 * @param date
	 */
	public static void selectCalendarDay(List<WebElement> elements, String date) {
		for (WebElement day : elements) {
			if (day.getText().equals(date)) {
				if (day.isEnabled()) {
					click(day);
					break;
				} else {
					System.out.println("This day is not enabled!!!");
					break;
				}
			}
		}

	}

	/**
	 * This method selects a calendar date based on the provided WebElements for year/month
	 * dropdowns and list of days and separate Strings representing the year, month and day to be
	 * selected.
	 * 
	 * Original creator: Emrah
	 * 
	 * @param yearEl
	 * @param monthEl
	 * @param dayList
	 * @param year
	 * @param month
	 * @param day
	 */
	public static void selectCalendarFullDate(WebElement yearEl, WebElement monthEl, List<WebElement> dayList,
			String year, String month, String day) {

		selectDropdown(yearEl, year);
		selectDropdown(monthEl, month);
		selectCalendarDay(dayList, day);

	}

	/**
	 * This method will take a screenshot and save it with the given fileName.
	 * 
	 * @param fileName
	 */
	public static byte[] takeScreenShot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenShot = ts.getScreenshotAs(OutputType.FILE);
		String destination = Constants.SCREENSHOT_FILEPATH + fileName + "_" + getTimeStamp() + ".png";

		try {

			FileUtils.copyFile(screenShot, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to save the screenshot!!!");
		}

		byte[] toReturn = ts.getScreenshotAs(OutputType.BYTES);
		return toReturn;
	}

	/**
	 * This method returns the current URL as a String.
	 * 
	 * @return
	 */
	public static String getUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * This method returns a timestamp as a String.
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date);
	}

	/**
	 * This method returns current date as a String in Month[2]/Day[2]/Year[4] format.
	 * 
	 * @return
	 */

	public static String getDateAmerican() {
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		return sdf.format(date);
	}

	/**
	 * This method is another substitute for selectDropdown(). It gets a list of WebElements and
	 * a string value to click on the particular element containing the value.
	 * 
	 * @param list
	 * @param value
	 */
	public static void clickOnElement(List<WebElement> list, String value) {
		for (WebElement option : list) {
			if (option.getText().equals(value)) {
				click(option);
				break;
			}
		}
	}

	/**
	 * This method selects an option from a menu where the menu can be clicked. First clicks on the
	 * menu and then clicks on the option.
	 * 
	 * @param menuElement
	 * @param optionElement
	 */

	public static void chooseMenuOptionClick(WebElement menuElement, WebElement optionElement) {
		click(menuElement);
		click(optionElement);
	}

	/**
	 * This method selects an option from a menu where the menu needs to be moused over (no click).
	 * First uses the Actions class to moves the mouse over the menu, then clicks the option.
	 * 
	 * @param menuElement
	 * @param optionElement
	 */

	public static void chooseMenuOptionMouseOver(WebElement menuElement, WebElement optionElement) {
		Actions action = new Actions(driver);
		action.moveToElement(menuElement).perform();
		click(optionElement);
	}

	/**
	 * 
	 * Enters the text of all the listWebElement into a List<String> and performs an assertEquals
	 * on the created List<String> with the passed expectedListString
	 * 
	 * @param listWebElement
	 * @param expectedListString
	 */

	public static void assertEqualsWebElementsText(List<WebElement> listWebElement, List<String> expectedListString) {

		List<String> actualList = new ArrayList<>();

		for (WebElement element : listWebElement) {
			actualList.add(element.getText());
		}

		if (actualList.equals(expectedListString)) {
			System.out.println("The modal has all required fields " + actualList);
		}

		Assert.assertEquals("The modal does not have all required fields", expectedListString, actualList);
	}

	/**
	 * 
	 * Uses an iterator to compare each element in listString1 to listString2 and prints to the
	 * console any element contained in the listString1 that was not in listWebElement listString2.
	 * Does not print elements in listString2 that are not in listString1.
	 * 
	 * @param listWebElement
	 * @param listString
	 */

	public static void listInfoVerificationStringString(List<String> listString1, List<String> listString2) {

		Iterator<String> iteratorListString1 = listString1.iterator();

		while (iteratorListString1.hasNext()) {
			String elmtListString1 = iteratorListString1.next();
			boolean found = false;

			for (String elmtListWebElementToString : listString2) {

				if (elmtListString1.equals(elmtListWebElementToString)) {
					found = true;
					break;
				}

			}
			if (!found) {
				System.out.println("The second list doesn't contain field '" + elmtListString1 + "'");
			}

		}
	}

	/**
	 * 
	 * Enters the text of all the elements in listWebElement into a List<String> and uses an
	 * iterator to compare each element in the passed listString to the created List<String> and
	 * prints to the console any element in the listString that was not in the listWebElement. Does
	 * not print elements in listWebElement that are not in listString.
	 * 
	 * @param listWebElement
	 * @param listString
	 */

	public static void listInfoVerificationWebElementString(List<WebElement> listWebElement, List<String> listString) {

		List<String> listWebElementToString = new ArrayList<>();

		for (WebElement el : listWebElement) {
			listWebElementToString.add(el.getText());
		}

		Iterator<String> iteratorListString = listString.iterator();

		while (iteratorListString.hasNext()) {
			String elmtListString = iteratorListString.next();
			boolean found = false;

			for (String elmtListWebElementToString : listWebElementToString) {

				if (elmtListString.equals(elmtListWebElementToString)) {
					found = true;
					break;
				}

			}
			if (!found) {
				System.out.println("The current table doesn't contain field '" + elmtListString + "'");
			}
		}
	}

}
