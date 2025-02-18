package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class MainPageStudentElements {

	@FindBy(id = "lStudentID")
	public WebElement studentID;

	@FindBy(id = "lStdName")
	public WebElement studentName;

	@FindBy(id = "lGrdSec")
	public WebElement gradeSection;

	@FindBy(id = "lUserName")
	public WebElement userName;

	@FindBy(id = "lAdmitDate")
	public WebElement admitDate;

	@FindBy(id = "lBirthDate")
	public WebElement birthDate;

	public MainPageStudentElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
