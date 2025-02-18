@SAPB7 @SAPB7-4
Feature: Add New Student Functionality Verification

  Background: 
    Given SAPB7-N2 I login as an Admin
    And SAPB7-N3 I click on the Students Tab

  @addStudent @smoke @test1
  Scenario Outline: Add New Student
    Given SAPB7-N4 I click on the Add New button
    And SAPB7-N4 I enter "<stateId>", "<lastName>", "<firstName>", "<middleName>", "<suffix>", "<SSN>", "<email>", "<dateOfBirth>", "<busInfo>", "<labels>", and "<password>" into the correct fields
    And SAPB7-N4 I select "<gender>", "<lunchType>", "<ethnicity>", and "<gradeLevel>" from the corresponding dropdown
    And SAPB7-N4 I select "<race>" from the corresponding menu
    And SAPB7-N4 I click the Submit Changes
    And SAPB7-N4 I verify the student is added and clear alert
    And SAPB7-N4 I click the Click to Change [photo] button
    And SAPB7-N4 I switch to the Student Photo Upload window
    And SAPB7-N4 I select a picture to upload
    And SAPB7-N4 I click the Upload button
    And SAPB7-N4 I verify that the photo is added, clear alert and switch back to the main window
    Then SAPB7-N4 I verify that "<stateId>", "<lastName>", "<firstName>", "<middleName>", "<suffix>", "<SSN>", "<email>", "<dateOfBirth>", "<busInfo>", "<labels>",  "<gender>", "<lunchType>", "<ethnicity>", "<gradeLevel>", and "<race>"  are entered correctly
    And SAPB7-N4 I save the testStudents username, "<password>", and data

    Examples: 
      | stateId | lastName | firstName | middleName | suffix | SSN       | email         | dateOfBirth | busInfo | labels  | password  | gender | lunchType | ethnicity              | gradeLevel | race  |
      |     666 | Menace   | Dennis    | the        | Jr     | 900909009 | DtM@gmail.com | 4/1/2000    | Night   | Gremlin | Menace123 | Male   | Paid      | Not Hispanic or Latino |          2 | White |
