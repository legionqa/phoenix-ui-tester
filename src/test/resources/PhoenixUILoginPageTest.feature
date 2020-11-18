Feature: Phoenix login page tests

  Background:
    Given User navigates to "https://dashboard.phoenix-widget.com/login" page


  Scenario: Navigate to the login page and verify some components
    Then Verify that Phoenix logo is displayed
    And Verify the Log in menu is visible


  Scenario Outline: Verify the drop down change languages list
    When User clicks on drop down languages list
    And User chooses "<kind>" language
    Then "<greetingText>" according to chosen language is visible
    And Log in button changed to "<buttonName>"
    And Create an account button changed to "<accountName>"
    And Forget password message changed to "<forgetPass>"

    Examples:

      | kind       | greetingText        | buttonName | accountName              | forgetPass            |
      | English    | Welcome to          | Log in     | Create an account        | Forgot your password? |
      | Русский    | Добро пожаловать на | Вход       | Создать аккаунт          | Забыли пароль?        |
      | Українська | Ласкаво просимо на  | Вхід       | Створити обліковий запис | Забули пароль?        |



  Scenario Outline: Verify user password and email fields
    When User types "<email>" into the Email field
    And User types "<pass>" into the Password field
    And User clicks button Log in
    Then Login form is not visible

    Examples:

      | email                       | pass      |
      | legion.qaservices@gmail.com | legion777 |

  Scenario Outline: Verify user incorrect password and email fields
    When User types "<email>" to the Email field
    And User types "<pass>" to the Password field
    And User clicks Log in button
    Then Error message Неверный логин и пароль is visible

    Examples:

      | email                                                  | pass                        |
      | legion.qaservices@gmail.com                            | incorret123456789           |
      | legion.qaservices@gmail.com                            |                             |
      | legion.qaservices@gmail.com                            | 0                           |
      | legion.qaservices@gmail.com                            | null                        |
      | legion.qaservices@gmail.com                            | #$%^&^&*(                   |
      | legion.qaservices@gmail.com                            | ''''                        |
      | incorrect@gmail.com                                    | legion777                   |
      |                                                        | legion777                   |
      | 0                                                      | legion777                   |
      | null                                                   | legion777                   |
      | #$%^^&*                                                | legion777                   |
      | '''''                                                  | legion777                   |
      |                                                        |                             |
      | legion777                                              | legion.qaservices@gmail.com |
      | legion.qaservices@gmail.comlegion.qaservices@gmail.com | legion777legion777legion777 |
      | legion.qaservices@gmail.com                            |                             |
      |                                                        | legion777                   |

  Scenario Outline: Verify changes with Apply button
    When User  clicks Change language button
    And User select "<language>" language
    And User clicks on Forgot password link
    Then Apply button changed to "<changedButton>" according chosen language
    And Notification is displayed "<changedMessage>" according chosen language

    Examples:
      | language    | changedButton | changedMessage                         |
      | English     | Apply         | Enter an e-mail of your account        |
      | Русский     | Применить     | Введите email вашего аккаунта          |
#      | Український | Застосувати   | Введіть email вашого облікового запису |
#      | Portuguesa  | Aplicar       | Digite um e-mail da sua conta          |