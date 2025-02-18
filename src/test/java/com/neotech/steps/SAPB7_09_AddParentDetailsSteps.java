package com.neotech.steps;

import org.openqa.selenium.WebElement;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.testStudentWriter;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SAPB7_09_AddParentDetailsSteps extends CommonMethods {

	public static String[] data;

	@When("SAPB7-N9 I click the Personal Sub Tab Parental Btn")
	public void sapb7_n9_i_click_the_personal_sub_tab_parental_btn() {
		click(studentsPage.parentalTabUnselected);
	}

	@When("SAPB7-N9 I fill out Primary Parent {string}, {string}, {string}, {string}, {string}, {string}, {string} and click the Save [Primary Parent] Btn")
	public void sapb7_n9_i_fill_out_primary_parent_and_click_the_save_primary_parent_btn(String firstNameP,
			String lastNameP, String passwordP, String relationP, String address, String phone, String email) {
		click(parentalPage.addNewPrimaryParentBtn);

		sendText(parentalPage.primaryParentFirstNameField, firstNameP);
		sendText(parentalPage.primaryParentLastNameField, lastNameP);
		sendText(parentalPage.primaryParentPasswordField, passwordP);

		sendText(parentalPage.primaryParentAddress, address);
		sendText(parentalPage.primaryParentHomePhone, phone);
		sendText(parentalPage.primaryParentEmail, email);

		selectDropdown(parentalPage.primaryParentRelationDd, relationP);

		click(parentalPage.primaryParentSaveBtn);
	}

	@When("SAPB7-N9 I fill out Secondary Parent {string}, {string}, {string}, {string}, {string}, {string}, {string} and click the Save [Secondary Parent] Btn")
	public void sapb7_n9_i_fill_out_secondary_parent_and_click_the_save_secondary_parent_btn(String firstNameS,
			String lastNameS, String passwordS, String relationS, String address, String phone, String email) {

		click(parentalPage.addNewSecondaryParentBtn);

		sendText(parentalPage.secondaryParentFirstNameField, firstNameS);
		sendText(parentalPage.secondaryParentLastNameField, lastNameS);
		sendText(parentalPage.secondaryParentPasswordField, passwordS);

		sendText(parentalPage.secondaryParentAddress, address);
		sendText(parentalPage.secondaryParentHomePhone, phone);
		sendText(parentalPage.secondaryParentEmail, email);

		selectDropdown(parentalPage.secondaryParentRelationDd, relationS);

		click(parentalPage.secondaryParentSaveBtn);

	}

	@Then("SAPB7-N9 I verify that the Parental Sub Tab shows {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string}")
	public void sapb7_n9_i_verify_that_the_parental_sub_tab_shows_and(String firstNameP, String lastNameP,
			String relationP, String firstNameS, String lastNameS, String relationS, String address, String phone,
			String email) {

		String[] profileData = {
				firstNameP, lastNameP, relationP, address, phone, email, firstNameS, lastNameS, relationS, address,
				phone, email };

		WebElement[] dataFields = {
				parentalPage.primaryParentFirstNameField,
				parentalPage.primaryParentLastNameField,
				parentalPage.primaryParentRelationDd,
				parentalPage.primaryParentAddress,
				parentalPage.primaryParentHomePhone,
				parentalPage.primaryParentEmail,

				parentalPage.secondaryParentFirstNameField,
				parentalPage.secondaryParentLastNameField,
				parentalPage.secondaryParentRelationDd,
				parentalPage.secondaryParentAddress,
				parentalPage.secondaryParentHomePhone,
				parentalPage.secondaryParentEmail

		};

		data = new String[dataFields.length];

		for (int i = 0; i < dataFields.length; i++) {

			data[i] = getValue(dataFields[i]);

		}

		SAPB7_04_AddStudentSteps.softAssertArrays(profileData, data);

	}

	@Then("And SAPB7-N9 I save the Primary and Secondary Parent username, {string}, {string} and data")
	public void and_sapb7_n9_i_save_the_primary_and_secondary_parent_username_and_data(String passwordP,
			String passwordS) {

		testStudentWriter.writePorperties("primaryParentUsername", getValue(parentalPage.primaryParentUsername));
		testStudentWriter.writePorperties("secondaryParentUsername", getValue(parentalPage.secondaryParentUsername));

		testStudentWriter.writePorperties("primaryParentPassword", passwordP);
		testStudentWriter.writePorperties("secondaryParentPassword", passwordS);

		for (int i = 0; i < data.length; i++) {

			String keyName = null;

			switch (i) {

			case 0:
				keyName = "primaryParentFirstName";
				break;

			case 1:
				keyName = "primaryParentLastName";
				break;

			case 2:
				keyName = "primaryParentRelation";
				break;

			case 3:
				keyName = "primaryParentAddress";
				break;

			case 4:
				keyName = "primaryParentHomePhone";
				break;

			case 5:
				keyName = "primaryParentEmail";
				break;

			case 6:
				keyName = "secondaryParentFirstName";
				break;

			case 7:
				keyName = "secondaryParentLastName";
				break;

			case 8:
				keyName = "secondaryParentRelation";
				break;

			case 9:
				keyName = "secondaryParentAddress";
				break;

			case 10:
				keyName = "secondaryParentHomePhone";
				break;

			case 11:
				keyName = "secondaryParentEmail";
				break;

			}

			testStudentWriter.writePorperties(keyName, data[i]);

		}
	}

}
