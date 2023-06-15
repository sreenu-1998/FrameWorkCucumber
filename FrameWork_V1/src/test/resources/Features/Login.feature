#Author: Srinivas Reddy P
@Scenario
Feature: Login Feature
  
  Scenario Outline: Login with standard user credentials
    Given user enters url "https://www.saucedemo.com/"
    And provides "<username>" and "<password>"
    When user clicks login
    Then user logins in successfully

    Examples: 
      | username  | password | 
      | standard_user | secret_sauce | 
      
