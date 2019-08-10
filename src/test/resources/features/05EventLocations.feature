Feature: Login to Facebook and Check for Homepage
  Background:
    Given User Navigates to Landing Page
      |https://webuildsg.github.io/data/|We Build SG Data|
    When Navigate to EventLocation Page
  @Login
  Scenario: Validate Count and Groups Name of Active Users Group
    Then Validate Popular Event Location Map
    And Validate Map Script Details
    |https://www.google-analytics.com/analytics.js|





