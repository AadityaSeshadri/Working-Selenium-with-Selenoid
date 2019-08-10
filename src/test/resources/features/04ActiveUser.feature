Feature: Active User Group Page Validations
  Background:
  Given User Navigates to Landing Page
  |https://webuildsg.github.io/data/|We Build SG Data|
  When Navigate to ActiveUser Page
  @Smoke
  Scenario: Validate Count and Groups Name of Active Users Group-Failure of One Data Variant Expected
  Description: Validation of When User Clicks Active User Group ,System shows total count of Active User Group ,Group Name and Number of Users
  Things to Consider-
  1.With Interest to time for execution have set data variants for first 9, could be tested to all by inserting more data variants
  2.To Add New Row, first column is the Index, second column is Group Name as in Page , Third being Number of Active Users
  3.One of Scenario Purposely Made to fail to showcase Framework Handling of Failure
  Then Validate Total Count of Active User Group
  |46|
  And Validate Group Name Count of Users and Last Updated DateTime
  |1|.NET Developers Singapore|5|
  |2|IoTSG                   |9|
  |3|Agile Singapore          |6|
  |4|AnalyticsTech            |6|
  |5|ArtScience Museum        |33|
  |6|Clojure Meetup           |5 |
  |7|CodingGirls              |10|
  |8|Creative Crew Singapore  |7 |
  |9|DataKind                 |9 |

  Scenario: Clicking on Group Name Navigates to Meet up Website
  Description: Validate When any of Group name is clicked is navigated to Meet up Page
  Thinks to Consider: Only Meet up Page Title is Validated
  To Test for another Group - Fill as
  Group Name in When
  Meetup Group name Visible in Meet up Page
  When Clicked on Group Name
  |.NET Developers Singapore|
  Then Navigated to Meetup Website
  |.NET Developers Community Singapore|






