package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class LoginPageElements {

	@FindBy(id = "logoTop")
	public WebElement neotechAcademyNameLogo;

	@FindBy(xpath = "//font[text()='Student Information System']")
	public WebElement studentInformationSystemText;

	@FindAll({
			@FindBy(id = "logoTop"),
			@FindBy(xpath = "//font[text()='Student Information System']")
	})
	public List<WebElement> wrongPageNegativeElementList;

	@FindBy(id = "tUsername")
	public WebElement usernameField;

	@FindBy(id = "tPassword")
	public WebElement passwordField;

	@FindBy(id = "bLogin")
	public WebElement loginBtn;

	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
