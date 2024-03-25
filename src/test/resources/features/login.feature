Feature: Login
  as user, I want to... so...

  Scenario: Verify user able to login into alfagift with valid phone number & password
    #Given user open the Alfagift App
    And user click Enter on Welcome screen
    When user input phone number "0812858882277" on Login screen
    And user input password "12345678" on Login screen
    And user click next button on Login screen
    Then user should see "Selamat Datang di Alfagift" on Home screen
