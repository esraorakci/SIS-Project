package com.neotech.steps;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.Constants;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

	/**
	 * Runs before every Scenario
	 */

	@Before
	public void start() {
		// Automatically opens the browser before each Scenario
		BaseClass.setUp();
	}

	/**
	 * Runs after every Scenario
	 */

	@After
	public void end(Scenario scenario) {

		// Takes screenshot on Success/Failure

		if (Constants.TAKE_SCREENSHOT) {

			byte[] screenshot;

			String screenshotName = scenario.getName();

			if (screenshotName.contains(":")) {
				String[] screenshotPathParts = screenshotName.split("[:]");
				screenshotName = "";
				for (String part : screenshotPathParts) {
					screenshotName = screenshotName + part;
				}
			}

			if (scenario.isFailed()) {
				// take a screenshot and put it under "failed" folder
				screenshot = takeScreenShot("failed/" + screenshotName);
			} else {
				// take a screenshot and put it under "passed" folder
				screenshot = takeScreenShot("passed/" + screenshotName);
			}
			scenario.attach(screenshot, "image/png", screenshotName);
		}

		// Automatically closes the browser after each Scenario
		BaseClass.tearDown();
	}

}
