Feature: Changing and saving user mail, name, password - Profile page

  Scenario: Verify functionality Changing the password
    When User login with test email and password legionqa.test@gmail.com : password1
    And User go to new Profile page
    And User clicks expand or collapse button of the Changing the password block
    And User sends current password in the Current password field
    And password2 in New password and Password confirmation fields
    And Clicks Change button
    Then success message is displayed
    And Return all the data to its original

  Scenario: Verify functionality Changing mail address
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