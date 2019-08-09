Feature: Login to Facebook and Check for Homepage
  Background:
    Given User Navigates to Landing Page
      |https://webuildsg.github.io/data/|We Build SG Data|
    Then Navigate to Repositories Page
  @Login
  Scenario: Validate Count of Available Languages in Repositories
    Then Validate Expected Number of Available Languages
    |20|
    And Validate Languages Names
      |1|C|
      |2|C++|
      |3|Clojure|
      |4|CoffeeScript|
      |5|CSS|
      |6|Go|
      |7|Haskell|
      |8|HTML|
      |9|Java|
      |10|JavaScript|
      |11|Julia|
      |12|Objective-C|
      |13|PhP|
      |14|Python|
      |15|R|
      |16|Ruby|
      |17|Rust|
      |18|Shell|
      |19|Swift|
      |20|Tex|



