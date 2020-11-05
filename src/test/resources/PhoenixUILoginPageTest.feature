Feature: Phoenix login page tests

  Background:
    Given User navigates to "https://dashboard.phoenix-widget.com/login" page


  Scenario: Navigate to the login page and verify some components
    Then Verify that Phoenix logo is displayed
    And Verify the Log in bar is visible