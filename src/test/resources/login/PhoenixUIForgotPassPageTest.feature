Feature: Forgot Password page tests

  Background:
    Given User navigates to Forgot password page

#   Verify elements and languages

  Scenario: Verify elements visibility - Forgot password page
    Then Phoenix logo is visible - Forgot password page
    And Email form is visible
    And Trade Up logo is visible - Forgot password page

#    Negative tests

  Scenario Outline: Verify incorrect Email input
    When User types invalid "<email>" to the email field
    And User clicks Apply button
    Then Error message is visible

    Examples:
      | email            |
      | qwerty@gmailcom  |
      |                  |
      | #$%^&*(          |
      | 46521548+556=458 |
      | 00000            |
      | null             |
      | ty@hj.           |
      | gmail.com@email  |



#    Positive tests

#  Scenario: Verify valid Email input
#    Given User navigates to login page
#    And User clicks Change language button
#    And User select English
#    And User clicks Forgot password link
#    When User types valid email in the email field
#    And User clicks Apply button
#    Then Message All the instructions are sent to your Email is visible
#
#  Scenario Outline: Verify Email sent message language
#    Given User navigates to login page
#    And User clicks Change language button
#    And User select "<language>" language
#    And User clicks Forgot password link
#    When User types valid email in the email field
#    And User clicks Apply button
#    Then Instructions message "<message>" is visible
#
#    Examples:
#      | language   | message                                     |
#      | English    | All the instructions are sent to your Email |
#      | Русский    | ????????                                    |
#      | Українська | ????????????                                |
#      | Portuguesa | ??????????                                  |