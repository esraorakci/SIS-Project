package com.neotech.steps;

import java.util.ArrayList;
import java.util.List;

import com.neotech.utils.CommonMethods;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/*
Suggested naming convention for your Step class

TEAME<task number>Steps

Exmaple:
TEAME18Steps

*/

public class SampleSteps extends CommonMethods {

	// Main method for testing other methods quickly
	/*
	public static void main(String[] args) {
		
		System.out.println(getDateStampAmerican());
		
	}
	*/
	
	@Given("I want these steps to run before every test")
	public void i_want_these_steps_to_run_before_every_test() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("They run before every test")
	public void they_run_before_every_test() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("I want to write a step with precondition")
	public void i_want_to_write_a_step_with_precondition() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("some other precondition")
	public void some_other_precondition() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I complete action")
	public void i_complete_action() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("some other action")
	public void some_other_action() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("yet another action")
	public void yet_another_action() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("check more outcomes")
	public void check_more_outcomes() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("I want to write a step with {string}")
	public void i_want_to_write_a_step_with(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I verify the {string}")
	public void i_verify_the(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I add {double} to {double}")
	public void i_add_to(Double double1, Double double2) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I compare it to {double}")
	public void i_compare_it_to(Double double1) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I write my first step")
	public void i_write_my_first_step() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I want a step that uses the entire following datatable")
	public void i_want_a_step_that_uses_the_entire_following_datatable(io.cucumber.datatable.DataTable dataTable) {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
		// Double, Byte, Short, Long, BigInteger or BigDecimal.
		//
		// For other transformations you can register a DataTableType.
		throw new io.cucumber.java.PendingException();
	}

	@Then("I used the whole data table in the previous step")
	public void i_used_the_whole_data_table_in_the_previous_step() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
