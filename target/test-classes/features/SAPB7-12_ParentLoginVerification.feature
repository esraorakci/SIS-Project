#Precondition: New student created and credentials saved SAPB7-04, Student is Enrolled SAPB7-05, Parent details are added SAPB7-09.
@SAPB7 @SAPB7-12
Feature: Successful Login and Homepage Validation

  #Run to ensure student is enrolled.
  #Must run if SAPB7-09 was previously run or test will fail to show student information once logged in
  #Unnecceasry to run if SAPB7-05 recently run.
  @enrollStudent @precondition
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

  @validPrimaryParentLogin @smoke @test @test1
  Scenario: Valid Primary Parent Login Verification
    Given SAPB7-N12 I enter a correct testStudentPrimaryParent username
    And SAPB7-N12 I enter a correct testStudentPrimaryParent password
    And SAPB7-N2 I click the login button
    Then SAPB7-N12 I validate that the primaryParent is logged in

  @validSecondaryParentLogin @smoke @test @test2
  Scenario: Valid Seconday Parent Login Verification
    Given SAPB7-N12 I enter a correct testStudentSecondaryParent username
    And SAPB7-N12 I enter a correct testStudentSecondaryParent password
    And SAPB7-N2 I click the login button
    Then SAPB7-N12 I validate that the SecondaryParent is logged in
