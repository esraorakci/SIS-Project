package com.neotech.testbase;

import com.neotech.pages.AddStudentPageElements;
import com.neotech.pages.AddTeacherPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.pages.MainPageAdminElements;
import com.neotech.pages.MainPageParentElements;
import com.neotech.pages.MainPageStudentElements;
import com.neotech.pages.ParentalTabElements;
import com.neotech.pages.SamplePageElements;
import com.neotech.pages.StudentsTabElements;

public class PageInitializer extends BaseClass {

	/*
	// When adding a new PageElement class:
	// Step 1: Include a static element for your page element 
	// Suggested naming convention:
	public static <Page Class Name> <Page Name/Description>Page;
	
	// Example: 
	public static SamplePageElements samplePage;
	
	// Don't forget Step 2, see below.
		
	******************************************************************************
	*  IMPORTANT: PLEASE ADD YOUR NEW PAGE TO THE LIST ALPHABETICALLY IN ORDER 
	*  TO CHECK AND SEE IF AN IDENTICAL PAGE ALREADY EXISTS TO AVOID DUPLICATES
	*  REMEMBER THAT WHEN MERGING WITH MAIN BRANCH YOU MIGHT NEED TO FIX THE ORDER
	******************************************************************************
	*  MIND CAPITALIZATION 
	*  DashboardPageElements and dashboardPageElements 
	*  WILL BE SEEN AS 2 DIFFERENT PAGES
	******************************************************************************
	*/

	public static AddTeacherPageElements addTeacherPage;
	public static AddStudentPageElements addStudentPage;
	public static LoginPageElements loginPage;
	public static MainPageAdminElements mainPageAdmin;
	public static MainPageParentElements mainPageParent;
	public static MainPageStudentElements mainPageStudent;
	public static ParentalTabElements parentalPage;
	public static SamplePageElements samplePage;
	public static StudentsTabElements studentsPage;

	public static void initialize() {

		/*
		// Step 2: Add new non-duplicate page to this "initialize" method with
		// a new instance so it. Syntax and example shown below.
		<Page Name/Description>Page = new <Page Class Name>()
		
		// Please try to maintain the same alphabetical order as above
		*/

		addTeacherPage = new AddTeacherPageElements();
		addStudentPage = new AddStudentPageElements();
		loginPage = new LoginPageElements();
		mainPageAdmin = new MainPageAdminElements();
		mainPageParent = new MainPageParentElements();
		mainPageStudent = new MainPageStudentElements();
		parentalPage = new ParentalTabElements();
		samplePage = new SamplePageElements();
		studentsPage = new StudentsTabElements();
	}
}