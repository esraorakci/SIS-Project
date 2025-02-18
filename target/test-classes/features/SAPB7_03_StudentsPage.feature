@SAPB7 @SAPB7-3
Feature: Students Page Validation

  Background: 
    Given SAPB7-N2 I login as an Admin

  @studentsTab @smoke @test1
  Scenario: Students Tab Loads
    Given SAPB7-N3 I click on the Students Tab 
    Then SAPB7-N3 I validate that the Students Tab Loads
