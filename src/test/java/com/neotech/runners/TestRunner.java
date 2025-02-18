package com.neotech.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		// Location of our feature file
		// This is where we write the Given/When/Then steps in the Gherkin Syntax)
		features = "src/test/resources/features/",

		// Location of our steps classes
		// This where we implement the steps from our feature file
		glue = "com.neotech.steps",

		// Activates/deactivates dry run
		// true = use if testing steps are not coded yet. Generates a header template
		// that you can copy and use in the steps file.
		// false = use once you've implemented all steps and want to test the code
		dryRun = false,

		// Activates/deactivates monochrome
		// Changes the color of the output on console. Should not affect testing
		monochrome = false,

		// Indicates which tests in the feature file you want to run.
		// AND-OR-NOT syntax:
		// tags = "@A" -> runs all tests with tag "@A"
		// tags = "@A or @B" -> runs tests with either/both tags "@A" or "@B"
		// tags = "@A and @B" -> runs tests with both tags "@A" and "@B"
		// tags = "@A and not @B" -> runs tests with tag "@A" but skips any that also have tag "@B"
		// tags = "@A and (@B or @C)" -> runs tests with both tag "@A" and either tags "@B" or "@C"

		tags = "@SAPB7-12 and @test",

		plugin = {
				// prints the Gherkin scenario(s) steps to the console
				"pretty",
				// creates and saves the basic html report in the target folder
				"html:target/cucumber-default-report.html",
				// stores all executed steps in a json file
				"json:target/cucumber.json",
				// stores all failed scenarios in a txt file
				"rerun:target/failed.txt",
		}

)

public class TestRunner {

}
