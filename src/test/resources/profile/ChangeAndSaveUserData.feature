Feature: Changing and saving user mail, name, password - Profile page

  Scenario: Verify functionality Changing the password
    When User login with test email and password legionqa.test@gmail.com : password1
    And User go to new Profile page
    And User clicks expand button of the Changing the password block
    And User sends current password in the Current password field
    And password2 in New password and Password confirmation fields
    And Clicks Change button
    Then success message is displayed
    And Return all the data to its original

  Scenario Outline: Verify text success message in all language
    When User clicks on Change language button
    And User chooses "<language>" language
    And User clicks expand button of the Changing the password block
    And User sends current password in the Current Password field by xPath
    And password1 in New password and Password confirmation fields by xPath
    And Clicks Change button
    Then The text message is "<error_message>"


    Examples:
      | language   | error_message          |
      | English    | ??                     |
      | Українська | ??                     |
      | Portuguesa | ??                     |
      | Русский    | Пароль успешно изменен |

  Scenario Outline: Verify text Bad password message in all language
    When User clicks on Change language button
    And User chooses "<language>" language
    And User clicks expand button of the Changing the password block
    And User sends wrong password2 in the Current Password field by xPath
    And password2 in New password and Password confirmation fields by xPath
    And Clicks Change button
    Then The text bedPassword message is "<error_message>"


    Examples:
      | language   | error_message                 |
      | English    | Произошла ошибка Bad password |
      | Українська | ??                            |
      | Portuguesa | ??                            |
      | Русский    | Произошла ошибка Bad password |


  Scenario Outline: Verify functionality Changing mail address
    When User clicks on Change language button
    And User chooses "<language>" language
    And User sends test.test@gm.com in the mail field
    And click on button Save
    Then success message "<text_message>" is displayed
    And User types legionqa.test@gmail.com in the mail field
    And click on button Save

    Examples:
      | language   | text_message                 |
      | English    | ??                           |
      | Українська | ??                           |
      | Portuguesa | ??                           |
      | Русский    | Аккаунт был успешно сохранен |


  Scenario: Verify functionality Changing mail address
    When User clicks on Change language button
    And User chooses "English" language
    And User sends test.test@gm.com in the mail field
    And click on button Save
    Then success message is displayed
    When User clicks Log out button
    And User login with new test email and password test.test@gm.com : password1
    Then Verify that opened page is Main Page
    And User go to new Profile page
    And User types legionqa.test@gmail.com in the mail field
    And click on button Save
    And User clicks Log out button