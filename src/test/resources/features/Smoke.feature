Feature: Login to Facebook and Check for Homepage
  @Login
  Scenario: Facebook Login
    Given User Navigates to Landing Page
    |https://webuildsg.github.io/data/|We Build SG Data|
    Then Validate Number of elements under list graph
    |11|
    And Validate element Names under list graph
    |repos per week|events per week|activities per programming languages|active user groups|active repositories|repositories per programming language|event day of week|event per week of month|event duration|event time of day|event locations|
    And Validate Yearly Report
    |2015|129|975|803|181|
    |2016|242|3517|921|193|
    |2017|330|3893|860|226|
    And Validate Navigations When Links from List Graph clicked
    |repos per week|repositories updated per week|
    |events per week|repositories updated per week|
    |activities per programming languages|repositories updated per week|
    |active user groups|repositories updated per week|
    |active repositories|repositories updated per week|
    |repositories per programming language|repositories updated per week|
    |event day of week|repositories updated per week|
    |event per week of month|repositories updated per week|
    |event duration|repositories updated per week|
    |event time of day|repositories updated per week|
    |event locations|repositories updated per week|

