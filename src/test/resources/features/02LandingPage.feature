Feature: Landing Page Validations
  Background:
  Given User Navigates to Landing Page
  |https://webuildsg.github.io/data/|We Build SG Data|

  Scenario: Validate Search Criteria- Need to Fill Search Text under When Step and Expected list to appear in Then Step with Yes or No
  Description: Purpose of this Scenario to test Below tests
  1.When----When User Enters Value in Box (Passed from Step)
  2.Then----Graph List elements Marked as Yes is expected to be displayed
  On Change of Behavior Graph List needs to be Updated to Expectation of appearance with Yes or No
  Things under Consideration-
  There are few discrepancies with respect to System Behavior (On typing Event as Keyword ->Active User Group Appears)
  Hence Assuming one of Condition for Keyword Search with event .
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
  Description:Validation of External Social Links connectivity  When  Clicked on Social Media Links appearing
  Things Under Consideration- Only Page Title of External Social System is Validated
  When User Clicks Social Media Links on Footer and Validate Connectivity to External Social Media

  Scenario: Validate Suggestions Link point to Twitter Page
  Description:Validation of Twitter Connectivity When  Clicked on Suggestions Link
  Things Under Consideration- Only Page Title of External Social System is Validated
  When User Clicks on Suggestion Link
  Then User Navigated to Twitter Page of We Build SG

  Scenario: Validate Pull Request Link point to Twitter Page
  Description:Validation of Twitter Connectivity When  Clicked on Pull Request Link
  Things Under Consideration- Only Page Title of External Social System is Validated
  When User Clicks on Pull Request Link
  Then User Navigated to Github Page of We Build SG






