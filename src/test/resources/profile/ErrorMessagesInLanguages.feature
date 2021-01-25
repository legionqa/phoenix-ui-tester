@login @profile
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

  Scenario Outline: Mail field error "This field must be a valid email address"
    When User clicks on Change language button
    And User chooses "<language>" language
    And User send incorrect data "ew" in the mail field
    And click on button Save
    Then Error message "<error_message>" is displayed
    And Red cross is visible in the field

    Examples:
      | language   | error_message                                   |
      | English    | This field must be a valid email address        |
      | Українська | ??                                              |
      | Portuguesa | Este campo deve ser um endereço de email válido |
      | Русский    | ??                                              |


  Scenario Outline: Mail field error "Invalid email address"
    When User clicks on Change language button
    And User chooses "<language>" language
    And User send incorrect data "we@sa" in the mail field
    And click on button Save
    Then Error message "<error_message>" is displayed
    And Red cross is visible in the field

    Examples:
      | language   | error_message          |
      | English    | Invalid email address. |
      | Українська | ??                     |
      | Portuguesa | ??                     |
      | Русский    | ??                     |


  Scenario Outline: Verify Data will be lost pop-up message - Languages
    When User clicks on Change language button
    And User chooses "<language>" language
    And User clears skype fields
    And User click to Main in the left menu
    Then Pop-up message "<error_message>" is displayed

    Examples:
      | language   | error_message                       |
      | English    | ??                                  |
      | Українська | ??                                  |
      | Portuguesa | ??                                  |
      | Русский    | Не сохраненные данные будут утеряны |

