package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class MainPageParentElements {

	@FindBy(id = "Header1_imgSchoolLogo")
	public WebElement neotechLogo;

	@FindBy(xpath = "//a[text()=' Log Out']")
	public WebElement logOutBtn;

	// ****************************************************************************
	// Main Tabs Start
	// ----------------------------------------------------------------------------
	// xpath changes depending whether or not tab is selected
	// 'TabSelected' elements only valid if the respective tab is the current tab.
	// Click 'TabUnselected' elements to switch between tabs.
	// ****************************************************************************

	@FindBy(xpath = "//span[text()='Main Page']")
	public WebElement mainPageTabSelected;

	@FindBy(xpath = "//a[text()='Main Page']")
	public WebElement mainPageTabUnselected;

	@FindBy(xpath = "//span[text()='Attendance']")
	public WebElement attendanceTabSelected;

	@FindBy(xpath = "//a[text()='Attendance']")
	public WebElement attendanceTabUnselected;

	@FindBy(xpath = "//span[text()='Grades']")
	public WebElement gradesTabSelected;

	@FindBy(xpath = "//a[text()='Grades']")
	public WebElement gradesTabUnselected;

	@FindBy(xpath = "//span[text()='Homework']")
	public WebElement homeworkTabSelected;

	@FindBy(xpath = "//a[text()='Homework']")
	public WebElement homeworkTabUnselected;

	@FindBy(xpath = "//span[text()='Results']")
	public WebElement resultsTabSelected;

	@FindBy(xpath = "//a[text()='Results']")
	public WebElement resultsTabUnselected;

	@FindBy(xpath = "//span[text()='Schedule']")
	public WebElement scheduleTabSelected;

	@FindBy(xpath = "//a[text()='Schedule']")
	public WebElement scheduleTabUnselected;

	@FindBy(xpath = "//span[text()='Discipline']")
	public WebElement disciplineTabSelected;

	@FindBy(xpath = "//a[text()='Discipline']")
	public WebElement disciplineTabUnselected;

	// ****************************************************************************
	// Main Tabs End
	// ****************************************************************************

	// ****************************************************************************
	// Parent Profile Information Starts
	// ****************************************************************************

	@FindBy(id = "lFirstName")
	public WebElement parentFirstName;

	@FindBy(id = "lLastName")
	public WebElement parentLastName;

	@FindBy(id = "lAddress")
	public WebElement parentAddress;

	@FindBy(id = "lHomePhone")
	public WebElement parentHomePhone;

	@FindBy(id = "lEmail")
	public WebElement parentEmail;

	@FindBy(id = "GridStudents_ctl02_lStdId")
	public WebElement studentId;

	@FindBy(id = "GridStudents_ctl02_lStudentName")
	public WebElement studentName;

	@FindBy(id = "GridStudents_ctl02_lblGradeLevel")
	public WebElement studentGradeLevel;

	// ****************************************************************************
	// Parent Profile Information Ends
	// ****************************************************************************

	public MainPageParentElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
