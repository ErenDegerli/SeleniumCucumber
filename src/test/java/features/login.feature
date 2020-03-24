Feature: Reset password

  Scenario: Checking reset option
    Given Initialise the browser with chrome
    And Navigate to "https://www.bbc.com/" website
    And Click on login link in homepage to land on sign in page
    When User enters email and password and logs in
    And Clicks on I forgot my password
    Then Verify that user is not able to log in
    And GetHelper is displayed
    And Close browsers

