@login @switch
Feature: Visibility, languages and links

  Background:
    Given User navigates to My sites page

  Scenario: Activate/inactivate switch and pop-up messages
    When User clicks activate-inactivate switch in the Test site SearchKey1 line
    Then Activation message is displayed
    When User clicks OK button of the activation message
    Then Activation message is disappearing
    And Activate-inactivate switch in Test site SearchKey1 line is on
    And Switch tooltip text is Inactivate
    When User clicks activate-inactivate switch in the Test site SearchKey1 line
    Then Inactivation warning is displayed
    When User clicks Cancel button of the inactivation warning
    Then Inactivation warning is disappearing
    And Activate-inactivate switch in Test site SearchKey1 line is on
    And Switch tooltip text is Inactivate
    When User clicks activate-inactivate switch in the Test site SearchKey1 line
    And User clicks Go button of the Inactivation warning
    Then Inactivation message is displayed
    When User clicks Ok button of the inactivation message
    Then Inactivation message is disappearing
    And Activate-inactivate switch in Test site SearchKey1 line is off
    And Switch tooltip text is Activate

  Scenario Outline: Site line language - activate/inactivate switch tooltips
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User clicks activate-inactivate switch in the Test site SearchKey1 line
    And User clicks OK button of the activation message
    Then Switch tooltip is "<inactivate>"
    When User clicks activate-inactivate switch in the Test site SearchKey1 line
    And User clicks Go button of the Inactivation warning
    And User clicks Ok button of the inactivation message
    Then Switch tooltip is "<activate>"

    Examples:
      | language   | activate | inactivate |
      | English    | ?????    | ?????      |
      | Русский    | Включить | Выключить  |
      | Українська | ?????    | ?????      |
      | Portuguesa | ?????    | ?????      |


  Scenario Outline: Site line language - activation/inactivation messages
    When User clicks Change language button - My sites
    And User chooses "<language>" language
    And User clicks activate-inactivate switch in the Test site SearchKey1 line
    Then Pop-up message with "<activate_message>" text and "<ok>" button appears
    When User clicks OK button of the activation message
    And User clicks activate-inactivate switch in the Test site SearchKey1 line
    Then Pop-up warning with text "<warning>", "<cancel>" and "<go>" buttons appears
    When User clicks Go button of the Inactivation warning
    Then Pop-up message with "<inactivate_message>" text and "<ok>" button appears

    Examples:
      | language   | activate_message                          | inactivate_message                            | warning                                                        | ok | cancel  | go         |
      | English    | ???????                                   | ???????                                       | ???????                                                        | OK | ??????? | ???????    |
      | Русский    | АктивацияВаш сайт был успешно активирован | ДеактивацияВаш сайт был успешно деактивирован | Подтвердите ваше действиеВаш сайт станет не активным в системе | OK | Отмена  | Продолжить |
      | Українська | ???????                                   | ???????                                       | ???????                                                        | OK | ??????? | ???????    |
      | Portuguesa | ???????                                   | ???????                                       | ???????                                                        | OK | ??????? | ???????    |