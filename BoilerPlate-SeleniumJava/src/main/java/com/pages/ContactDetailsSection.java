package com.pages;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.restassured.response.Response;

public class ContactDetailsSection extends BaseClass {

	private By contactDetailsLabel = By.xpath("//*[text()='Contact Details']");
	private By contactName = By.xpath("//*[@id='react-contact_info-name-label']");
	private By contactJobTitle = By.xpath("//*[@id='react-contact_info-designation-label']");
	private By contactNo = By.xpath("//*[@id='react-contact_info-phone-label']");
	private By contactEmail = By.xpath("//*[@id='react-contact_info-primary_email-label']");
	private By contactNameTextbox = By.xpath("//*[@id='react-contact_info-name']");
	private By contactJobTitleTextbox = By.xpath("//*[@id='react-contact_info-designation']");
	private By contactNoTextbox = By.xpath("//*[@id='react-contact_info-phone']");
	private By contactEmailTextbox = By.xpath("//*[@id='react-contact_info-primary_email']");
	private By contactAlternateEmail = By.xpath("//*[@id='react-contact_info-secondary_email-label']");
	private By contactMailingAddress = By.xpath("//*[text()='Mailing Address']");
	private By postalCodeTextbox = By.xpath("//*[@id='react-contact_info-correspondence_address-postal']");
	private By blkHouseNumber = By.xpath("//*[@id='react-contact_info-correspondence_address-block']");
	private By street = By.xpath("//*[@id='react-contact_info-correspondence_address-street']");
	private By level = By.xpath("//*[@id='react-contact_info-correspondence_address-level']");
	private By unit = By.xpath("//*[@id='react-contact_info-correspondence_address-unit']");
	private By checkSameAsRegisterAddress = By.xpath("//*[@id='react-contact_info-correspondence_address-copied']");
	private By contactSubSectionname = By.xpath("//*[@id='react-contact_info-offeree_name-label']");
	private By contactSubSectionJobTitle = By.xpath("//*[@id='react-contact_info-offeree_designation-label']");
	private By contactSubSectionEmail = By.xpath("//*[@id='react-contact_info-offeree_email-label']");
	private By checkSameAsMainContactPerson = By.xpath("//*[@id='react-contact_info-copied']");
	private By populatedMainContactName = By.xpath("//*[@id='react-contact_info-offeree_name']");
	private By populatedMainConactJobTitle = By.xpath("//*[@id='react-contact_info-offeree_designation']");
	private By populatedMainContactEmail = By.xpath("//*[@id='react-contact_info-offeree_email']");
	private By readOnlyContactInfoName = By.xpath("//*[@id='react-contact_info-name']");
	private By readOnlyJobTitle = By.xpath("//*[@id='react-contact_info-designation']");
	private By readOnlyContactNo = By.xpath("//*[@id='react-contact_info-phone']");
	private By readOnlyEmail = By.xpath("//*[@id='react-contact_info-primary_email']");
	private By postalCodeErrorMessage = By.xpath("//*[@id='react-contact_info-correspondence_address-postal-alert']");

	public ContactDetailsSection() {
		super();
	}

	public void clickOnContactDetails() throws InterruptedException {
		waitForElementToBeClickable(contactDetailsLabel).click();
	}

	public void verifyMainContactSection() throws InterruptedException {
		waitForAllElementsToBeVisible(contactName);
		waitForAllElementsToBeVisible(contactJobTitle);
		waitForAllElementsToBeVisible(contactNo);
		waitForAllElementsToBeVisible(contactEmail);
		waitForAllElementsToBeVisible(contactAlternateEmail);
		waitForAllElementsToBeVisible(contactMailingAddress);
	}

	public void verifyPostalCode(String postalCode) {
		waitForElementToBeClickable(postalCodeTextbox).sendKeys(postalCode);

	}

	public void verifyAutoPopulatedStreetAndBlkNo() {

		String expectedBlkHsNumber = waitForElementTextToBePresent(blkHouseNumber).getAttribute("value");
		String expectedStreet = waitForElementTextToBePresent(street).getAttribute("value");
		String postalCode = waitForElementToBeClickable(postalCodeTextbox).getAttribute("value");

		Response response = given().baseUri("https://developers.onemap.sg/commonapi/search")
				.param("searchVal", postalCode).param("returnGeom", "Y").param("getAddrDetails", "Y")
				.param("pageNum", 1).get().then().extract().response();

		Assert.assertEquals("Verify Block Number", expectedBlkHsNumber,
				response.jsonPath().getString("results[0].BLK_NO").toString());
		Assert.assertEquals("Verify Street", expectedStreet,
				response.jsonPath().get("results[0].ROAD_NAME").toString());
	}
	
