@eligibilitySection
Feature: Eligibility Section	
		
		@AC1
		Scenario: AC 1 - The section should contain 5 questions
		Given User is on the Eligibility Page
		When Select all Yes radiobutton
		Then Verify Number of Eligibility questions
		And Validate all 5 questions
		
		@AC2
		Scenario: AC 2 - Each question can be answered Yes or No through radio buttons
		Given User is on the Eligibility Page
		When Select all Yes radiobutton
		And Select all No radiobutton
		And Click on Save button
		Then Verify radiobuttons are in Selected State
		
		@AC3
		Scenario: AC 3 - Answering No for any of the questions should display a warning message
		Given User is on the Eligibility Page
		When User click on No radiobutton
		Given Verify Warning Message when select No radiobutton
		
		@AC4
		Scenario: AC 4 - Clicking the link in the warning message in AC 3 will launch a website in another window tab to the url
		Given User is on the Eligibility Page
		When Click on the FAQ link
		Then Verify FAQ Url
		
		@AC5
		Scenario: AC 5 - Clicking ‘Save’ will save the Applicant’s inputs and refreshing the page should reload the saved values
		Given User is on the Eligibility Page
		When Click on Save button
		Then Verify radiobuttons are in Selected State