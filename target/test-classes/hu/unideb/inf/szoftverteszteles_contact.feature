Feature: Contact us page test
  Background:
    Given User is on landing page
    And User clicks on the contact us button

  Scenario: User tries to send empty message
    Given User enters valid email address
    And User clicks on the Send button
    Then The message cannot be blank error message is shown

  Scenario: User enters invalid email address
    Given User enters invalid email address
    And User clicks on the Send button
    Then Invalid email address error message is shown

  Scenario: User successfully sends message
    Given User enters valid email address
    And User enters message
    And User selects a subject
    And User clicks on the Send button
    Then Your message has been successfully sent to our team message is shown