#Precondition: New student created and credentials saved from SAPB7-04.
#New student is not currently enrolled in any class.
#No other students with the same Last and First name.
@SAPB7 @SAPB7-5
Feature: Enroll Student Functionality and Enrollment Tab Verification

  Background: 
    Given SAPB7-N2 I login as an Admin
    And SAPB7-N3 I click on the Students Tab

  #Run to remove all students with test name from the system to avoid conflicts.
  #Must run SAPB7-04 or Add New Student Precondition afterwards for test to work.
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

  @enrollStudent @smoke @test @test1
  Scenario Outline: Enroll Student functionality and Enrollment Tab
    When SAPB7-N5 I search for the added new student in "<grade>", "<class>" , and "<status2>"
    Then SAPB7-N5 I verify I found the correct student
    When SAPB7-N5 I click the Personal Sub Tab Enroll Btn
    And SAPB7-N5 I fill out enrollment date, "<grade2>", and "<code>", and click the Enroll Menu Enroll Btn
    And SAPB7-N5 I click the logout button
    And SAPB7-N2 I login as an Admin
    And SAPB7-N3 I click on the Students Tab
    And SAPB7-N5 I search for the added new student in "<grade>", "<class>" , and "<status1>"
    Then SAPB7-N5 I verify I found the correct student
    And SAPB7-N5 I verify that the new students Personal Sub Tab shows they have been enrolled in "<grade2>"
    And SAPB7-N5 I update the test Student Grade Selection
    When SAPB7-N5 I click the Enrollment Sub Tab
    Then SAPB7-N5 I verify that the new students Enrollment Sub Tab shows "<grade3>" and "<code>"

    Examples: 
      | grade            | class       | status1  | status2 | grade2    | code          | grade3 |
      | All Grade Levels | All Classes | Enrolled | New     | 2nd Grade | 01 - Enrolled |      2 |
