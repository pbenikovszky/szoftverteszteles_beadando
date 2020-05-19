Feature: Search on page test

  Background:
    Given User is on landing page

  Scenario:
    Given The search button is clicked
    Then Please enter search keyword message is shown

  Scenario Outline:
    Given User entered '<value>' in '<field>'
    And The search button is clicked
    Then The '<message>' is shown
    Examples:
      | value    | field            | message                    |
      | noresult | search_query_top | 0 results have been found. |
      | chiffon  | search_query_top | 2 results have been found. |
      | blouse   | search_query_top | 1 result has been found.   |