@SAPB7 @SAPB7-1
Feature: Login Page Validation

  @loginPageLoads @smoke @test1
  Scenario: Login Page Loads
    Then SAPB7-N1 I validate that the Login Page Loads


  @wrongPageLoads @test2
  Scenario: Negative Test: Wrong Page Loads
    Then SAPB7-N1 I validate that the Login Page did not Load
