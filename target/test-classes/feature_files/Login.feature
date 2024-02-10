@TutorialsNinjaLogin
Feature: Login functionality of TutorialsNinja




@ValidCredentials
Scenario: Login with valid credentials
Given User navigates to LoginPage
When User enters valid email <email> into email textbox field
And user enters valid password <password> into password textbox field
And user clicks on Login button 
Then user is navigated to the AccountPage

		Examples:
    |email										|password		|
    |seleniumpanda1@gmail.com	|Selenium@123|
    |seleniumpanda2@gmail.com	|Selenium@123|
    |seleniumpanda3@gmail.com	|Selenium@123|
    |seleniumpanda4@gmail.com	|Selenium@123|
    |seleniumpanda5@gmail.com	|Selenium@123|
    |seleniumpanda6@gmail.com	|Selenium@123|
    |seleniumpanda7@gmail.com	|Selenium@123|
		|seleniumpanda8@gmail.com	|Selenium@123|
		|seleniumpanda9@gmail.com	|Selenium@123|
		|seleniumpanda10@gmail.com	|Selenium@123|






@InvalidCredentials
Scenario: Login with invalid credentials
Given User navigates to LoginPage
When User enters invalid email  
And user enters invalid password 'Selenium@123456'
And user clicks on Login button 
Then user gets warning message about the credentials mismatch

@ValidEmailInvalidPassword
Scenario: Login with invalid credentials
Given User navigates to LoginPage
When User enters valid email <email> into email textbox field
And user enters invalid password 'Selenium@123456'
And user clicks on Login button 
Then user gets warning message about the credentials mismatch

@InvalidEmailValidPassword
Scenario: Login with invalid credentials
Given User navigates to LoginPage
When User enters invalid email  
And user enters valid password <password> into password textbox field
And user clicks on Login button 
Then user gets warning message about the credentials mismatch

@NoCredentials
Scenario: Login with no credentials
Given User navigates to LoginPage
And user clicks on Login button 
Then user gets warning message about the credentials mismatch
