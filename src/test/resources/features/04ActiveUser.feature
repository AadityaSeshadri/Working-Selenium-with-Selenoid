Feature: Login to Facebook and Check for Homepage
  Background:
    Given User Navigates to Landing Page
      |https://webuildsg.github.io/data/|We Build SG Data|
    When Navigate to ActiveUser Page

  Scenario: Validate Count and Groups Name of Active Users Group
    Then Validate Total Count of Active User Group
    |46|
    And Validate Group Name Count of Users and Last Updated DateTime
    |1|.NET Developers Singapore|5|
    |2|#IoTSG                   |9|
    |3|Agile Singapore          |6|
    |4|AnalyticsTech            |6|
    |5|ArtScience Museum        |33|
    |6|Clojure Meetup           |5 |
    |7|CodingGirls              |10|
    |8|Creative Crew Singapore  |7 |
    |9|DataKind                 |9 |

    Scenario: Clicking on Group Name Navigates to Meet up Website
    When Clicked on Group Name
     |.NET Developers Singapore|
     Then Navigated to Meetup Website
      |.NET Developers Community Singapore|






