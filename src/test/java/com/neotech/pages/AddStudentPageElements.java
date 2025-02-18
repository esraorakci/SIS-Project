package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class AddStudentPageElements {

	@FindBy(id = "bAdd")
	public WebElement addNewBtn;

	@FindBy(id = "tStateId")
	public WebElement stateIdField;

	@FindBy(id = "tLastName")
	public WebElement lastNameField;

	@FindBy(id = "tFirstName")
	public WebElement firstNameField;

	@FindBy(id = "tMiddleName")
	public WebElement middleNameField;

	@FindBy(id = "tSuffix")
	public WebElement suffixField;

	@FindBy(id = "tSSN")
	public WebElement SSNField;

	@FindBy(id = "tEmail")
	public WebElement emailField;

	@FindBy(id = "tBirthDay")
	public WebElement birthDayField;

	@FindBy(id = "tBusInfo")
	public WebElement busInfoField;

	@FindBy(id = "tLabel")
	public WebElement labelField;

	@FindBy(id = "tPassword")
	public WebElement passwordField;

	@FindBy(id = "gender_list")
	public WebElement genderDD;

	@FindBy(id = "lunchType")
	public WebElement lunchTypeDD;

	@FindBy(id = "ddEthnicity_list")
	public WebElement ethnicityDD;

	@FindBy(id = "cGradeLevel_list")
	public WebElement gradeLevelDD;

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

	@FindBy(id = "tLocalId")
	public WebElement localIdField;

	@FindBy(xpath = "//select[@id='lunchType']/option[@selected='selected']")
	public WebElement selectedLunch;

	@FindBy(xpath = "//select[@id='ddEthnicity_list']/option[@selected='selected']")
	public WebElement selectedEthnicity;

	@FindBy(id = "tGradeSection")
	public WebElement gradeSectionField;

	@FindBy(id = "tParent")
	public WebElement primaryParentField;

	@FindBy(id = "tAddress")
	public WebElement address1Field;

	@FindBy(id = "tAddress2")
	public WebElement address2Field;

	@FindBy(id = "tCity")
	public WebElement cityField;

	@FindBy(id = "tState")
	public WebElement stateField;

	@FindBy(id = "tZip")
	public WebElement zipField;

	@FindBy(id = "tHomePhone")
	public WebElement homePhoneField;

	public AddStudentPageElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
