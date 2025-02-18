package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class MainPageAdminElements {

	@FindBy(id = "Header1_imgSchoolLogo")
	public WebElement neotechLogo;

	@FindBy(xpath = "//span[text()='  Announcements']")
	public WebElement announcementsText;

	@FindAll({
			@FindBy(id = "Header1_imgSchoolLogo"),
			@FindBy(xpath = "//span[text()='  Announcements']")
	})
	public List<WebElement> invalidLoginPageNegativeElementList;

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

	@FindBy(xpath = "//span[text()='Students']")
	public WebElement studentsTabSelected;

	@FindBy(xpath = "//a[text()='Students']")
	public WebElement studentsTabUnselected;

	@FindBy(xpath = "//span[text()='Staff/Faculty']")
	public WebElement staffFacultyTabSelected;

	@FindBy(xpath = "//a[text()='Staff/Faculty']")
	public WebElement staffFacultyTabUnselected;

	@FindBy(xpath = "//span[text()='Scheduling']")
	public WebElement schedulingTabSelected;

	@FindBy(xpath = "//a[text()='Scheduling']")
	public WebElement schedulingTabUnselected;

	@FindBy(xpath = "//span[text()='Attendance']")
	public WebElement attendanceTabSelected;

	@FindBy(xpath = "//a[text()='Attendance']")
	public WebElement attendanceTabUnselected;

	@FindBy(xpath = "//span[text()='Discipline']")
	public WebElement disciplineTabSelected;

	@FindBy(xpath = "//a[text()='Discipline']")
	public WebElement disciplineTabUnselected;

	@FindBy(xpath = "//span[text()='Lesson Plans']")
	public WebElement lessonPlansTabSelected;

	@FindBy(xpath = "//a[text()='Lesson Plans']")
	public WebElement lessonPlansTabUnselected;

	@FindBy(xpath = "//a[text()='Lesson Plans']/parent::td/following-sibling::td/span[text()='Tests'] ")
	public WebElement testsTabSelected;

	@FindBy(xpath = "//a[text()='Tests']")
	public WebElement testsTabUnselected;

	@FindBy(xpath = "//a[text()='Lesson Plans']/parent::td/following-sibling::td/span[text()='Reports']")
	public WebElement reportsTabSelected;

	@FindBy(xpath = "//a[text()='Reports']")
	public WebElement reportsTabUnselected;

	/*
	Clicking Dashboard tab opens a new tab to a dead page rather than switching to a tab.
	dashboardTabSelected Web Element is impossible until link is fixed.
	@FindBy(xpath = "//span[text()='Dashboard']")
	public WebElement dashboardTabSelected;
	 */

	@FindBy(xpath = "//a[text()='Dashboard']")
	public WebElement dashboardTabUnselected;

	@FindBy(xpath = "//span[text()='Settings']")
	public WebElement settingsTabSelected;

	@FindBy(xpath = "//a[text()='Settings']")
	public WebElement settingsTabUnselected;

	// ****************************************************************************
	// Main Tabs End
	// ****************************************************************************

	public MainPageAdminElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
