Feature:
  as user i want to login Alfagift with phone number and password

  @TC001
  Scenario: Verify user able to login into alfagift with valid phone number & password
    #Given user open the Alfagift App
    Given user click Enter on Welcome screen
    When user input phone number "0812858882277" on Login screen
    And user input password "12345678" on Login screen
    And user click next button on Login screen
    Then user click Nanti on User Guide


