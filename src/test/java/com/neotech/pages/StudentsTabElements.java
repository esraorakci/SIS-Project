package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

public class StudentsTabElements {

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

	// ****************************************************************************
	// 'Student' Tab Menu Options Start
	// ****************************************************************************

	@FindBy(id = "dGradeLevel_list")
	public WebElement gradeDD;

	@FindBy(id = "gradeSections_list")
	public WebElement classDD;

	@FindBy(id = "studentStatus_list")
	public WebElement statusDD;

	@FindBy(id = "AutoCompleteStudentName_tStudentName")
	public WebElement searchField;

	@FindAll({
			@FindBy(xpath = "//ul[@id='AutoCompleteStudentName_AutoCompleteExtender1_completionListElem']/li")
	})
	public List<WebElement> searchAutoCompleteList;

	@FindBy(xpath = "//ul[@id='AutoCompleteStudentName_AutoCompleteExtender1_completionListElem']/li")
	public WebElement searchAutoCompleteEmt;

	@FindBy(id = "AutoCompleteStudentName_bStudentSelect")
	public WebElement searchBtn;

	@FindBy(id = "bRemove")
	public WebElement removeBtn;

	// ****************************************************************************
	// 'Students' Tab Menu Options End
	// ****************************************************************************

	// ****************************************************************************
	// 'Students' Tab Sub Tab Selectors Start
	// ----------------------------------------------------------------------------
	// xpath changes depending whether or not tab is selected
	// 'TabSelected' elements only valid if the respective tab is the current tab.
	// Click 'TabUnselected' elements to switch between tabs.
	// ****************************************************************************

	@FindBy(xpath = "//span[text()='Personal']")
	public WebElement personalTabSelected;

	@FindBy(xpath = "//a[text()='Personal']")
	public WebElement personalTabUnselected;

	@FindBy(xpath = "//span[text()='Parental']")
	public WebElement parentalTabSelected;

	@FindBy(xpath = "//a[text()='Parental']")
	public WebElement parentalTabUnselected;

	@FindBy(xpath = "//span[text()='Academic']")
	public WebElement academicTabSelected;

	@FindBy(xpath = "//a[text()='Academic']")
	public WebElement academicTabUnselected;

	@FindBy(xpath = "//span[text()='Override Final Grade']")
	public WebElement overrideFGTabSelected;

	@FindBy(xpath = "//a[text()='Override Final Grade']")
	public WebElement overrideFGTabUnselected;

	@FindBy(xpath = "//span[text()='Schedule']")
	public WebElement scheduleTabSelected;

	@FindBy(xpath = "//a[text()='Schedule']")
	public WebElement scheduleTabUnselected;

	@FindBy(xpath = "//span[text()='Discipline Stats']")
	public WebElement disciplineStatsTabSelected;

	@FindBy(xpath = "//a[text()='Discipline Stats']")
	public WebElement disciplineStatsTabUnselected;

	@FindBy(xpath = "//span[text()='Personal 2']")
	public WebElement personal2TabSelected;

	@FindBy(xpath = "//a[text()='Personal 2']")
	public WebElement personal2TabUnselected;

	@FindBy(xpath = "//span[text()='Enrollment']")
	public WebElement enrollmentTabSelected;

	@FindBy(xpath = "//a[text()='Enrollment']")
	public WebElement enrollmentTabUnselected;

	@FindBy(xpath = "//span[text()='Notes']")
	public WebElement notesTabSelected;

	@FindBy(xpath = "//a[text()='Notes']")
	public WebElement notesTabUnselected;

	@FindBy(xpath = "//span[text()='E-Portfolio']")
	public WebElement ePortfolioTabSelected;

	@FindBy(xpath = "//a[text()='E-Portfolio']")
	public WebElement ePortfolioTabUnselected;

	@FindBy(xpath = "//span[text()='Program Enrollment']")
	public WebElement programEnrollmentTabSelected;

	@FindBy(xpath = "//a[text()='Program Enrollment']")
	public WebElement programEnrollmentTabUnselected;

	// ****************************************************************************
	// 'Students' Tab Sub Tab Selectors Ends
	// ****************************************************************************

	// ****************************************************************************
	// 'Students' Tab Sub Tab elements Start
	// ----------------------------------------------------------------------------
	// Elements only active when current sub tab is selected.
	// ****************************************************************************

	// ****************************************************************************
	// 'Students' Tab 'Personal' Sub tab Data Fields and Options Start
	// ****************************************************************************

	@FindBy(id = "tLastName")
	public WebElement personalSubTabLastNameField;

	@FindBy(id = "tFirstName")
	public WebElement personalSubTabFirstNameField;

	@FindBy(id = "tUsername")
	public WebElement personalSubTabUsernameField;

	@FindBy(id = "bStatusChange")
	public WebElement personalSubTabEnrollBtn;

	@FindBy(id = "lStatus")
	public WebElement personalSubTabStatus;
	
	@FindBy(id = "dGradeSection_list")
	public WebElement gradeSectionDd;

	
	@FindBy(xpath = "//select[@id='dGradeSection_list']/option[@selected='selected']")
	public WebElement selectedGradeSection;


	// ****************************************************************************
	// 'Students' Tab 'Personal' Sub tab Data Fields and Options Start
	// ****************************************************************************
	// 'Student' Tab 'Personal' Sub tab Enroll Menu Options Start
	// ****************************************************************************

	@FindBy(id = "enrollDate")
	public WebElement enrollMenuDateField;

	@FindBy(id = "enrollGradeSection_list")
	public WebElement enrollMenuGradeSectionDd;

	@FindBy(id = "enrollCode_list")
	public WebElement enrollMenuCodeDd;

	@FindBy(id = "enrollComment")
	public WebElement enrollMenuCommentField;

	@FindBy(id = "bEnroll")
	public WebElement enrollMenuEnrollBtn;

	// ****************************************************************************
	// 'Students' Tab 'Personal' Sub tab Enroll Menu Options End
	// ****************************************************************************
	// 'Students' Tab 'Enrollment' Sub tab' Start
	// ****************************************************************************

	@FindBy(id = "gridEnrollment_ctl02_tEnrollDate")
	public WebElement enrollmentSubTabDateField;

	@FindBy(id = "gridEnrollment_ctl02_dEnrollGradeLevel_list")
	public WebElement enrollmentSubTabGradeDd;

	@FindBy(xpath = "//select[@id='gridEnrollment_ctl02_dEnrollGradeLevel_list']/option[@selected='selected']")
	public WebElement enrollmentSubTabSelectedGradeDd;

	@FindBy(id = "gridEnrollment_ctl02_tEnrollComment")
	public WebElement enrollmentSubTabCommentField;

	@FindBy(id = "gridEnrollment_ctl02_dEnrollCode_list")
	public WebElement enrollmentSubTabCodeDd;

	@FindBy(xpath = "//select[@id='gridEnrollment_ctl02_dEnrollCode_list']/option[@selected='selected']")
	public WebElement enrollmentSubTabSelectedCodeDd;

	// ****************************************************************************
	// 'Students' Tab 'Enrollment' Sub tab' End
	// ****************************************************************************

	public StudentsTabElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
