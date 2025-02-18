package com.neotech.steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.testStudentReader;
import com.neotech.utils.testStudentWriter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SAPB7_05_EnrollStudentFunctionalitySteps extends CommonMethods {

	@Given("SAPB7-N5 I select {string} from grade drop down")
	public void sapb7_n5_i_select_from_grade_drop_down(String gradeDdOption) {
		selectDropdown(studentsPage.gradeDD, gradeDdOption);
	}

	@Given("SAPB7-N5 I select {string} from class drop down")
	public void sapb7_n5_i_select_from_class_drop_down(String classDdOption) {
		selectDropdown(studentsPage.classDD, classDdOption);
	}

	@Given("SAPB7-N5 I select {string} from status drop down")
	public void sapb7_n5_i_select_from_status_drop_down(String statusDdOption) {
		selectDropdown(studentsPage.statusDD, statusDdOption);
	}

	@Given("SAPB7-N5 I search and remove all previous instance of the student {string} {string}")
	public void sapb7_n5_i_search_and_remove_all_previous_instance_of_the_student(String lastName, String firstName) {

		String studentFullName = lastName + " " + firstName;

		WebDriverWait wait = getWaitObject();

		sendText(studentsPage.searchField, studentFullName);
		wait(1);
		while (studentsPage.searchAutoCompleteList.size() != 0) {
			click(studentsPage.searchAutoCompleteEmt);
			click(studentsPage.searchBtn);

			click(studentsPage.removeBtn);
			wait.until(ExpectedConditions.alertIsPresent());
			acceptAlert();

			clearText(studentsPage.searchField);
			sendText(studentsPage.searchField, studentFullName);
			wait(1);

		}

	}

	@When("SAPB7-N5 I search for the added new student in {string}, {string} , and {string}")
	public void sapb7_n5_i_search_for_the_added_new_student_in_and(String gradeDdOption, String classDdOption,
			String statusDdOption) {

		sapb7_n5_i_select_from_grade_drop_down(gradeDdOption);
		sapb7_n5_i_select_from_class_drop_down(classDdOption);
		sapb7_n5_i_select_from_status_drop_down(statusDdOption);

		searchTestStudent();

	}

	@Then("SAPB7-N5 I verify I found the correct student")
	public void sapb7_n5_i_verify_i_found_the_correct_student() {

		SoftAssert soft = new SoftAssert();

		String[] profileData = { testStudentReader.getProperty("testStdLastName"),
				testStudentReader.getProperty("testStdFirstName"),
				testStudentReader.getProperty("testStdUsername")
		};

		WebElement[] dataFields = { studentsPage.personalSubTabLastNameField,
				studentsPage.personalSubTabFirstNameField,
				studentsPage.personalSubTabUsernameField
		};

		String[] data = new String[dataFields.length];

		for (int i = 0; i < dataFields.length; i++) {
			data[i] = getValue(dataFields[i]);
		}

		for (int i = 0; i < profileData.length; i++) {

			soft.assertEquals(data[i], profileData[i], "Data mismatch");
		}

		soft.assertAll();

	}

	@When("SAPB7-N5 I click the Personal Sub Tab Enroll Btn")
	public void sapb7_n5_i_click_the_personal_sub_tab_enroll_btn() {
		click(studentsPage.personalSubTabEnrollBtn);
	}

	@When("SAPB7-N5 I fill out enrollment date, {string}, and {string}, and click the Enroll Menu Enroll Btn")
	public void sapb7_n5_i_fill_out_enrollment_date_and_and_click_the_enroll_menu_enroll_btn(String grade,
			String code) {

		sendText(studentsPage.enrollMenuDateField, getDateAmerican());
		selectDropdown(studentsPage.enrollMenuGradeSectionDd, grade);
		selectDropdown(studentsPage.enrollMenuCodeDd, code);

		click(studentsPage.enrollMenuEnrollBtn);

	}

	@When("SAPB7-N5 I click the logout button")
	public void sapb7_n5_i_click_the_logout_button() {

		click(studentsPage.logOutBtn);

	}

	@Then("SAPB7-N5 I verify that the new students Personal Sub Tab shows they have been enrolled in {string}")
	public void sapb7_n5_i_verify_that_the_new_students_personal_sub_tab_shows_they_have_been_enrolled_in(
			String gradeSection) {

		Assert.assertEquals("Student not enrolled", "Enrolled", studentsPage.personalSubTabStatus.getText());
		Assert.assertEquals("Student not enrolled in correct grade", gradeSection,
				studentsPage.selectedGradeSection.getText());
	}

	@Then("SAPB7-N5 I verify that the new students Personal Sub Tab shows they have been enrolled")
	public void sapb7_n5_i_verify_that_the_new_students_personal_sub_tab_shows_they_have_been_enrolled() {

		Assert.assertEquals("Student not enrolled", "Enrolled", studentsPage.personalSubTabStatus.getText());

	}

	@Then("SAPB7-N5 I update the test Student Grade Selection")
	public void sapb7_n5_i_update_the_test_student_grade_selection() {

		testStudentWriter.writePorperties("testStdGradeSection", studentsPage.selectedGradeSection.getText());

	}

	@When("SAPB7-N5 I click the Enrollment Sub Tab")
	public void sapb7_n5_i_click_the_enrollment_sub_tab() {

		click(studentsPage.enrollmentTabUnselected);

	}

	@Then("SAPB7-N5 I verify that the new students Enrollment Sub Tab shows {string} and {string}")
	public void sapb7_n5_i_verify_that_the_new_students_enrollment_sub_tab_shows_and(String grade, String code) {

		Assert.assertEquals("Enroll Grade Level not correct", grade,
				studentsPage.enrollmentSubTabSelectedGradeDd.getText());
		Assert.assertEquals("Enroll Grade Level not correct", code,
				studentsPage.enrollmentSubTabSelectedCodeDd.getText());

	}

	public static void searchTestStudent() {

		String studentFullName = testStudentReader.getProperty("testStdLastName") + " "
				+ testStudentReader.getProperty("testStdFirstName");

		WebDriverWait wait = getWaitObject();

		sendText(studentsPage.searchField, studentFullName);
		waitForClickability(studentsPage.searchAutoCompleteEmt);
		click(studentsPage.searchAutoCompleteEmt);
		click(studentsPage.searchBtn);

	}

}
