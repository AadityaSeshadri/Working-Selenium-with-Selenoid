Feature: Login to Facebook and Check for Homepage
  Background:
    Given User Navigates to Landing Page
      |https://webuildsg.github.io/data/|We Build SG Data|
    When Navigate to ActiveUser Page
  @Login
  Scenario: Validate Count and Groups Name of Active Users Group
    Then Validate Total Count of Active User Group
    |46|
    And Validate Group Name Count of Users and Last Updated DateTime





