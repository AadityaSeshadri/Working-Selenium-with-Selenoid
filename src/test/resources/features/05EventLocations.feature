Feature: Event Location Page Validations
  Background:
  Given User Navigates to Landing Page
  |https://webuildsg.github.io/data/|We Build SG Data|
  When Navigate to EventLocation Page
  @EventLocation
  Scenario: Validate Count and Groups Name of Active Users Group
  Description: When Clicked on Event Page ,Map Visibility and Map Source is Validated
  Then Validate Popular Event Location Map
  And Validate Map Script Details
  |https://www.google-analytics.com/analytics.js|





