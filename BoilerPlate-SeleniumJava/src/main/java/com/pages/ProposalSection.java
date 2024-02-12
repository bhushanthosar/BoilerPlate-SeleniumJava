package com.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class ProposalSection extends BaseClass {

	private By proposalLabel = By.xpath("//*[text()='Proposal']");
	private By projectTitleTextbox = By.xpath("//*[@id='react-project-title']");
	private By startDateTextbox = By.xpath("//*[@id='react-project-start_date']");
	private By endDateTextbox = By.xpath("//*[@id='react-project-end_date']");
	private By projectDescription = By.xpath("//*[@id='react-project-description']");
	private By activityDropdown = By
			.xpath("//*[@id='react-project-activity-label']/following::*[@class='Select-arrow-zone'][1]");
	private By activityValue = By.xpath("//*[text()='FTA & Trade Compliance Consultancy']");
	private By targetMarketDropdown = By
			.xpath("//*[@id='react-project-activity-label']/following::*[@class='Select-arrow-zone'][2]");
	private By targetMarketValue = By.xpath("//*[text()='Algeria']");
	private By noRadiButton = By.xpath("//*[@id='react-project-is_first_time_expand-false']");
	private By saveBtn = By.xpath("//*[@id='save-btn']");
	private By readOnlyProjectTitle = By.xpath("//*[@id='react-project-title']");
	private By readOnlyStartDate = By.xpath("//*[@id='react-project-start_date']");
	private By readOnlyEndDate = By.xpath("//*[@id='react-project-end_date']");
	private By readOnlyProjectDescription = By.xpath("//*[@id='react-project-description']");

	public ProposalSection() {
		super();
	}

	public void clickOnProposalSection() {
		waitForElementToBeClickable(proposalLabel).click();
	}

	public void provideTheProposalDetails() {
		waitForElementToBeClickable(projectTitleTextbox).sendKeys(getProperty("projectTitle"));
		waitForElementToBeClickable(startDateTextbox).sendKeys(getProperty("startDate"));
		waitForElementToBeClickable(endDateTextbox).sendKeys(getProperty("endDate"));
		waitForElementToBeClickable(projectDescription).sendKeys(getProperty("projectDescription"));
		waitForElementToBeClickable(activityDropdown).click();
		waitForElementToBeClickable(activityValue).click();
		waitForElementToBeClickable(targetMarketDropdown).click();
		waitForElementToBeClickable(targetMarketValue).click();
		waitForElementToBeClickable(noRadiButton).click();
		waitForElementToBeClickable(saveBtn).click();
	}

	public void verifyProposalSectionPrevoiusData() {
		String expectedProjectTitle = waitForElementToBeVisible(readOnlyProjectTitle).getText();
		String expectedStartDate = waitForElementToBeVisible(readOnlyStartDate).getText();
		String expectedEndDate = waitForElementToBeVisible(readOnlyEndDate).getText();

		String expectedProjectDescription = waitForElementToBeVisible(readOnlyProjectDescription).getText();

		Assert.assertEquals("Verify Project Title in Read Only Page", expectedProjectTitle,
				getProperty("projectTitle"));
		Assert.assertEquals("Verify Start Date in Read Only Page", expectedStartDate, getProperty("startDate"));
		Assert.assertEquals("Verify End Date in Read Only Page", expectedEndDate, getProperty("endDate"));
		Assert.assertEquals("Verify Project Description in Read Only Page", expectedProjectDescription,
				getProperty("projectDescription"));
	}

}
