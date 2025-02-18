@SAPB7 @SAPB7-2
Feature: Successful Login and Homepage Validation

  @validLogin @smoke @test1
  Scenario: Valid Login
    Given SAPB7-N2 I enter a correct Admin username
    And SAPB7-N2 I enter a correct Admin password
    And SAPB7-N2 I click the login button
    Then SAPB7-N2 I validate that the user is logged in

  @invalidLoginWrongUsername @wrong @test2
  Scenario: Negative Test Inalid Login: Wrong Username
    Given SAPB7-N2 I enter an incorrect Admin username
    And SAPB7-N2 I enter a correct Admin password
    And SAPB7-N2 I click the login button
    Then SAPB7-N2 I validate that the wrong credentials message is showing
    And SAPB7-N2 I validate that the user is not logged in

  @invalidLoginWrongPassword @wrong @test3
  Scenario: Negative Test Inalid Login: Wrong Password
    Given SAPB7-N2 I enter a correct Admin username
    And SAPB7-N2 I enter an incorrect Admin password
    And SAPB7-N2 I click the login button
    Then SAPB7-N2 I validate that the wrong credentials message is showing
    And SAPB7-N2 I validate that the user is not logged in

  @invalidLoginWrongUsernamePassword @wrong @smoke @test4
  Scenario: Negative Test Inalid Login: Wrong Username and Password
    Given SAPB7-N2 I enter an incorrect Admin username
    And SAPB7-N2 I enter an incorrect Admin password
    And SAPB7-N2 I click the login button
    Then SAPB7-N2 I validate that the wrong credentials message is showing
    And SAPB7-N2 I validate that the user is not logged in

  @invalidLoginNoUsername @missing @test5
  Scenario: Negative Test Inalid Login: No Username
    Given SAPB7-N2 I don't enter a username
    And SAPB7-N2 I enter a correct Admin password
    And SAPB7-N2 I click the login button
    Then SAPB7-N2 I validate that missing credentials message is showing
    And SAPB7-N2 I validate that the user is not logged in

  @invalidLoginNoPassword @missing @test6
  Scenario: Negative Test Inalid Login: No Password
    Given SAPB7-N2 I enter a correct Admin username
    And SAPB7-N2 I don't enter a password
    And SAPB7-N2 I click the login button
    Then SAPB7-N2 I validate that missing credentials message is showing
    And SAPB7-N2 I validate that the user is not logged in

  @invalidLoginNoUsernamePassword @missing @smoke @test7
  Scenario: Negative Test Inalid Login: No Username and Password
    Given SAPB7-N2 I don't enter a username
    And SAPB7-N2 I don't enter a password
    And SAPB7-N2 I click the login button
    Then SAPB7-N2 I validate that missing credentials message is showing
    And SAPB7-N2 I validate that the user is not logged in
