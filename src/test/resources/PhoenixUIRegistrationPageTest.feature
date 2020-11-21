Feature: Phoenix registration page tests

  Background:
    Given User open "https://dashboard.phoenix-widget.com/register" page


  Scenario: Navigate to the registration page and verify components
    Then Verify that registration form is displayed


  Scenario Outline: Verify Email field
    When User types valid "<email>" in Email field
    And User clicks Registration button
    Then The Error message is not visible

    Examples:

      | email            |
      | qwerty@gmail.com |


  Scenario Outline: Verify Name field
    When User types "<name>" more than four chars in Name field
    And User clicks Register button
    Then Error message: This field is too short is not visible


    Examples:

      | name    |
      | Ivan    |
      | 0000    |
      | #$%^    |
      | ''''''' |
      | null    |
      | h-j-2-5 |

  Scenario Outline:  Verify Enter your phone number field
    When User types "<phone>" in Enter your phone number  field
    And User clicks button of Registration
    Then User verifies the "<phone>"value is visible in Enter your phone number field

    Examples:

      | phone        |
      | +30975648923 |
      | fghjfkljhg   |
      | @#$%^&*      |
      | 000000       |
      | null         |


  Scenario Outline:  Verify Skype field
    When User types "<skype>" in Skype field
    And User clicks button registration
    Then User verifies the "<skype>" value is visible in Skype field

    Examples:

      | skype      |
      | amir1999   |
      | fghj!!!ghj |
      | @#$%^&*    |
      | 000000     |
      | null       |

  Scenario Outline:  Verify Password and Password Confirmation fields
    When User types "<pass>" in Password field
    And User types "<passConf>" in Password confirmation field
    And User types valid email "legione@gmail.com" in Email field
    And User types valid name "John" in Name field
    And User clicks Registration Button
    Then Button Sign in is not visible

    Examples:

      | pass      | passConf  |
      | 123456789 | 123456789 |
      | tesfest   | tesfest   |
      | 135ghjy   | 135ghjy   |
      | @#$%^     | @#$%^     |


  Scenario: Navigate to the registration page and verify is Sign in button active
    When User clicks on button Sign In
    Then Button Sign in is not displayed

  Scenario Outline: Verify currency field
    When User clicks on drop down currency list
    And User chooses "<currency>"
    Then Currency field shows chosen currency "<currency>"

    Examples:
      | currency |
      | USD      |
      | UAH      |
      | RUB      |


  Scenario Outline: Verify Email_field with incorrect input

    When User types "<email>" in Email field
    And Use clicks Registration button
    Then Error message: This field must be a valid email address is visible

    Examples:
      | email                                            |
      | qwerty123456gmail.com                            |
      | @qwertygmail.com                                 |
      | 123                                              |
      | @#$%^&                                           |
      | Q@''''''                                         |
      | 1234@'gmail.com                                  |
      | $$@gmail.                                        |
      | qwerty@gmail.comqwerty@gmail.comqwerty@gmail.com |


  Scenario Outline: Verify Name field with short name

    When User types "<short_name>" in Name field
    And Use clicks Registration buton
    Then Error message This field is too short is visible

    Examples:
      | short_name |
      | Iva        |
      | 123        |
      | @#$        |
      | 000        |
      | '''        |
      | null       |

  Scenario Outline:  Verify Password and Password Confirmation fields with incorrect input
    When User types "<pass>" in Password_field
    And User types "<passConf>" in Password_confirmation field
    And User types valid email "leg@gmail.com" in Email_field
    And User types valid name "John" in Name_field
    And User clicks Registration_Button
    Then Error message: Пароли не совпадают is visible

    Examples:

      | pass                                         | passConf               |
      | 12                                           | 123                    |
      | SD$%^                                        | hjk$%                  |
      | 1234@gmail.com                               | 1234@gmail.ca          |
      | IvanIvanIvanIvanIvanIvanIvanIvanIvanIvanIvan | @#$%^                  |
      | ''''''''''                                   | @#_____5667            |
      | 000000000                                    | ''''''''@#$%^ '''''''' |
      | 45665+5456                                   | 2+2=4                  |

  Scenario Outline: Verify Change language button
    When User clicks on Change language button
    And User clicks on "<language>"
    Then In Email field is displayed "<changed_email>"
    And In Name field is displayed "<changed_name>"
    And In Skype field is displayed "<changed_skype>"
    And In Phone field is displayed "<changed_phone>"
    And In Password field is displayed "<changed_pass>"
    And In Password Confirmation field is displayed "<changed_pass_conf>"
    And Registration button changed to "<button>"

    Examples:
      | language   | changed_email | changed_name | changed_phone           | changed_pass | changed_pass_conf     | button       | changed_skype |
      | English    | E-mail        | Ivan Ivanov  | Enter your phone number | Password     | Password confirmation | Registration | skype         |
      | Русский    | E-mail        | Иван Иванов  | Введите номер телефона  | Пароль       | Подтверждение пароля  | Регистрация  | skype         |
      | Українська | E-mail        | Іван Іванов  | Введіть номер телефону  | Пароль       | Підтвердження пароля  | Реєстрація   | skype         |



