Feature: Search

  As customer, I want to be able search the product on the home page, so I could discover the product that I’d like to buy

  Background:
    Given user open the Alfagift App
    And user click Enter on Welcome screen
    When user input phone number "0812858882277" on Login screen
    And user input password "12345678" on Login screen
    And user click next button on Login screen
    Then user click Nanti on User Guide

  Scenario: Verify user should discover the product after searching it with the correct keyword on the search bar

    Given user on the HomePage
    When user click field search
    And user search the product "ultra milk susu uht coklat" on the search bar
    And user see the product suggestion "ultra milk susu uht coklat" below the search bar
    And user click the product suggestion below the search bar
    Then user should discover the product "ultra milk susu uht coklat" on the search result page
