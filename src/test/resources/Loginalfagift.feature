Feature: Login

Scenario: Login Valid and verify welcome screen

    Given user click Login on Login screen
    And user input username
    And user input Password 
    When user click button Login
    Then user displayed welcome screen
