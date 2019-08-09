Feature: Login to Facebook and Check for Homepage
  @Login
  Scenario: Facebook Login
  Given User Navigates to Landing Page
    |https://webuildsg.github.io/data/|We Build SG Data|
    Then Validate Number of elements under list graph
    |11|
    And Validate element Names under list graph
    |repos per week|events per week|activities per programming languages|active user groups|active repositories|repositories per programming language|event day of week|event per week of month|event duration|event time of day|event locations|
