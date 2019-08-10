Feature: Login to Facebook and Check for Homepage
  Background:
    Given User Navigates to Landing Page
      |https://webuildsg.github.io/data/|We Build SG Data|
    When Navigate to Repositories Page
  Scenario: Validate Count of Available Languages in Repositories
    Then Validate Expected Number of Available Languages
    |20|
    And Validate Languages Names and Repositories Under Each Language
      |1|C|7|
      |2|C++|17|
      |3|Clojure|6|
      |4|CoffeeScript|3|
      |5|CSS|14|
      |6|Go|15 |
      |7|Haskell|6|
      |8|HTML|13  |
      |9|Java|30  |
      |10|JavaScript|84|
      |11|Julia|1      |
      |12|Objective-C|22|
      |13|PHP|16        |
      |14|Python|41     |
      |15|R|3           |
      |16|Ruby|10       |
      |17|Rust|0        |
      |18|Shell|3       |
      |19|Swift|14      |
      |20|Tex|2         |

    Scenario: Validate Click from Repository Page Navigates to Github
      When Select below Programming Language
      |C|
      And Click Repo of the selected programming language
      |pili-librtmp |
      Then Should we navigated to GitHub Page of Repo
      |pili-librtmp |


