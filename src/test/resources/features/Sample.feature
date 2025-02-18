#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
#Place a tag at the start to ensure all tests have said tag
@allTestsWillHaveThisTag
Feature: Title of your feature
  I want to use this template for my feature file

  #Steps in the background will run at the start of every test
  Background: 
    Given I want these steps to run before every test
    And They run before every test

  #Basic Scenario
  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  #Scenario Outline will run multiple times using each set of variables.
  #Place in quotes "" if string variable
  #Don't place in quotes "" if double or int variable
  #Be careful when mixing ints and doubles in a single parameter since Cucmber will
  #get confused and create multiple methods for each variant (method overloading)
  #In theory should work but Cucmber but will throw an AmbiguousStepDefinitionsException
  #if both are present since int parameters can be passed as either double or int (bug?)
  #Can be worked around by removing the methods using int parameters leaving only 
  #only methods using double parameters though Cucumber will still highlight steps using
  #only ints as having no glue (seems to be a visual issue only, code will still run)
  #Can get rid of the yellow highlights by adding ".0" to the end of all ints
  #or by passing all of them as strings and using Double.parseDouble() method
  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with "<name>"
    When I add <value1> to <value2>
    And I compare it to <value3>
    Then I verify the "<status>"

    Examples: 
      | name  | value1 | value2 | value3 | status  |
      | name1 |    5.0 |    1.0 |    6.0 | Success |
      | name2 |    5.0 |    2.0 |    6.0 | Fail    |
      | name2 |    5.0 |    1.5 |    6.5 | Success |

  @tag3
  Scenario: Title of your scenario with Datatable
    When I write my first step
    And I want a step that uses the entire following datatable
      | FirstName | MiddleName | LastName   |
      | Umut      | M          | Megismen   |
      | Iana      | M          | L          |
      | Iana      |            | Gandrabura |
    Then I used the whole data table in the previous step
