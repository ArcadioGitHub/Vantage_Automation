# Author: Vantage_QA_TEAM

@MiniRegression
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

  @TC-04
  Scenario Outline: Verify Student/Instructor Registration requires both User Name & email address
    Given the user goes to the staging/Live page
    When the user tries to register with no User Name and Email address <role>
    Then the user should see required field warnings according to his <role>.
    Examples:
      | role       |
      | student    |
      | instructor |

  @TC-05
  Scenario Outline: Student/Instructor Registration-Form Validation
    Given the user goes to the staging/Live page
    When the user tries to register with no data on the Registration-Form <role>
    Then the user should see the required field warnings on the registration-form according to his <role>
    Examples:
      | role       |
      | student    |
      | instructor |

  @EnrollStudent
  Scenario Outline: Enroll Students to a course.
    Given the user goes to the staging/Live page
    When  the user performs the registration process as an <role>
    And the instructor creates a course
    Then the course should be created
    When  the user performs the registration process as an <role2>
    And the new student gets enrolled on the created course in a grace period
    Then the student should see the course in his courses.
    Then the student's name and last name should be in the Gradebook grid
    When  another student performs the registration process
    And the new student gets enrolled on the created course in a grace period
    Then the student should see the course in his courses.
    Then the student's name and last name should be in the Gradebook grid
    Examples:
      | role       | role2   |
      | instructor | student |







