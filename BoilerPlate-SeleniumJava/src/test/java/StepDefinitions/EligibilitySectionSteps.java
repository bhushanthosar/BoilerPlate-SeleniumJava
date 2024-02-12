package StepDefinitions;

import com.pages.EligibilitySection;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EligibilitySectionSteps {

	private EligibilitySection elSection = new EligibilitySection();

	@Given("^User is on the Eligibility Page$")
	public void userIsOnTheEligibilityPage() throws Throwable {
		elSection.verifyCheckEligibilityPage();
	}

	@Then("^Verify Number of Eligibility questions$")
	public void verifyNumberOfEligibilityQuestions() throws Throwable {
		elSection.verifyNumberOfQuestions();
	}

	@And("^Validate all (\\d+) questions$")
	public void validateAllQuestions(int arg1) throws Throwable {
		elSection.validateAll5Questions();
	}

	@Given("^Select all Yes radiobutton$")
	public void selectAllYesRadiobutton() throws Throwable {
		elSection.selectAllYes();
	}

	@And("^Select all No radiobutton$")
	public void selectAllNoRadiobutton() throws Throwable {
		elSection.selectAllNo();
	}

	@When("^User click on No radiobutton$")
	public void userSelectsNoRadiobutton() throws Throwable {
		elSection.clickOnNoRadioButton();
	}
	
	@Given("^Verify Warning Message when select No radiobutton$")
	public void verifyWarningMessageWhenSelectNoRadiobutton() throws Throwable {
		elSection.verifyWarningMessageForNoAnswer();
	}

	@Given("^Click on the FAQ link$")
	public void clickOnTheFAQLink() throws Throwable {
		elSection.verifyWarningMessageForNoAnswer();
		elSection.clickOnFAQLink();
	}
	
	@Then("^Verify FAQ Url$")
	public void verifyTheFAQUrl() throws Throwable {
		elSection.verifyFQAUrl();
	}

	@Given("^Click on Save button$")
	public void clickOnSaveButton() throws Throwable {
		elSection.selectAllYes();
		elSection.clickOnSaveBtn();
		elSection.reloadThePage();
	}

	@Then("^Verify radiobuttons are in Selected State$")
	public void verifyDataSavedAfterReloadThePage() throws Throwable {
		elSection.verifyDataAfterReload();
	}

}
