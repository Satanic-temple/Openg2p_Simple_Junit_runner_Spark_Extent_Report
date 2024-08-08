Feature: IndividualCreation

Background:
Given user has already logged in to application
|username|password|
|test@gmail.com|test12|

Scenario: Individual page title verification
Given User is on Individual list view page
Then User gets Individual page title
And Individual page title should be "OpenG2P - Individuals"

Scenario: Individual Creation page title verification  
Given User is on Individual list view page
When User clicks on New button
Then User gets Individual Creation page title
And Individual Creation page title should be "OpenG2P - Individuals"

Scenario: Multiple Individual creation 
Given User is on Individual list view page
When User clicks on New button
And User enters Follwong Individual names
|family_name|given_name|
|fn1|gn1|
|fn2|gn2|
|fn3|gn3|
And User Clicks on save button
Then User gets Individual Creation page title

Scenario: Validating Individual records
Given User is on Individual list view page
When User enters search keyword press Enter
Then User gets Individual records
And Individual name should be "fn3, gn3"