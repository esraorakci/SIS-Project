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

public class SAPB7_03_StudentsPageSteps extends CommonMethods {

	@Given("SAPB7-N3 I click on the Students Tab")
	public void sapb7_n3_i_click_on_the_students_tab() {
		mainPageAdmin.studentsTabUnselected.click();
	}

	@Then("SAPB7-N3 I validate that the Students Tab Loads")
	public void sapb7_n3_i_validate_that_the_students_tab_loads() {

		String[] errorMsgs = {
				"Personal",
				"Parental",
				"Academic",
				"Override Final Grade",
				"Schedule",
				"Discipline Stats",
				"Personal 2",
				"Enrollment",
				"Notes",
				"E-Portfolio",
				"Program Enrollment"
		};

		boolean[] verificationResults = {
				studentsPage.personalTabSelected.isDisplayed(),
				studentsPage.parentalTabUnselected.isDisplayed(),
				studentsPage.academicTabUnselected.isDisplayed(),
				studentsPage.overrideFGTabUnselected.isDisplayed(),
				studentsPage.scheduleTabUnselected.isDisplayed(),
				studentsPage.disciplineStatsTabUnselected.isDisplayed(),
				studentsPage.personal2TabUnselected.isDisplayed(),
				studentsPage.enrollmentTabUnselected.isDisplayed(),
				studentsPage.notesTabUnselected.isDisplayed(),
				studentsPage.ePortfolioTabUnselected.isDisplayed(),
				studentsPage.programEnrollmentTabUnselected.isDisplayed(),
		};

		for (int i = 0; i < errorMsgs.length; i++) {
			Assert.assertTrue("Students Tab failed to load, '" + errorMsgs[i] + "' sub tab not displayed.",
					verificationResults[i]);
		}

	}

}
