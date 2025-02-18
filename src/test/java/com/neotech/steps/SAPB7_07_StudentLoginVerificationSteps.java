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

public class SAPB7_07_StudentLoginVerificationSteps extends CommonMethods {

	@Given("SAPB7-N7 I enter a correct testStudent username")
	public void sapb7_n7_i_enter_a_correct_test_student_username() {
		sendText(loginPage.usernameField, testStudentReader.getProperty("testStdUsername"));
	}

	@Given("SAPB7-N7 I enter a correct testStudent password")
	public void sapb7_n7_i_enter_a_correct_test_student_password() {
		sendText(loginPage.passwordField, testStudentReader.getProperty("testStdPassword"));
	}

	@Then("SAPB7-N7 I validate that the testStudent is logged in")
	public void sapb7_n7_i_validate_that_the_test_student_is_logged_in() {

		String[] profileData = {
				testStudentReader.getProperty("testStdLocalId"),
				testStudentReader.getProperty("testStdFirstName") + " "
						+ testStudentReader.getProperty("testStdLastName"),
				testStudentReader.getProperty("testStdGradeSection"),
				testStudentReader.getProperty("testStdUsername")
		};

		WebElement[] dataFields = { mainPageStudent.studentID,
				mainPageStudent.studentName,
				mainPageStudent.gradeSection,
				mainPageStudent.userName
		};

		String[] data = new String[dataFields.length];

		for (int i = 0; i < dataFields.length; i++) {
			data[i] = dataFields[i].getText();
		}

		SAPB7_04_AddStudentSteps.softAssertArrays(profileData, data);

	}

}
