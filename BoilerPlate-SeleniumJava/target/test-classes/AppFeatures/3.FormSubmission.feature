@formSubmission
Feature: Form Submission

Background: User navigates to Declare and Review Section 
			Given User filling all the mandatory fields for all form section
			When Click on Delare & Review Section
			And User Selects all the Radio button as NO
    
    @AC1
    Scenario: AC 1 - Upon filling all mandatory inputs in all 6 form sections and clicking the ‘Review’ button in the ‘Declare and Review’ section, the Applicant should be taken to a read-only summary page
    Given User now at Declare and Acknowledge Terms page
    When Click on Consent and Acknowledgement checkbox
    And User click on Review button
    Then User navigates to read-only summary page
    
    @AC2
    Scenario: AC 2 - If there are any mandatory inputs missing, a validation error should trigger and the form should redirect to the section with the missing details
    Given User missing some mandatory fields
    When User click on Review button
    Then Application should show the count of error messages
    
    @AC3
    Scenario: AC 3 - The read-only summary page should correctly contain all the details previously filled in each form section
    Given User now at Declare and Acknowledge Terms page
    When Click on Consent and Acknowledgement checkbox
    And User click on Review button
    Then User navigates to read-only summary page
    And Verify the details previously filled in each form section
    
    @AC4
    Scenario: AC 4 - At the bottom of the read-only summary page is a final ‘Consent and Acknowledgement’ checkbox
    Given User now at Declare and Acknowledge Terms page
    When Click on Consent and Acknowledgement checkbox
    And User click on Review button
    Then User navigates to read-only summary page
    And Verify the Consent and Acknowledgement checkbox under read-only summary page
    
    @AC5-6
    Scenario: AC 5 and 6 - Once checked, the Applicant can submit the entire Application and a Success message box should be shown and Upon submission, the main ‘My Grants’ dashboard should show the Application under the ‘Processing’ tab
    Given User now at Declare and Acknowledge Terms page
    When Click on Consent and Acknowledgement checkbox
    And User click on Review button
    Then User navigates to read-only summary page
    And Click on Consent and Acknowledgement checkbox
    And Click on Submit button and Navigate to Processing section under My Grants Dashboard 
    
    
    