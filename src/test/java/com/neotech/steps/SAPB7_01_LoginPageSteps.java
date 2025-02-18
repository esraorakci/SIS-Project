package com.neotech.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SAPB7_01_LoginPageSteps extends CommonMethods {

	@Then("SAPB7-N1 I validate that the Login Page Loads")
	public void sapb7_n1_i_validate_that_the_login_page_loads() {
		Assert.assertTrue("Login Page failed to load.",
				loginPage.neotechAcademyNameLogo.isDisplayed());

		Assert.assertTrue("Login Page failed to load.",
				loginPage.studentInformationSystemText.isDisplayed());

	}

	@Then("SAPB7-N1 I validate that the Login Page did not Load")
	public void sapb7_n1_i_validate_that_the_login_page_did_not_load() {

		wrongUrlSetUp();

		int elementsPresent = loginPage.wrongPageNegativeElementList.size();
		String messageString = "Login Page failed to fail to load.";

		Assert.assertTrue(messageString, (elementsPresent == 0));

	}

}
