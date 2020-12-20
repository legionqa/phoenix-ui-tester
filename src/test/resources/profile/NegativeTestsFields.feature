@login
Feature: Negative tests

  Background:
    Given User navigates to Profile page


  Scenario: Verify incorrect name action
    When User types short text message in name field
    Then Red cross is visible in the field
    And Error message This field is too short is displayed

  Scenario Outline: Verify incorrect e-mail action
    When User send incorrect data "<text>" in the mail field
    And click on button Save
    Then Error message "<text_message>" is displayed
    And Red cross is visible in the field

    Examples:
      | text                                                 | text_message                             |
      |                                                    | This field can't be blank                |
      | ew                                                   | This field must be a valid email address |
      | we@sa                                                | Invalid email address.                   |
      | ма@ьф.r                                             | This field must be a valid email address |
      | dsdsdlds_dssdsddsdsdsd_ssssssssdfcdddd.dddddddd.ddd | This field must be a valid email address |
      | &*(*SSAH@jsa>>>>>>>???.com                           | This field must be a valid email address |

  Scenario Outline: Verify Data will be lost pop-up message
    When User types new data "<data_text>" in the field "<field>"
    And User click to Main in the left menu
    Then Pop-up message Data will be lost is appearing

    Examples:
      | field                   | data_text    |
      | example@mail.com        | set1@rec.com |
      | Ivan Ivanov             | John Doe     |
      | Enter your phone number | 33333333333  |
      | skype                   | Jane Doe     |

  Scenario: Verify invalid Current password

    When User changing the password block unwrapping
    And User type invalid password qqq in the field Current password
    And Type in New Password and Password confirmation fields same text data qwe123
    And Clicks Change button
    Then The error message is displayed

  Scenario: Current password with invalid New password and Password confirmation
    When User types valid password legion777 in the Password field
    And Not equals data in New password and Password confirmation fields
    And Clicks Change button
    Then The error message is displayed

  Scenario: All fields are blank in the Changing the password
    And User changing the password block unwrapping
    And User  leave all fields blank
    And Clicks Change button
    Then The error message is displayed
