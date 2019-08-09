Feature: Login to Facebook and Check for Homepage
  @Login
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
      When User Clicks Link on Footer
      |Twitter||





