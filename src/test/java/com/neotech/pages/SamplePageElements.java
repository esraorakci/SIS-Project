package com.neotech.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.neotech.testbase.BaseClass;

//Suggested naming convention when creating a new PageElements class

/*
<Page Name/Description>PageElements
*/

//Exmaples:
//	LoginPageElements
//	DashboardPageElements
//	addEmployeePageElements

public class SamplePageElements {

	// Adding a new element, @FindBy Syntax:

	/*
	@FindBy(<Locator> = <Locator Data>)	 
	public WebElement <Name>;
	*/

	// Locator list:
	// id -> id of web element
	// name -> name of web element
	// className -> class of web element
	// CSS -> css path of web element
	// XPath -> xpath path of web element
	// tagName -> tag of web element (ie <a>, <div>, <body>, <img>)
	// linkText -> text of the link exactly
	// partialLinkText -> partial text of the link
	// Example:

	@FindBy(id = "Fuzzy Pickles")
	public WebElement pickles;

	// Adding a new element, @FindAll Syntax:
	// Searches for all webelements that match multiple identifiers
	// Can be type WebElement or List<WebElement>
	// Useful for doing negative tests to see if the WebElements are
	// not there by seeing if List<WebElement> is size 0
	// Examples:

	@FindAll({
			@FindBy(name = "Earthbound"),
			@FindBy(id = "Ness"),
			@FindBy(className = "Boy"),
	})
	public List<WebElement> mother2;

	@FindAll({
			@FindBy(name = "Earthbound"),
			@FindBy(id = "Ness"),
			@FindBy(className = "Boy"),
	})
	public WebElement earthbound;

	// When you create/add a new page for the first time make sure to add the constructor and
	// that you initialize it.

	// Constructor Syntax:

	/*
	public<Class Name>()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	*/

	// IMMPORTANT: After adding/creating a new PageElements class also update the PageInitializer
	// class with your new page.

	public SamplePageElements() {
		PageFactory.initElements(BaseClass.driver, this);

	}
}
