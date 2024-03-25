Feature: Login Action
  Description: This feature will test a LogIn and LogOut functionality

  Scenario: Login with valid credentials
    Given User is on Home Page
    When User navigates to Login Page
    Then User enters "lakshyakumarsirohi@gmail.com" and "zfmUj2c@U@8p2r"
    And User should get logged in
    And Message displayed Login Successfully

  Scenario: Login with invalid credentials
    Given User is on Home Page
    When User navigates to Login Page
    Then User enters "abc1@gmail.com" and "dfsd2"
    And User will be asked to go back to login page
    And Provide correct credentials
