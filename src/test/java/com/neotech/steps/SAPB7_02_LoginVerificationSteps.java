package com.neotech.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SAPB7_02_LoginVerificationSteps extends CommonMethods {

	@Given("SAPB7-N2 I enter a correct Admin username")
	public void sapb7_n2_i_enter_a_correct_admin_username() {
		sendText(loginPage.usernameField, ConfigsReader.getProperty("username"));
	}

	@Given("SAPB7-N2 I enter a correct Admin password")
	public void sapb7_n2_i_enter_a_correct_admin_password() {
		sendText(loginPage.passwordField, ConfigsReader.getProperty("password"));
	}

	@Given("SAPB7-N2 I click the login button")
	public void sapb7_n2_i_click_the_login_button() {
		click(loginPage.loginBtn);
	}

	@Then("SAPB7-N2 I validate that the user is logged in")
	public void sapb7_n2_i_validate_that_the_user_is_logged_in() {

		String[] errorMsgs = {
				"Main page failed to load, 'announcements' not displayed.",
				"Main page failed to load, logo not displayed.",
				"Main page failed to load, URL does not include 'MainPage.aspx'.",
		};

		boolean[] verificationResults = {
				mainPageAdmin.announcementsText.isDisplayed(),
				mainPageAdmin.neotechLogo.isDisplayed(),
				getUrl().contains("MainPage.aspx")
		};

		for (int i = 0; i < errorMsgs.length; i++) {
			Assert.assertTrue(errorMsgs[i], verificationResults[i]);
		}

	}

	@Given("SAPB7-N2 I enter an incorrect Admin username")
	public void sapb7_n2_i_enter_an_incorrect_admin_username() {
		sendText(loginPage.usernameField, ConfigsReader.getProperty("wrongUsername"));
	}

	@Given("SAPB7-N2 I enter an incorrect Admin password")
	public void sapb7_n2_i_enter_an_incorrect_admin_password() {
		sendText(loginPage.passwordField, ConfigsReader.getProperty("wrongPassword"));
	}

	@Then("SAPB7-N2 I validate that the wrong credentials message is showing")
	public void sapb7_n2_i_validate_that_the_wrong_credentials_message_is_showing() {

		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.alertIsPresent());

		String alertTxt = getAlertText();
		String expectedTxt = "Either username and password do not match or your account doesn't have  access for the selected Academic Year.";
		String failedAssertMsg = "Wrong credentials alert text did not match expected message";
		dismissAlert();

		Assert.assertEquals(failedAssertMsg, expectedTxt, alertTxt);

	}

	@Given("SAPB7-N2 I don't enter a username")
	public void sapb7_n2_i_don_t_enter_a_username() {
		clearText(loginPage.usernameField);
	}

	@Given("SAPB7-N2 I don't enter a password")
	public void sapb7_n2_i_don_t_enter_a_password() {
		clearText(loginPage.passwordField);
	}

	@Then("SAPB7-N2 I validate that missing credentials message is showing")
	public void sapb7_n2_i_validate_that_missing_credentials_message_is_showing() {

		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.alertIsPresent());

		String alertTxt = getAlertText();
		String expectedTxt = "Please fill required fields";
		String failedAssertMsg = "Missing credentials alert text did not match expected message";
		dismissAlert();

		Assert.assertEquals(failedAssertMsg, expectedTxt, alertTxt);

	}

	@Then("SAPB7-N2 I validate that the user is not logged in")
	public void sapb7_n2_i_validate_that_the_user_is_not_logged_in() {

		String[] errorMsgs = {
				"Main page failed to load, 'announcements' or logo displayed.",
				"Main page failed to load, URL includes 'MainPage.aspx'.",
		};

		boolean[] verificationResults = {
				mainPageAdmin.invalidLoginPageNegativeElementList.size() == 0,
				!getUrl().contains("MainPage.aspx")
		};

		for (int i = 0; i < errorMsgs.length; i++) {
			Assert.assertTrue(errorMsgs[i], verificationResults[i]);
		}

	}

	@Given("SAPB7-N2 I login as an Admin")
	public void sapb7_n2_i_login_as_an_admin() {

		sapb7_n2_i_enter_a_correct_admin_username();
		sapb7_n2_i_enter_a_correct_admin_password();
		sapb7_n2_i_click_the_login_button();

		/*
		sendText(loginPage.usernameField, ConfigsReader.getProperty("username"));
		sendText(loginPage.passwordField, ConfigsReader.getProperty("password"));
		click(loginPage.loginBtn);
		*/
	}

}
