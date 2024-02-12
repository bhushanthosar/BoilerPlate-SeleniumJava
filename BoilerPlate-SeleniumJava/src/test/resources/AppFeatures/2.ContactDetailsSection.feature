@contactDetailsSection
Feature: Contact Details Section

Background: User navigates to Contact Details Section
		
		@AC1
		Scenario: AC 1 - The page contains a ‘Main Contact Person’ subsection
		Given User navigates to Contact Details Section
		Then Provide Main Contact Person Details
		
		@AC2
		Scenario: AC 2 - The Mailing Address input should be able to take in a valid postal code which auto-populates the ‘Blk/Hse No.’ and ‘Street details’ from an external API (One-map).
		Given User navigates to Contact Details Section
		When user provide postal code "587978"
		Then Verify Block Hse No and Street details
		
		@AC3
		Scenario: AC 3 - Alternatively, there should be a checkbox ‘Same as registered address in Company Profile’ which will auto-populate Mailing Address details from the Applicant’s Company Profile. 
		Given User navigates to Contact Details Section
		When User click on checkbox Same as registered address in Company Profile
		Then Application auto-populate Mailing Address details from the Applicant’s Company Profile
		
		@AC4
		Scenario: AC 4 - The page also contains a ‘Letter of Offer Addressee’ subsection with the following inputs
		Given User navigates to Contact Details Section
		Then Verify the subsection fields
		
		@AC5
		Scenario: AC 5 - There should be an option ‘ Same as main contact person’ which will populate the subsection in AC 4 with details from the ‘Main Contact Person’ in AC 1.
		Given User navigates to Contact Details Section
		When User provides the details in Main conatct person section
		And Click on Same as main contact person checkbox
		Then App should populates these details under the SubSection
		
		@AC6
		Scenario: AC6 - Clicking ‘Save’ will save the Applicant’s inputs and refreshing the page should reload the saved values.
		Given User navigates to Contact Details Section
		When User provides the details in Main conatct person section
		And Click on Same as main contact person checkbox
		Then App should populates these details under the SubSection
		And Verify data saved after reload the page for Contact Details
		
		@AdditionalScenario1
		Scenario: Unhappy Flow - Provide invalid postal code and verify the application response
		Given User navigates to Contact Details Section
		When User provide invalid postal code "000000"
		Then Verify Error message for "000000" Postal Code
		
		@AdditionalScenario2
		Scenario: Unhappy Flow - Provide invalid postal code and verify the application response
		Given User navigates to Contact Details Section
		When User provide invalid postal code "GGYGUU"
		Then Verify Error message for "GGYGUU" Postal Code
		
		@AdditionalScenario3
		Scenario: Unhappy Flow - Provide past date for Start date and End date
		Given User navigates to Proposal Section
		When User provide past date for start and end date field
		Then Verify Error message