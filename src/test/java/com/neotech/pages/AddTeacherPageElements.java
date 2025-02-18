package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class AddTeacherPageElements {

	@FindBy(id = "bAdd")
	public WebElement addNewBtn;

	@FindBy(id = "tStaffStateId")
	public WebElement stateIdField;

	@FindBy(id = "tLastName")
	public WebElement lastNameField;

	@FindBy(id = "tFirstName")
	public WebElement firstNameField;

	@FindBy(id = "tMiddleName")
	public WebElement middleNameField;

	@FindBy(id = "tFormerName")
	public WebElement formerNameField;

	@FindBy(id = "tNameSuffix")
	public WebElement suffixField;

	@FindBy(id = "tSSN")
	public WebElement SSNField;

	@FindBy(xpath = "//td[normalize-space(text())='SSN #:']/following-sibling::td[@class='auto-hide-input']")
	public WebElement SSNHide;

	@FindBy(id = "tSchoolEmail")
	public WebElement emailSchoolField;

	@FindBy(id = "tPersonalEmail")
	public WebElement emailPersonalField;

	@FindBy(id = "tDateofBirth")
	public WebElement birthDayField;

	@FindBy(xpath = "//td[normalize-space(text())='Date of Birth:']/following-sibling::td[@class='auto-hide-input']")
	public WebElement birthDayHide;

	@FindBy(id = "tPassword")
	public WebElement passwordField;

	@FindBy(id = "dGender_list")
	public WebElement genderDD;

	@FindBy(id = "tLicenseCertificationNo")
	public WebElement lcnCrtNoField;

	@FindBy(id = "ddEthnicity_list")
	public WebElement ethnicityDD;

	@FindBy(css = "button.btn.dropdown-toggle.selectpicker.race")
	public WebElement raceMenu;

	@FindBy(css = "ul.dropdown-menu.inner.selectpicker")
	public WebElement raceMenuOpen;

	@FindAll({
			@FindBy(css = "ul.dropdown-menu.inner.selectpicker>li"),
	})
	public List<WebElement> raceMenuOptions;

	@FindBy(xpath = "//span[text()='White']")
	public WebElement white;

	@FindBy(id = "bSubmit")
	public WebElement submitChangesBtn;

	@FindBy(id = "photoChange")
	public WebElement changePhotoBtn;

	@FindBy(id = "fileUpload")
	public WebElement photoPathElmt;

	@FindBy(id = "bSubmit")
	public WebElement photoUploadBtn;

	@FindBy(id = "tUsername")
	public WebElement usernameField;

	@FindBy(id = "tStaffId")
	public WebElement localIdField;

	@FindBy(xpath = "//select[@id='ddEthnicity_list']/option[@selected='selected']")
	public WebElement selectedEthnicity;

	@FindBy(id = "tAddress")
	public WebElement addressField;

	@FindBy(id = "tCity")
	public WebElement cityField;

	@FindBy(id = "state_list")
	public WebElement stateDd;

	@FindBy(id = "tZip")
	public WebElement zipField;

	@FindBy(id = "tHomePhone")
	public WebElement homePhoneField;

	@FindBy(id = "tJTitle")
	public WebElement jobTitleField;

	@FindBy(id = "tCellPhone")
	public WebElement cellPhoneField;

	@FindBy(id = "tSchoolPhone")
	public WebElement schoolPhoneField;

	@FindBy(id = "tSchoolEmail")
	public WebElement schoolEMailField;

	@FindBy(id = "tPersonalEmail")
	public WebElement personalEmailField;

	@FindBy(id = "jPosAccLev")
	public WebElement jobPosAccLevDd;

	@FindBy(xpath = "//select[@id='jPosAccLev']/option[@selected='selected']")
	public WebElement selectedPosAccLev;

	@FindBy(xpath = "//select[@id='staffList_staffs']/option[@selected='selected']")
	public WebElement selectedTeacher;

	public AddTeacherPageElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
