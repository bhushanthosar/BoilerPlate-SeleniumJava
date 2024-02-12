package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class CostSection extends BaseClass {

	private By costLabel = By.xpath("//*[text()='Cost']");
	private By officeSpaceRental = By.xpath("//*[@id='react-project_cost-office_rentals-accordion-header']");
	private By addNewItem = By.xpath("//*[@id='react-project_cost-office_rentals-add-item']");
	private By description = By.xpath("//*[@id='react-project_cost-office_rentals-0-description']");
	private By rentalDuration = By.xpath("//*[@id='react-project_cost-office_rentals-0-rental_duration']");
	private By billingCurrency = By.xpath("//*[@id='react-project_cost-office_rentals-0-amount_in_billing_currency']");
	private By readOnlyCostDescription = By.xpath("//*[@id='react-project_cost-office_rentals-0-description']");

	public CostSection() {
		super();
	}

	public void clickOnCostSection() {
		waitForElementToBeClickable(costLabel).click();
	}

	public void provideTheCostDetails() throws InterruptedException {
		waitForElementToBeClickable(officeSpaceRental).click();
		waitForElementToBeClickable(addNewItem).click();
		waitForElementToBeClickable(description).sendKeys(getProperty("description"));
		waitForElementToBeClickable(rentalDuration).sendKeys(getProperty("rentalDuration"));
		waitForElementToBeClickable(billingCurrency).sendKeys(getProperty("billingCurrency"));
	}

	public void verifyCostSectionPrevoiusData() throws InterruptedException {
		String expectedCostDescription = waitForElementToBeVisible(readOnlyCostDescription).getText();

		Assert.assertEquals("Verify Cost Description in Read Only Page", expectedCostDescription,
				getProperty("description"));
	}
}
