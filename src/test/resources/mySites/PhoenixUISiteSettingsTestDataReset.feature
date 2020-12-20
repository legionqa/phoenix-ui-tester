@login @reset
Feature: Site settings page test

  Background:
    Given User navigates to My sites page
    And User clicks Settings button of the Test site SearchKey1 line


  Scenario: Saved data in the Sites table
    When User types Test site 4 in the Site's name field
    And User types Test site 4 URL in the URL field
    And User selects Active in the Status drop-down menu
    And User clicks Save button
    Then My Sites page opens
    And There is the Test site 4 line in the Sites table
    And URL of Test site 4 is correct
    And Test site 4 status is Active

  Scenario: Saving data - Save button
    When User selects News in the Category list
    And User selects Ukraine in the Country list
    And User selects Awadhi in the Language list
    And User types qwerty in the Black list of words field
    And User types qwerty in the ?utm_source=phoenix field
    And User clicks Save button
    Then My Sites page opens
    When User clicks Settings button of the Test site SearchKey1 line
    Then News is selected in the Category list
    And Ukraine is selected in the Country list
    And Awadhi is selected in the Language list
    And ?utm_source=phoenix field contains qwerty
    And Black list of words field contains qwerty

  Scenario: Saving data - Enter key
    And User types Test site 4 in the Site's name field
    And User pres the Enter key
    Then My Sites page opens
    Then There is the Test site 4 line in the Sites table

  Scenario Outline: Language switch - Saved message
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User types Test site 4 in the Site's name field
    And User clicks Save button
    Then My Sites page opens
    And The message with text "<message>" is displayed

    Examples:
      | language   | message   |
      | English    | ?????     |
      | Русский    | Сохранено |
      | Українська | ?????     |
      | Portuguesa | ?????     |