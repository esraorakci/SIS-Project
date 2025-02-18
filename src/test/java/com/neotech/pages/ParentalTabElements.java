package com.neotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class ParentalTabElements {

	// ****************************
	// Primary Parent Elements
	// ****************************

	@FindBy(id = "bAddNew")
	public WebElement addNewPrimaryParentBtn;

	@FindBy(id = "ppFirstName")
	public WebElement primaryParentFirstNameField;

	@FindBy(id = "ppLastName")
	public WebElement primaryParentLastNameField;

	@FindBy(id = "ppPassword")
	public WebElement primaryParentPasswordField;

	@FindBy(id = "ppRelation_list")
	public WebElement primaryParentRelationDd;

	@FindBy(id = "bSave")
	public WebElement primaryParentSaveBtn;

	@FindBy(id = "ppUsername")
	public WebElement primaryParentUsername;

	@FindBy(id = "ppAddress")
	public WebElement primaryParentAddress;

	@FindBy(id = "ppHomePhone")
	public WebElement primaryParentHomePhone;

	@FindBy(id = "ppEmail1")
	public WebElement primaryParentEmail;

	// ****************************
	// Secondary Parent Elements
	// ****************************

	@FindBy(id = "bAddNewSP")
	public WebElement addNewSecondaryParentBtn;

	@FindBy(id = "spFirstName")
	public WebElement secondaryParentFirstNameField;

	@FindBy(id = "spLastName")
	public WebElement secondaryParentLastNameField;

	@FindBy(id = "spPassword")
	public WebElement secondaryParentPasswordField;

	@FindBy(id = "spRelation_list")
	public WebElement secondaryParentRelationDd;

	@FindBy(id = "bSaveSP")
	public WebElement secondaryParentSaveBtn;

	@FindBy(id = "spUsername")
	public WebElement secondaryParentUsername;

	@FindBy(id = "spAddress")
	public WebElement secondaryParentAddress;

	@FindBy(id = "spHomePhone")
	public WebElement secondaryParentHomePhone;

	@FindBy(id = "spEmail1")
	public WebElement secondaryParentEmail;

	public ParentalTabElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
