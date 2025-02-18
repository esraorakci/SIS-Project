@SAPB7 @SAPB7-10
Feature: Add New Teacher Functionality Verification

  Background: 
    Given SAPB7-N2 I login as an Admin
    And SAPB7-N10 I click on the Staff/Faculty Tab

  @addTeacher @smoke @test1
  Scenario Outline: Add New Teacher
    When SAPB7-N10 I click on the Add New [Teacher] button
    And SAPB7-N10 I enter "<firstName>", "<lastName>", "<jobTitle>", "<dateOfBirth>", "<SSN>", "<password>", "<address>", "<city>", "<zipCode>", and "<cellPhone>" into the correct fields
    And SAPB7-N10 I select "<gender>", "<state>", and "<jobPositionAccessLevel>" from the corresponding dropdown
    And SAPB7-N10 I click the Submit Changes [Teacher] button
    Then SAPB7-N10 I verify the teacher is added by verifying "<firstName>" and "<lastName>"
    When SAPB7-N10 I click the Click to Change [teacher photo] button
    And SAPB7-N10 I switch to the Teacher Photo Upload window
    And SAPB7-N10 I select a teacher picture to upload
    And SAPB7-N10 I click the Upload [teacher photo] button
    Then SAPB7-N10 I verify that the teacher photo is added, clear alert and switch back to the main window
    Then SAPB7-N10 I verify that "<firstName>", "<lastName>", "<jobTitle>", "<dateOfBirth>", "<SSN>", "<address>", "<city>", "<zipCode>", "<cellPhone>", "<gender>", "<state>", and "<jobPositionAccessLevel>" are entered correctly
    And SAPB7-N10 I save the testTeacher username, "<password>", and data

    Examples: 
      | firstName | lastName | jobTitle       | dateOfBirth | SSN       | password    | address             | city     | zipCode | cellPhone  | gender | state | jobPositionAccessLevel |
      | George    | Wilson   | Disciplinarian | 1/1/1960    | 888669999 | Neighbor123 | 1618 Ashland Avenue | Evanston |   60201 | 5555555555 | Male   | IL    | Administrative/Admin   |
