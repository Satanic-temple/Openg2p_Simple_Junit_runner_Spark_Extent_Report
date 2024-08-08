Feature: Login Feature

Scenario: Login page title verification
Given User is on login page
When User gets page title
Then Login page title should be "Login | My Website"

Scenario: Login with correct Credentials
Given User is on login page
When User enters Email "test@gmail.com"
And User enters password "test12"
And User clicks on login button
Then User gets Homepage title
And Homepage title should be "OpenG2P"

Scenario: Login with incorrect Credentials
Given User is on login page
When User enters Email "Deadpool@marvel.com"
And User enters password "jimmy changas"
And User clicks on login button
Then user gets Error message
And Error message should be "Login failed due to Invalid credentials !"
  