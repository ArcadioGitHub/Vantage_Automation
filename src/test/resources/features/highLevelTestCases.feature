# Author: Vantage_QA_TEAM

@HighLevelTestCases
Feature: Vantage_Automation

  @TC-01
  Scenario: Verify with correct URL for staging/Live home page loads within seconds
    Given the user goes to the staging/Live page
    Then the user should see all page elements

  @TC-03
  Scenario Outline: Verify that the user is able to create his/her Account
    Given the user goes to the staging/Live page
    When  the user performs the registration process as an <role>
    Then the user should see the welcome message for his <role>
    Examples:
      | role       |
      | student    |
      | instructor |







