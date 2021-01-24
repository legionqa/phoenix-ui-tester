@login
Feature: Positive tests

  Background:
    Given User navigates to Profile page


  Scenario: Verify user data in the Editing of the profile block
    Then Data in the email field is 'legion.qaservices@gmail.com'
    And Data in the name field is 'Legion QA'
    And Data in the phone field is '4578974'

  Scenario: Verify that the Cancel button is appeared
    When User sends string " " in the name field
    Then Cancel button is appeared

  Scenario: Verify current user data in the user panel - Profile page
    Then Verify that user name is 'Legion QA' in the User panel
    And Verify that user email  is 'legion.qaservices@gmail.com' in the User Panel

  Scenario Outline: Verify new user data in the user panel
    When User types new data "<email_field>" in email field
    And User types new data "<user_name_field>" in name field
    Then User panel contains new "<email_field>"
    And "<user_name_field>" data displayed in the User panel

    Examples:
      | email_field                | user_name_field  |
      | wasIsDas@de.de             | Was is das       |
      | דשששששדשד@דדדדדדדדדדדדדדדץ | שדשד שדשד דגגגג  |
      | sad@x.ru                   | Отцвели уж давно |

  Scenario: Verify Phone number and Skype changing (with saving)
    When User send "030003333378910" in the Phone number field
    And User send "Ivan Ivanov" in the Skype number field
    And click on button Save
    When Success message is displayed
    And Return all the data to its original: tel '4578974' and Skype 'Legion QA'

  Scenario: Verify Cancel button action
    When User send 'was@ist.das' in the mail field
    And Click cancel button
    Then Verify that 'legion.qaservices@gmail.com' is displayed in mail field

  Scenario Outline: Verify that valid sign in the e-mail field is displayed when valid data is typed
    When User type valid data "<mail_addresses>" in the mail field
    Then Valid sign in the e-mail field are displayed

    Examples:
      | mail_addresses |
      | qwee@fas.com   |
      | abc@de.ru      |
      | a@d.ewsdfs     |

  Scenario Outline: Verify that valid sign in the name field is displayed when valid data is typed
    When User type valid data "<name_text>" in the name field
    Then Valid sign in the name field is displayed

    Examples:
      | name_text                                                  |
      | Ivan Ivanov                                                |
      | יבן יבנוו                                                  |
      | Иван Иванов                                                |
      | Pdfhff fdf-fdffffff lsfddndKDND dnd'ed QaAsddddd fkff'ssss |
      | ds   שגש שד ффы 7777фы  фыфы                               |

