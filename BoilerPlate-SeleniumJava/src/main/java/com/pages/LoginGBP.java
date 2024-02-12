package com.pages;

import org.openqa.selenium.By;

public class LoginGBP extends BaseClass {

	private By username = By.xpath(
			"//div[@class='modal-content background-customizable modal-content-desktop visible-md visible-lg']//form[@name='cognitoSignInForm']//input[@id='signInFormUsername']");
	private By password = By.xpath(
			"//div[@class='modal-content background-customizable modal-content-desktop visible-md visible-lg']//form[@name='cognitoSignInForm']//input[@id='signInFormPassword']");
	private By submitBtn = By.xpath(
			"//div[@class='modal-content background-customizable modal-content-desktop visible-md visible-lg']//form[@name='cognitoSignInForm']//input[@name='signInSubmitButton']");
	private By loginBtn = By.xpath("//*[@id='login-button']");
	private By entityId = By.xpath("//*[@id='entityId']");
	private By userId = By.xpath("//*[@id='userId']");
	private By userRole = By.xpath("//*[@id='userRole']");
	private By fullName = By.xpath("//*[@id='userFullName']");
	private By corpLoginBtn = By.xpath("//*[text()='Log In']");
	private By getNewGrantLabel = By.xpath("//*[text()='Get new grant']");
	private By labelIT = By.xpath("//*[text()='IT' and @class='itemname']");
	private By labelBringMyBusiness = By
			.xpath("//*[text()='Bring my business overseas or establish a stronger international presence']");
	private By labelMarketReadinessAssistance = By.xpath("//*[text()='Market Readiness Assistance']");
	private By applyBtn = By.xpath("//*[text()='Apply' and @id='go-to-grant']");
	private By proceedBtn = By.xpath("//*[text()='Proceed' and @id='keyPage-form-button']");

	public LoginGBP() {
		super();

	}

	public void enterValueInSearchField(String userName, String passWord) {
		waitForElementToBeClickable(username).sendKeys(userName);
		waitForElementToBeClickable(password).sendKeys(passWord);
		waitForElementToBeClickable(submitBtn).click();
	}

	public void clickOnLoginButton() {
		waitForElementToBeClickable(loginBtn).click();
	}

	public void enterCorpDetails(String entityid, String userid, String userrole, String fullname) {
		waitForElementToBeClickable(entityId).sendKeys(entityid);
		waitForElementToBeClickable(userId).sendKeys(userid);
		waitForElementToBeClickable(userRole).sendKeys(userrole);
		waitForElementToBeClickable(fullName).sendKeys(fullname);
	}

	public void clickOnCorpLoginBtn() {
		waitForElementToBeClickable(corpLoginBtn).click();
	}

	public void verifyGetNewGrant() throws Throwable {
		waitForElementToBeClickable(getNewGrantLabel).isDisplayed();
	}

	public void clickOnGetNewGrant() {
		waitForElementToBeClickable(getNewGrantLabel).click();
	}

	public void navigatesToCheckYourEligibility() throws Throwable {
		waitForElementToBeClickable(labelIT).click();
		waitForElementToBeClickable(labelBringMyBusiness).click();
		waitForElementToBeClickable(labelMarketReadinessAssistance).click();
		waitForElementToBeClickable(applyBtn).click();
		waitForElementToBeClickable(proceedBtn).click();
	}

}
