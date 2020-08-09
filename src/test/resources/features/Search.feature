
Feature:Search functionality

  Background: Navigate to CIIT homepage
    Given I navigate to CIIT homepage
    Then I should see the company logo

  Scenario: Use search to find blog articles
    When I switch to the blog page
    And scroll to the search field
    And I click the search input field
    And the field gains focus
    When I type in java
    And the live search list appears
    And I confirm my search via pressing the enter key
    Then I will be redirected to a new page
    And the results will be listed