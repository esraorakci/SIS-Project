package com.neotech.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
import com.neotech.utils.Constants;
import com.neotech.utils.testStudentReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SAPB7_12_ParentLoginVerificationSteps extends CommonMethods {

	@Given("SAPB7-N12 I enter a correct testStudentPrimaryParent username")
	public void sapb7_n12_i_enter_a_correct_test_student_primary_parent_username() {
		sendText(loginPage.usernameField, testStudentReader.getProperty("primaryParentUsername"));
	}

	@Given("SAPB7-N12 I enter a correct testStudentPrimaryParent password")
	public void sapb7_n12_i_enter_a_correct_test_student_primary_parent_password() {
		sendText(loginPage.passwordField, testStudentReader.getProperty("primaryParentPassword"));

	}

	@Then("SAPB7-N12 I validate that the primaryParent is logged in")
	public void sapb7_n12_i_validate_that_the_primary_parent_is_logged_in() {

		String[] profileData = {
				testStudentReader.getProperty("primaryParentFirstName"),
				testStudentReader.getProperty("primaryParentLastName"),
				testStudentReader.getProperty("primaryParentAddress") + " ,",
				testStudentReader.getProperty("primaryParentHomePhone"),
				testStudentReader.getProperty("primaryParentEmail") + ",",
				testStudentReader.getProperty("testStdLocalId"),
				testStudentReader.getProperty("testStdFirstName") + " " +
						testStudentReader.getProperty("testStdLastName"),
				testStudentReader.getProperty("testStdGradeLevel")
		};

		WebElement[] dataFields = { mainPageParent.parentFirstName,
				mainPageParent.parentLastName,
				mainPageParent.parentAddress,
				mainPageParent.parentHomePhone,
				mainPageParent.parentEmail,
				mainPageParent.studentId,
				mainPageParent.studentName,
				mainPageParent.studentGradeLevel
		};

		String[] data = new String[dataFields.length];

		for (int i = 0; i < dataFields.length; i++) {
			data[i] = dataFields[i].getText();
		}

		SAPB7_04_AddStudentSteps.softAssertArrays(profileData, data);

	}

	@Given("SAPB7-N12 I enter a correct testStudentSecondaryParent username")
	public void sapb7_n12_i_enter_a_correct_test_student_secondary_parent_username() {
		sendText(loginPage.usernameField, testStudentReader.getProperty("secondaryParentUsername"));
	}

	@Given("SAPB7-N12 I enter a correct testStudentSecondaryParent password")
	public void sapb7_n12_i_enter_a_correct_test_student_secondary_parent_password() {
		sendText(loginPage.passwordField, testStudentReader.getProperty("secondaryParentPassword"));
	}

	@Then("SAPB7-N12 I validate that the SecondaryParent is logged in")
	public void sapb7_n12_i_validate_that_the_secondary_parent_is_logged_in() {

		String[] profileData = {
				testStudentReader.getProperty("secondaryParentFirstName"),
				testStudentReader.getProperty("secondaryParentLastName"),
				testStudentReader.getProperty("secondaryParentAddress") + " ,",
				testStudentReader.getProperty("secondaryParentHomePhone"),
				testStudentReader.getProperty("secondaryParentEmail") + ",",
				testStudentReader.getProperty("testStdLocalId"),
				testStudentReader.getProperty("testStdFirstName") + " " +
						testStudentReader.getProperty("testStdLastName"),
				testStudentReader.getProperty("testStdGradeLevel")
		};

		WebElement[] dataFields = { mainPageParent.parentFirstName,
				mainPageParent.parentLastName,
				mainPageParent.parentAddress,
				mainPageParent.parentHomePhone,
				mainPageParent.parentEmail,
				mainPageParent.studentId,
				mainPageParent.studentName,
				mainPageParent.studentGradeLevel
		};

		String[] data = new String[dataFields.length];

		for (int i = 0; i < dataFields.length; i++) {
			data[i] = dataFields[i].getText();

		}

		SAPB7_04_AddStudentSteps.softAssertArrays(profileData, data);
	}

}
