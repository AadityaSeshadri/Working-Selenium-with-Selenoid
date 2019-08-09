Feature: Login to Facebook and Check for Homepage

  Scenario: Validate Search Criteria- Need to Fill Search Text under When Step and Expected list to appear in Then Step with Yes or No
    Given User Navigates to Landing Page
    |https://webuildsg.github.io/data/|We Build SG Data|
    When User Enters below value on Search Edit Box
    |events|
    Then System should show below Options from list graph
      |repos per week|No|
      |events per week|Yes|
      |activities per programming languages|No|
      |active user groups|Yes|
      |active repositories|No|
      |repositories per programming language|No|
      |event day of week|Yes|
      |event per week of month|Yes|
      |event duration|No|
      |event time of day|No|
      |event locations|No|

    Scenario: Validate Social Links Connectivity to External System
    Given User Navigates to Landing Page
      |https://webuildsg.github.io/data/|We Build SG Data|
      When User Clicks Social Media Links on Footer and Validate Connectivity to External Social Media
    @Login
    Scenario: Validate Suggestions Link point to Twitter Page
      Given User Navigates to Landing Page
        |https://webuildsg.github.io/data/|We Build SG Data|
      When User Clicks on Suggestion Link
      Then User Navigated to Twitter Page of We Build SG
    @Login
    Scenario: Validate Suggestions Link point to Twitter Page
      Given User Navigates to Landing Page
        |https://webuildsg.github.io/data/|We Build SG Data|
      When User Clicks on Pull Request Link
      Then User Navigated to Github Page of We Build SG






