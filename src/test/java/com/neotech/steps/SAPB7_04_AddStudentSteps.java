package com.neotech.steps;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.Constants;
import com.neotech.utils.testStudentWriter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class SAPB7_04_AddStudentSteps extends CommonMethods {

	public static String mainWindowHandle;
	private static String[] data;
	private static String[] profileData;

	@Given("SAPB7-N4 I click on the Add New button")
	public void sapb7_n4_i_click_on_the_add_new_button() {
		click(addStudentPage.addNewBtn);
	}

	@Given("SAPB7-N4 I enter {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, and {string} into the correct fields")
	public void sapb7_n4_i_enter_and_into_the_correct_fields(String stateId, String lastName, String firstName,
			String middleName, String suffix, String SSN, String email, String birthDay, String busInfo,
			String label, String password) {

		Actions action = new Actions(driver);

		sendText(addStudentPage.stateIdField, stateId);
		sendText(addStudentPage.lastNameField, lastName);
		sendText(addStudentPage.firstNameField, firstName);
		sendText(addStudentPage.middleNameField, middleName);
		sendText(addStudentPage.suffixField, suffix);
		// sendText(addStudentPage.SSNField, SSN);
		// Does not work. Used Actions as workaround but prone to breaking if page modified

		// Moves to and clicks on field to select it but clicks in the middle of the field so any
		// keys sent begin typing at the 8th (out of 9) digit and the first 7 digits left blank
		action.moveToElement(addStudentPage.SSNField).click().perform();
		// Preses LEFT_ARROW enough times to get to the start of the field
		for (int i = 1; i <= 9; i++) {
			action.sendKeys(Keys.ARROW_LEFT).perform();
		}
		action.sendKeys(SSN).perform();

		sendText(addStudentPage.emailField, email);
		sendText(addStudentPage.birthDayField, birthDay);
		sendText(addStudentPage.busInfoField, busInfo);
		sendText(addStudentPage.labelField, label);
		sendText(addStudentPage.passwordField, password);

	}

	@Given("SAPB7-N4 I select {string}, {string}, {string}, and {string} from the corresponding dropdown")
	public void sapb7_n4_i_select_and_from_the_corresponding_dropdown(String gender, String lunchType, String ethnicity,
			String gradeLevel) {

		selectDropdown(addStudentPage.genderDD, gender);
		selectDropdown(addStudentPage.lunchTypeDD, lunchType);
		selectDropdown(addStudentPage.ethnicityDD, ethnicity);
		selectDropdown(addStudentPage.gradeLevelDD, gradeLevel);

	}

	@Given("SAPB7-N4 I select {string} from the corresponding menu")
	public void sapb7_n4_i_select_from_the_corresponding_menu(String race) {

		click(addStudentPage.raceMenu);

		for (WebElement option : addStudentPage.raceMenuOptions) {
			if (option.getText().equals(race)) {
				click(option);
				break;
			}
		}

	}

	@Given("SAPB7-N4 I click the Submit Changes")
	public void sapb7_n4_i_click_the_submit_changes() {

		click(addStudentPage.submitChangesBtn);
	}

	@Given("SAPB7-N4 I verify the student is added and clear alert")
	public void sapb7_n4_i_verify_the_student_is_added_and_clear_alert() {

		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.alertIsPresent());

		String alertTxt = getAlertText().strip();
		String expectedTxt = "Successfully Added";
		String failedAssertMsg = "Student not added, alert text did not match expected message";
		acceptAlert();

		System.out.println("'" + alertTxt + "'");
		System.out.println("'" + expectedTxt + "'");

		Assert.assertEquals(failedAssertMsg, expectedTxt, alertTxt);

	}

	@Given("SAPB7-N4 I click the Click to Change [photo] button")
	public void sapb7_n4_i_click_the_click_to_change_photo_button() {

		click(addStudentPage.changePhotoBtn);
	}

	@Given("SAPB7-N4 I switch to the Student Photo Upload window")
	public void sapb7_n4_i_switch_to_the_student_photo_upload_window() {
		mainWindowHandle = switchToChildWindow();
	}

	@Given("SAPB7-N4 I select a picture to upload")
	public void sapb7_n4_i_select_a_picture_to_upload() {
		sendText(addStudentPage.photoPathElmt, Constants.UPLOAD_PHOTO_FILEPATH);
	}

	@Given("SAPB7-N4 I click the Upload button")
	public void sapb7_n4_i_click_the_upload_button() {
		click(addStudentPage.photoUploadBtn);
	}

	@Given("SAPB7-N4 I verify that the photo is added, clear alert and switch back to the main window")
	public void sapb7_n4_i_verify_that_the_photo_is_added_clear_alert_and_switch_back_to_the_main_window() {
		WebDriverWait wait = getWaitObject();
		wait.until(ExpectedConditions.alertIsPresent());

		String alertTxt = getAlertText().strip();
		String expectedTxt = "File Successfully Uploaded";
		String failedAssertMsg = "Photo not successfully Uploaded, alert text did not match expected message";
		acceptAlert();

		Assert.assertEquals(failedAssertMsg, expectedTxt, alertTxt);
		driver.switchTo().window(mainWindowHandle);
	}

	@Then("SAPB7-N4 I verify that {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string},  {string}, {string}, {string}, {string}, and {string}  are entered correctly")
	public void sapb7_n4_i_verify_that_and_are_entered_correctly(String stateId, String lastName, String firstName,
			String middleName, String suffix, String SSN, String email, String birthDay, String busInfo, String label,
			String gender, String lunchType, String ethnicity,
			String gradeLevel, String race) {

		String[] profileData = { stateId, lastName, firstName, middleName, suffix, SSN, email, birthDay, busInfo, label,
				gender, lunchType, ethnicity, gradeLevel, race };

		WebElement[] dataFields = { addStudentPage.stateIdField, addStudentPage.lastNameField,
				addStudentPage.firstNameField, addStudentPage.middleNameField, addStudentPage.suffixField,
				addStudentPage.SSNField, addStudentPage.emailField, addStudentPage.birthDayField,
				addStudentPage.busInfoField, addStudentPage.labelField, addStudentPage.genderDD,
				addStudentPage.lunchTypeDD, addStudentPage.ethnicityDD, addStudentPage.gradeLevelDD,
				addStudentPage.raceMenu
		};

		String[] data = new String[dataFields.length];

		for (int i = 0; i < dataFields.length; i++) {
			data[i] = getValue(dataFields[i]);
		}

		data[11] = addStudentPage.selectedLunch.getText();
		data[12] = addStudentPage.selectedEthnicity.getText();
		data[14] = addStudentPage.raceMenu.getAttribute("title");

		this.profileData = profileData;
		this.data = data;

		softAssertArrays(profileData, data);

	}

	@Then("SAPB7-N4 I save the testStudents username, {string}, and data")
	public void sapb7_n4_i_save_the_test_students_username_and_data(String newStdPasswordValue) {

		testStudentWriter.writePorperties("testStdUsername", getValue(addStudentPage.usernameField));
		testStudentWriter.writePorperties("testStdLocalId", getValue(addStudentPage.localIdField));
		testStudentWriter.writePorperties("testStdGradeSection", getValue(addStudentPage.gradeSectionField));
		testStudentWriter.writePorperties("testStdPrimaryParent", getValue(addStudentPage.primaryParentField));
		testStudentWriter.writePorperties("testStdAddress1", getValue(addStudentPage.address1Field));
		testStudentWriter.writePorperties("testStdAddress2", getValue(addStudentPage.address2Field));
		testStudentWriter.writePorperties("testStdCity", getValue(addStudentPage.cityField));
		testStudentWriter.writePorperties("testStdState", getValue(addStudentPage.stateField));
		testStudentWriter.writePorperties("testStdZip", getValue(addStudentPage.zipField));
		testStudentWriter.writePorperties("testStdHomePhone", getValue(addStudentPage.homePhoneField));

		testStudentWriter.writePorperties("testStdPassword", newStdPasswordValue);

		for (int i = 0; i < data.length; i++) {

			String keyName = null;

			switch (i) {

			case 0:
				keyName = "testStdStateId";
				break;

			case 1:
				keyName = "testStdLastName";
				break;

			case 2:
				keyName = "testStdFirstName";
				break;

			case 3:
				keyName = "testStdMiddleName";
				break;

			case 4:
				keyName = "testStdSuffix";
				break;

			case 5:
				keyName = "testStdSSN";
				break;

			case 6:
				keyName = "testStdEMail";
				break;

			case 7:
				keyName = "testStdBirthDay";
				break;

			case 8:
				keyName = "testStdBusInfo";
				break;

			case 9:
				keyName = "testStdLabel";
				break;

			case 10:
				keyName = "testStdGender";
				break;

			case 11:
				keyName = "testStdLunchType";
				break;

			case 12:
				keyName = "testStdEthnicity";
				break;

			case 13:
				keyName = "testStdGradeLevel";
				break;

			case 14:
				keyName = "testStdRaceMenu";
				break;

			}

			testStudentWriter.writePorperties(keyName, data[i]);

		}

	}

	public static void softAssertArrays(String[] expected, String[] actual) {

		int arrayLength;
		SoftAssert soft = new SoftAssert();

		if (expected.length > actual.length) {
			arrayLength = actual.length;
		} else {
			arrayLength = expected.length;
		}

		for (int i = 0; i < arrayLength; i++) {

			soft.assertEquals(actual[i], expected[i], "Data mismatch");
		}

		soft.assertAll();
	}

}
