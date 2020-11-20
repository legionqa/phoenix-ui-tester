Feature: Phoenix ForgotPass page tests

  Background:
    Given User opens "https://dashboard.phoenix-widget.com/forgotpass" page


  Scenario Outline: Verify an Email field


    When User types valid "<email>" to the email field
    And User clicks on Apply button
    Then Message All the instructions are sent to your Email is visible

    Examples:
      | email                   |
      | correct_email@gmail.com |

  Scenario Outline: Verify an Emailfield with incorrect input
    When User types invalid "<email>" to the email field
    And User clicks on Apply_button
    Then Error message is visible

    Examples:
      | email            |
      | qwerty@gmailcom  |
      | qwerty@gmail,com |
      | #$%^&*(          |
      | 46521548+556=458 |
      | 00000            |
      | null             |
      | ty@hj.           |
      | ''''''''''       |