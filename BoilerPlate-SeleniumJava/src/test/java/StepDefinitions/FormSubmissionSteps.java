package StepDefinitions;

import java.util.Properties;

import com.pages.BusinessImpactSection;
import com.pages.CompanyProfileSection;
import com.pages.ContactDetailsSection;
import com.pages.CostSection;
import com.pages.DeclareReviewSection;
import com.pages.EligibilitySection;
import com.pages.ProposalSection;
import com.qa.utils.PropertiesReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormSubmissionSteps {

	private DeclareReviewSection declareReviewDetails = new DeclareReviewSection();
	private EligibilitySection eligibilityDetails = new EligibilitySection();
	private ContactDetailsSection contactDetails = new ContactDetailsSection();
	private ProposalSection proposalDetails = new ProposalSection();
	private BusinessImpactSection businessImpactDetails = new BusinessImpactSection();
	private CostSection costDetails = new CostSection();
	private CompanyProfileSection companyProfileDetails = new CompanyProfileSection();

	Properties qProperties = new PropertiesReader().getProperties("./src/test/resources/config/Config.properties");

	@Given("^User missing some mandatory fields$")
	public void userMissingSomeMandatoryFields() throws Throwable {
		// declareReviewDetails.navigateToDeclareAndReviewSection();
	}

	@When("^Click Review button under Declare and Review Section$")
	public void clickReviewButtonUnderDeclareAndReviewSection() throws Throwable {
		declareReviewDetails.clickOnReviewBtn();
	}

	@Then("^Application should show the count of error messages$")
	public void applicationShouldShowTheCountOfErrorMessages() throws Throwable {
		declareReviewDetails.verifyTheErrorMessages();
	}

	@Given("^User filling all the mandatory fields for all form section$")
	public void userFillingAllTheMandatoryFields() throws Throwable {
		// eligibilityDetails.selectAllNo();
		eligibilityDetails.selectAllYes();
		contactDetails.clickOnContactDetails();
		contactDetails.clickOnSameAsRegisteredAddess();
		contactDetails.provideTheDetailsInMainSection();
		contactDetails.clickOnSameAsMainContactPersonCheckBox();
		proposalDetails.clickOnProposalSection();
		proposalDetails.provideTheProposalDetails();
		businessImpactDetails.clickOnBusinessImpactSection();
		businessImpactDetails.provideTheBusinessImpactDetails();
		costDetails.clickOnCostSection();
		costDetails.provideTheCostDetails();
	}

	@When("^Click on Delare & Review Section$")
	public void clickOnDeclareAndReviewButtons() throws Throwable {
		declareReviewDetails.navigateToDeclareAndReviewSection();
	}

	@And("^User Selects all the Radio button as NO$")
	public void userSelectsAllTheRadioButtonAsNO() throws Throwable {
		declareReviewDetails.selectAllNo();
	}

	@Given("^User now at Declare and Acknowledge Terms page$")
	public void userAtDeclareAndAcknowledgePage() throws Throwable {
		declareReviewDetails.verifyDeclareAcknowledgeTermsPageTitle();
	}

	@When("^Click on Consent and Acknowledgement checkbox$")
	public void verifyConsentAndAcknowledgementCheckboxAndClickOnIt() throws Throwable {
		declareReviewDetails.clickOnconsentAndAcknowledgeCheckbox();
	}

	@And("^User click on Review button$")
	public void userClickOnReviewButton() throws Throwable {
		declareReviewDetails.clickOnReviewBtn();
	}

	@And("^User navigates to read-only summary page$")
	public void userNavigatesToReadOnlySummaryPage() throws Throwable {
		companyProfileDetails.verifyReviewApplicationPageTitle();
	}

	@And("^Verify the details previously filled in each form section$")
	public void verifyThePreviouslyDetails() throws Throwable {
		eligibilityDetails.clickOnCheckEligibilityPage();
		contactDetails.clickOnContactDetails();
		contactDetails.verifyContactDetailsSectionPrevoiusData();
		proposalDetails.clickOnProposalSection();
		proposalDetails.verifyProposalSectionPrevoiusData();
		costDetails.clickOnCostSection();
		costDetails.verifyCostSectionPrevoiusData();
		declareReviewDetails.navigateToDeclareAndReviewSection();
	}

	@And("^Verify the Consent and Acknowledgement checkbox under read-only summary page$")
	public void verifyConsentAndAcknowledgementCheckboxVisibility() throws Throwable {
		companyProfileDetails.verifyConsentAndAcknowledgementCheckboxVisibility();
	}

	@And("^Click on Submit button and Navigate to Processing section under My Grants Dashboard$")
	public void clickOnSubmitButton() throws Throwable {
		companyProfileDetails.clickOnSubmitButton();
		companyProfileDetails.verifyApplicarionRefNumber();
	}
}
