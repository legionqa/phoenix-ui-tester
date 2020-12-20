@login
Feature: Verify error messages in all languages - Profile Page

  Background:
    Given User navigates to Profile page
  Scenario Outline: Name field error "This field is too short"
    When  User clicks on Change language button
    And User chooses "<language>" language
    And User types abc in the name field
    And click on button Save
    Then Verify that error message is message "<error_message>"

    Examples:
      | error_message                                      | language   |
      | This field is too short (minimum is 4 characters)  | English    |
      | ???                                                | Русский    |
      | ???                                                | Українська |
      | Este campo é muito curto (o mínimo é 4 caracteres) | Portuguesa |

  Scenario Outline: Mail field error "This field can't be blank"
    When  User clicks on Change language button
    And User chooses "<language>" language
    And User clears mail field
    And click on button Save
    Then Verify that error message is message "<error_message>"

    Examples:
      | error_message                       | language   |
      | This field can't be blank           | English    |
      | ??                                  | Русский    |
      | ??                                  | Українська |
      | Este campo não pode ficar em branco | Portuguesa |
