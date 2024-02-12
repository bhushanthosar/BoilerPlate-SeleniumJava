package StepDefinitions;

import com.pages.ContactDetailsSection;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactDetailsSectionStep {

	private ContactDetailsSection contactDetails = new ContactDetailsSection();

	@Given("^User navigates to Contact Details Section$")
	public void userNavigatesToContactDetailsSection() throws Throwable {
		contactDetails.clickOnContactDetails();
	}

	@Then("^Provide Main Contact Person Details$")
	public void verifyTheNameJobTitleContactNoEmailAlternateContactPersonSEmailMailingAddress() throws Throwable {
		contactDetails.verifyMainContactSection();
	}

	@When("^user provide postal code \"([^\"]*)\"$")
	public void userProvidePostalCode(String postalCode) throws Throwable {
		contactDetails.verifyPostalCode(postalCode);
	}

	@Then("^Verify Block Hse No and Street details$")
	public void verifyBlockHseNoAndStreetDetails() throws Throwable {
		contactDetails.verifyAutoPopulatedStreetAndBlkNo();
	}

	@Then("^Application auto-populate Mailing Address details from the Applicant’s Company Profile$")
	public void applicationAutoPopulateMailingAddressDetailsFromTheApplicantSCompanyProfile() throws Throwable {
		contactDetails.verifyDetailsAfterSelectRegisterAddess();
	}

	@When("^User click on checkbox Same as registered address in Company Profile$")
	public void userClickOnCheckboxSameAsRegisteredAddressInCompanyProfile() throws Throwable {
		contactDetails.clickOnSameAsRegisteredAddess();
	}

	@Then("^Verify the subsection fields$")
	public void verifyTheSubsectionFields() throws Throwable {
		contactDetails.verifySubsectionFields();
	}

	@When("^User provides the details in Main conatct person section$")
	public void userProvidesTheDetailsInMainConatctPersonSection() throws Throwable {
		contactDetails.provideTheDetailsInMainSection();
	}

	@And("^Click on Same as main contact person checkbox$")
	public void clickOnSameAsMainContactPersonCheckbox() throws Throwable {
		contactDetails.clickOnSameAsMainContactPersonCheckBox();
	}

	@Then("^App should populates these details under the SubSection$")
	public void appShouldPopulatesTheseDetailsUnderTheSubSection() throws Throwable {
		contactDetails.verifySubSectionDetails();
	}

	@And("^Verify data saved after reload the page for Contact Details$")
	public void verifyDataSavedAfterReloadThePageForContactDetails() throws Throwable {
		contactDetails.verifySubSectionDetails();
	}

	@When("^User provide invalid postal code \"([^\"]*)\"$")
	public void userProvideInvalidPostalCode(String postalCode) throws Throwable {
		contactDetails.verifyPostalCode(postalCode);
	}

	@Then("^Verify Error message for \"([^\"]*)\" Postal Code$")
	public void verifyErrorMessageForPostalCode(String arg1) throws Throwable {
		contactDetails.verifyInvalidPostalCodeErrorMessage();
	}

}
