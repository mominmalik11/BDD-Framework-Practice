@TutorialsNinjaLogin2
Feature: Login functionality of TutorialsNinja

@ValidCredentials
Scenario: Login with valid credentials
Given User navigates to LoginPage
When User enters valid email 'seleniumpanda@gmail.com' 
And user enters valid password 'Selenium@123'
And user clicks on Login button 
Then user is navigated to the AccountPage

@InvalidCredentials
Scenario: Login with invalid credentials
Given User navigates to LoginPage
When User enters invalid email 'seleniumpanda123456798@gmail.com' 
And user enters invalid password 'Selenium@123456'
And user clicks on Login button 
Then user gets warning message about the credentials mismatch

@ValidEmailInvalidPassword
Scenario: Login with invalid credentials
Given User navigates to LoginPage
When User enters valid email 'seleniumpanda@gmail.com' 
And user enters invalid password 'Selenium@123456'
And user clicks on Login button 
Then user gets warning message about the credentials mismatch

@InvalidEmailValidPassword
Scenario: Login with invalid credentials
Given User navigates to LoginPage
When User enters invalid email 'seleniumpanda123456798@gmail.com' 
And user enters valid password 'Selenium@123'
And user clicks on Login button 
Then user gets warning message about the credentials mismatch

@NoCredentials
Scenario: Login with no credentials
Given User navigates to LoginPage
And user clicks on Login button 
Then user gets warning message about the credentials mismatch
