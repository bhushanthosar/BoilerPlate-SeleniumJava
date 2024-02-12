package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;

import com.qa.utils.PropertiesReader;

public class EligibilitySection extends BaseClass {

	private By firstNoRadioBtn = By.xpath(
			"//*[contains(text(),'Is the applicant registered in Singapore?')]/following::*[@class='bgp-label' and text()='No'][1]");
	private By checkEligibilityPageTitle = By.xpath("//*[text()='Check Your Eligibility']");
	private By checkEligibilityLabel = By.xpath("//*[text()='Eligibility']");
	private By eligibilityQuestions = By.xpath("//*[@class='control-label bgp-label']");
	private By numberOfEligibilityQuestions = By.xpath("//*[@class='control-label bgp-label']");
	private By selectAllYesRadioBtn = By
			.xpath("//*[@class='bgp-label' and text()='Yes']/../span[@class='radiobutton']");
	private By selectAllNoRadioBtn = By.xpath("//*[@class='bgp-label' and text()='No']/../span[@class='radiobutton']");
	private By warningMessageForNo = By.xpath("//*[@class='field-warning-text']");
	private By faqLink = By.xpath("//*[@href='https://www.gobusiness.gov.sg/business-grants-portal-faq/get-a-grant/']");
	private By saveBtn = By.xpath("//*[@id='save-btn']");

	String actualFAQUrl = "https://www.gobusiness.gov.sg/business-grants-portal-faq/get-a-grant/";

	public EligibilitySection() {
		super();
	}

	public void verifyCheckEligibilityPage() {
		waitForElementToBeClickable(checkEligibilityPageTitle).click();
	}

	public void clickOnCheckEligibilityPage() {
		waitForElementToBeClickable(checkEligibilityLabel).click();
	}

	public void verifyNumberOfQuestions() {
		verifyNumberOfQuestions(numberOfEligibilityQuestions);
	}

	public void validateAll5Questions() {
		List<String> actualQuestions = new ArrayList<String>();
		List<String> expectedQuestions = new ArrayList<String>();
		driver.findElements(eligibilityQuestions).forEach(
				b -> actualQuestions.add(b.getText().replace("*", "").replace("\n", "").replace("\r", "").trim()));
		Properties qProperties = new PropertiesReader()
				.getProperties("./src/test/resources/TestData/eligibilitySection.properties");
		for (Object key : qProperties.keySet()) {
			expectedQuestions.add(qProperties.getProperty(key.toString().replace("\n", "").replace("\r", "")));

		}

		Assert.assertTrue(actualQuestions.containsAll(expectedQuestions));

	}

	public void selectAllYes() {
		waitForAllElementsToBeVisible(selectAllYesRadioBtn).stream().forEach(a -> a.click());
	}

	public void selectAllNo() {
		waitForAllElementsToBeVisible(selectAllNoRadioBtn).stream().forEach(a -> a.click());
	}

	public void clickOnNoRadioButton() {
		waitForElementToBeVisible(firstNoRadioBtn).click();
	}
	
	public void verifyWarningMessageForNoAnswer() {
		waitForElementToBeVisible(warningMessageForNo);
	}

	public void clickOnFAQLink() {
		waitForElementToBeVisible(faqLink).click();
	}
	
	public void verifyFQAUrl() {
		switchToFaqWindow(actualFAQUrl);
	}

	public void switchToFaqWindow(String actualFAQUrl) throws NoSuchWindowException {
		Set<String> handles = driver.getWindowHandles();
		String current = driver.getWindowHandle();
		if (handles.size() > 1) {
			handles.remove(current);
		}
		String newTab = handles.iterator().next();
		driver.switchTo().window(newTab);
		String faqUrl = driver.getCurrentUrl();

		Assert.assertEquals(faqUrl, actualFAQUrl);

	}

	public void clickOnSaveBtn() throws InterruptedException {

		waitForElementToBeClickable(saveBtn).click();
		Thread.sleep(5000);
	}

	public void reloadThePage() {
		driver.navigate().refresh();
	}

	public void verifyDataAfterReload() {
		waitForAllElementsToBeVisible(selectAllYesRadioBtn).stream().forEach(a -> a.isSelected());

	}

	public void verifyEligibilitySectionPrevoiusData() {
		waitForAllElementsToBeVisible(selectAllYesRadioBtn).stream().forEach(a -> a.isSelected());

	}

	public WebElement verifyNumberOfQuestions(By locator) {
		int count = driver.findElements(locator).size();
		if (count == 5) {
			System.out.println("Eligibility page has total 5 questions");
		}

		return null;

	}

}
