@TutorialsNinjaRegister
Feature: Register functionality of TutorialsNinja

@MandatoryFields
Scenario: Register with mandatory fields
    Given User navigates to RegisterPage
		When User enter below mandatory fields
    |firstname       | Selenium       |
    |lastname        | Panda          |
    |telephone       | 987654321      |
    |password        | Selenium@123   |
    |confirmpassword | Selenium@123   |
    And User selects PrivacyPolicy checkbox
    When User clicks on Conintue button
   	Then User account gets created succesfully
    
@AllFields
Scenario: Register with all fields
    Given User navigates to RegisterPage
    When User enter below all fields
    |firstname       | Selenium       |
    |lastname        | Panda          |
    |telephone       | 987654321      |
    |password        | Selenium@123   |
    |confirmpassword | Selenium@123   |
    And User selects Yes for newletter
    And User selects PrivacyPolicy checkbox
     When User clicks on Conintue button
    Then User account gets created succesfully
    
    
    @DuplicateEmail
Scenario: Register with existing email
    Given User navigates to RegisterPage
    When User enter below all fields with existing email
    |firstname       | Selenium              |
    |lastname        | Panda                 |
    |email					 |seleniumpanda@gmail.com| 
    |telephone       | 987654321             |
    |password        | Selenium@123          |
    |confirmpassword | Selenium@123          |
    And User selects Yes for newletter
    And User selects PrivacyPolicy checkbox
     When User clicks on Conintue button
    Then User account gets warning message of duplicate email 
    
     @NoFields
Scenario: Register with no fields entered
     Given User navigates to RegisterPage
    When User clicks on Conintue button
    Then User account gets PrivacyPolicy warning message

 