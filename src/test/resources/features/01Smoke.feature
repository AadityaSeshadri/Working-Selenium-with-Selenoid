Feature: Smoke Test We Build SG App


  Scenario: Smoke Scenario
    Description: Purpose of this Scenario to test Below Steps
    1.Given----When User Navigates to Landing Page is expected to see 11 graph elements (Given)
    2.Then-----Number of Elements displayed in Graph List is 11 (On change needs to be Updated)
    3.And ----Element Name under List Graph
    4.And ----Yearly Report Displayed for 2015,2016,2017(Displayed Data Considered as Expectation , On Data Change Data needs to be Updated
    5.And-----Validate when Links of Graph List is clicked System Navigates to Other Functional Pages where Page Title of Functional Pages are Validated
    Things under Consideration- Landing Page -https://webuildsg.github.io/data/
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
    |activities per programming languages|update activities per programming languages|
    |active user groups|active user groups with > 5 events|
    |active repositories|active repos with > 10 updates|
    |repositories per programming language|repositories per programming languages|
    |event day of week|events by day of week|
    |event per week of month|events per week of month|
    |event duration|events by duration|
    |event time of day|events by time of day|
    |event locations|popular event locations|



