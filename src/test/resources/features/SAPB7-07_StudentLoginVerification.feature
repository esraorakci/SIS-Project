#Precondition: New student created and credentials saved from SAPB7-04.
@SAPB7 @SAPB7-7
Feature: Successful Login and Homepage Validation

  @validStudentLogin @smoke @test1
  Scenario: Valid Student Login Verification
    Given SAPB7-N7 I enter a correct testStudent username
    And SAPB7-N7 I enter a correct testStudent password
    And SAPB7-N2 I click the login button
    Then SAPB7-N7 I validate that the testStudent is logged in
