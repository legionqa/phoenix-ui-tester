Feature: Phoenix login page tests

  Background:
    Given User navigates to "https://dashboard.phoenix-widget.com/login" page


  Scenario: Navigate to the login page and verify some components
    Then Verify that Phoenix logo is displayed
    And Verify the Log in bar is visible


  Scenario Outline: Verify the drop down languages list
    When User clicks on drop down languages list
    And User chooses "<kind>" language
    Then "<Greeting text>" according to chosen language is visible

    Examples:
      | kind       | Greeting text       |
      | English    | Welcome to         |
      | Русский    | Добро пожаловать на |
      | Українська | Ласкаво просимо на  |
      | Portuguesa | Bem-vindo a         |
