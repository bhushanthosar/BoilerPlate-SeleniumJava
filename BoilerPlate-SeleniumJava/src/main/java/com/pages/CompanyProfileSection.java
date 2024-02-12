package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class CompanyProfileSection extends BaseClass {

	private By reviewYourApplication = By.xpath("//*[text()='Review Your Application']");
	private By projectTitle = By.xpath("//*[@id='react-project-title']");
	private By activity = By.xpath("//*[@id='react-project-activity']");
	private By rationaleForProjections = By.xpath("//*[@id='react-project_impact-rationale_remarks']");
	private By description = By.xpath("//*[@id='react-project_cost-office_rentals-0-description']");
	private By consentAndAcknowledge = By.xpath("//*[@class='bgp-checkboxlabel']");
	private By submitButton = By.xpath("//*[@id='submit-btn']");
	private By applicationRefNumber = By.xpath("//*[text()='Ref ID:']/following::*[@class='value'][1]");
	private By bgpLogo = By.xpath("//*[@class='bgp-logo-desktop']");
	private By processingTab = By.xpath("//*[@href='#processing']");
	private String appRefFromProcTab = "//table[@id='db-apps-processing']//tr[1]/td[text()='%s']";

	public CompanyProfileSection() {
		super();
	}

	public void verifyReviewApplicationPageTitle() {
		waitForElementToBeClickable(reviewYourApplication);

	}

	public void verifyDetailsForEachSectionInReadSummaryPage() {

		String expectedProjectTitle = waitForElementTextToBePresent(projectTitle).getText();
		String expectedActivity = waitForElementTextToBePresent(activity).getText();
		String expectedRationaleForProjections = waitForElementTextToBePresent(rationaleForProjections).getText();
		String expectedDescription = waitForElementTextToBePresent(description).getText();

		Assert.assertEquals("Verify Populates Main Contact Person Email", expectedProjectTitle,
				getProperty("projectTitle"));
		Assert.assertEquals("Verify Populates Main Contact Person Name", expectedActivity, getProperty("activity"));
		Assert.assertEquals("Verify Populates Main Contact Person Job Title", expectedRationaleForProjections,
				getProperty("rationalForProjection"));
		Assert.assertEquals("Verify Populates Main Contact Person Email", expectedDescription,
				getProperty("description"));
	}

	public void verifyConsentAndAcknowledgementCheckboxVisibility() {
		waitForElementToBeClickable(consentAndAcknowledge);
	}

	public void clickOnSubmitButton() {
		waitForElementToBeClickable(submitButton).click();

	}

	public void verifyApplicarionRefNumber() {
		String refNumber = waitForElementToBeClickable(applicationRefNumber).getText();
		waitForElementToBeClickable(bgpLogo).click();
		waitForElementToBeClickable(processingTab).click();

		String expectedAppRefNo = waitForElementToBeClickable(By.xpath(String.format(appRefFromProcTab, refNumber)))
				.getText();

		Assert.assertEquals("Verify Application Ref Number", expectedAppRefNo, refNumber);
	}
}