	public void verifyInvalidPostalCodeErrorMessage() {
		String expectedErrorMsg = waitForElementTextToBePresent(postalCodeErrorMessage).getAttribute("value");
		Assert.assertEquals("Verify Error for Invalid Postal Code", expectedErrorMsg, getProperty("actualPostalCode").toString());
	}

	public void clickOnSameAsRegisteredAddess() {
		waitForElementToBeClickable(checkSameAsRegisterAddress).click();
	}

	public void verifyDetailsAfterSelectRegisterAddess() throws InterruptedException {
		String expectedPostalCode = waitForElementTextToBePresent(postalCodeTextbox).getAttribute("value");
		String expectedBlkHsNumber = waitForElementTextToBePresent(blkHouseNumber).getAttribute("value");
		String expectedStreet = waitForElementTextToBePresent(street).getAttribute("value");
		String expectedLevel = waitForElementTextToBePresent(level).getAttribute("value");
		String expectedUnit = waitForElementTextToBePresent(unit).getAttribute("value");

		Assert.assertEquals("Verify Postal Code", expectedPostalCode, getProperty("actualPostalCode").toString());
		Assert.assertEquals("Verify Block Number", expectedBlkHsNumber, getProperty("actualBlkNumber").toString());
		Assert.assertEquals("Verify Street", expectedStreet, getProperty("actualStreet").toString());
		Assert.assertEquals("Verify Level", expectedLevel, getProperty("actualLevel").toString());
		Assert.assertEquals("Verify Unit", expectedUnit, getProperty("actualUnit").toString());

	}

	public void verifySubsectionFields() {
		waitForAllElementsToBeVisible(contactSubSectionname);
		waitForAllElementsToBeVisible(contactSubSectionJobTitle);
		waitForAllElementsToBeVisible(contactSubSectionEmail);
	}

	public void provideTheDetailsInMainSection() throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToBeClickable(contactNameTextbox).sendKeys(getProperty("mainContactPersonName").toString());
		waitForElementToBeClickable(contactJobTitleTextbox)
				.sendKeys(getProperty("mainContactPersonJobTitle").toString());
		waitForElementToBeClickable(contactNoTextbox).sendKeys(getProperty("mainContactPersonContactNo").toString());
		waitForElementToBeClickable(contactEmailTextbox).sendKeys(getProperty("mainContactPersonEMail").toString());
	}

	public void clickOnSameAsMainContactPersonCheckBox() {
		waitForElementToBeClickable(checkSameAsMainContactPerson).click();
	}

	public void verifySubSectionDetails() throws InterruptedException {
		// waitForAllElementsToBeVisible(populatedMainContactName);
		String expectedContactPersonName = waitForElementTextToBePresent(populatedMainContactName)
				.getAttribute("value");
		String expectedContactPersonJobTitle = waitForElementTextToBePresent(populatedMainConactJobTitle)
				.getAttribute("value");
		String expectedContactPersonEmail = waitForElementTextToBePresent(populatedMainContactEmail)
				.getAttribute("value");

		Assert.assertEquals("Verify Populates Main Contact Person Name", expectedContactPersonName,
				getProperty("mainContactPersonName"));
		Assert.assertEquals("Verify Populates Main Contact Person Job Title", expectedContactPersonJobTitle,
				getProperty("mainContactPersonJobTitle"));
		Assert.assertEquals("Verify Populates Main Contact Person Email", expectedContactPersonEmail,
				getProperty("mainContactPersonEMail"));

	}

	public void verifyContactDetailsSectionPrevoiusData() {
		String expectedContactInfoName = waitForElementToBeVisible(readOnlyContactInfoName).getText();
		String expectedContactInfoJobTitle = waitForElementToBeVisible(readOnlyJobTitle).getText();
		String expectedContactNo = waitForElementToBeVisible(readOnlyContactNo).getText();

		String expectedEmail = waitForElementToBeVisible(readOnlyEmail).getText();

		Assert.assertEquals("Verify Populates Company Profile Contact Person Name", expectedContactInfoName,
				getProperty("mainContactPersonName"));
		Assert.assertEquals("Verify Populates Company Profile Contact Person Job Title", expectedContactInfoJobTitle,
				getProperty("mainContactPersonJobTitle"));
		Assert.assertEquals("Verify Populates Company Profile Contact Person Job Title", expectedContactNo,
				getProperty("mainContactPersonContactNo"));
		Assert.assertEquals("Verify Populates Company Profile Contact Person Email", expectedEmail,
				getProperty("mainContactPersonEMail"));
	}

}
