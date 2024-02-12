package com.pages;

import org.openqa.selenium.By;

public class DeclareReviewSection extends BaseClass {

	private By declareReviewLabel = By.xpath("//*[text()='Declare & Review']");
	private By reviewBtn = By.xpath("//*[@id='review-btn']");
	private By errorMessages = By.xpath("//*[contains(@class,'label-error')]");
	private By selectAllNoRadioBtn = By.xpath("//*[@class='bgp-label' and text()='No']/../span[@class='radiobutton']");
	private By consentAndAcknowledge = By.xpath("//*[@class='bgp-checkboxlabel']");
	private By declareAcknowledgeTermsPageTitle = By.xpath("//*[text()='Declare & Acknowledge Terms']");

	public DeclareReviewSection() {
		super();
	}

	public void navigateToDeclareAndReviewSection() {
		waitForElementToBeClickable(declareReviewLabel).click();
	}

	public void clickOnReviewBtn() {
		waitForElementToBeClickable(reviewBtn).click();
	}

	public void verifyTheErrorMessages() {
		waitForAllElementsToBeVisible(errorMessages).stream().forEach(a -> a.isDisplayed());

	}

	public void selectAllNo() {
		waitForAllElementsToBeVisible(selectAllNoRadioBtn).stream().forEach(a -> a.click());
	}

	public void clickOnconsentAndAcknowledgeCheckbox() {
		waitForElementToBeClickable(consentAndAcknowledge).click();
	}

	public void verifyDeclareAcknowledgeTermsPageTitle() {
		waitForAllElementsToBeVisible(declareAcknowledgeTermsPageTitle);
	}

}
