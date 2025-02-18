#Precondition: New student created and credentials saved from SAPB7-04.
#New student is not currently enrolled in any class.
#No other students with the same Last and First name.
@SAPB7 @SAPB7-9
Feature: Add Parent Details Verification

  Background: 
    Given SAPB7-N2 I login as an Admin
    And SAPB7-N3 I click on the Students Tab

  #Run to remove all students with test name from the system to avoid conflicts.
  #Must run SAPB7-04 or Add New Student Precondition afterwards for test to work.
  #Must run if SAPB7-05 was previously run or test will fail to find student under New Students
  @clearStudentsPrecondition @precondition @precondition1
  Scenario Outline: Precondition Remove Previous Student Records
    Given SAPB7-N5 I select "<grade>" from grade drop down
    And SAPB7-N5 I select "<class>" from class drop down
    And SAPB7-N5 I select "<status1>" from status drop down
    And SAPB7-N5 I search and remove all previous instance of the student "<lastName>" "<firstName>"
    And SAPB7-N5 I select "<status2>" from status drop down
    And SAPB7-N5 I search and remove all previous instance of the student "<lastName>" "<firstName>"
    And SAPB7-N5 I select "<status3>" from status drop down
    And SAPB7-N5 I search and remove all previous instance of the student "<lastName>" "<firstName>"

    Examples: 
      | grade            | class       | status1  | status2 | status3    | lastName | firstName |
      | All Grade Levels | All Classes | Enrolled | New     | Unenrolled | Menace   | Dennis    |

  #Run to add and ensure student is new and unenrolled.
  #Unnecceasry to run if SAPB7-04 recently run.
  #Must run if SAPB7-05 was previously run or test will fail to find student under New Students
  @addStudentPrecondition @precondition @precondition2
  Scenario Outline: Precondition Add New Student
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

  @addParentDetails @smoke @test @test1
  Scenario Outline: Add Parent Details
    When SAPB7-N5 I search for the added new student in "<grade>", "<class>" , and "<status>"
    Then SAPB7-N5 I verify I found the correct student
    When SAPB7-N9 I click the Personal Sub Tab Parental Btn
    And SAPB7-N9 I fill out Primary Parent "<firstNameP>", "<lastNameP>", "<passwordP>", "<relationP>", "<address>", "<phone>", "<email>" and click the Save [Primary Parent] Btn
    And SAPB7-N9 I fill out Secondary Parent "<firstNameS>", "<lastNameS>", "<passwordS>", "<relationS>", "<address>", "<phone>", "<email>" and click the Save [Secondary Parent] Btn
    And SAPB7-N5 I click the logout button
    And SAPB7-N2 I login as an Admin
    And SAPB7-N3 I click on the Students Tab
    And SAPB7-N5 I search for the added new student in "<grade>", "<class>" , and "<status>"
    Then SAPB7-N5 I verify I found the correct student
    When SAPB7-N9 I click the Personal Sub Tab Parental Btn
    Then SAPB7-N9 I verify that the Parental Sub Tab shows "<firstNameP>", "<lastNameP>", "<relationP>", "<firstNameS>", "<lastNameS>", "<relationS>", "<address>", "<phone>", and "<email>"
    And And SAPB7-N9 I save the Primary and Secondary Parent username, "<passwordP>", "<passwordS>" and data

    Examples: 
      | grade            | class       | status | firstNameP | lastNameP | passwordP | relationP | firstNameS | lastNameS | passwordS | relationS | address         | phone      | email            |
      | All Grade Levels | All Classes | New    | Alice      | Mitchell  | Mom123    | Mother    | Henry      | Mitchell  | Dad123    | Father    | 123 Fake Street | 6666666666 | Mitchel@home.com |
