package com.pages;

import org.openqa.selenium.By;

public class BusinessImpactSection extends BaseClass {

	private By businessImpactLabel = By.xpath("//*[text()='Business Impact']");
	private By fyEndDate = By.xpath("//*[@id='react-project_impact-fy_end_date_0']");
	private By overSeasSales1 = By.xpath("//*[@id='react-project_impact-overseas_sales_0']");
	private By overSeasSales2 = By.xpath("//*[@id='react-project_impact-overseas_sales_1']");
	private By overSeasSales3 = By.xpath("//*[@id='react-project_impact-overseas_sales_2']");
	private By overSeasSales4 = By.xpath("//*[@id='react-project_impact-overseas_sales_3']");
	private By overSeasInvestment1 = By.xpath("//*[@id='react-project_impact-overseas_investments_0']");
	private By overSeasInvestment2 = By.xpath("//*[@id='react-project_impact-overseas_investments_1']");
	private By overSeasInvestment3 = By.xpath("//*[@id='react-project_impact-overseas_investments_2']");
	private By overSeasInvestment4 = By.xpath("//*[@id='react-project_impact-overseas_investments_3']");
	private By rationalForProjection = By.xpath("//*[@id='react-project_impact-rationale_remarks']");
	private By nonTangibleBenefits = By.xpath("//*[@id='react-project_impact-benefits_remarks']");
	private By saveBtn = By.xpath("//*[@id='save-btn']");

	public BusinessImpactSection() {
		super();
	}

	public void clickOnBusinessImpactSection() {
		waitForElementToBeClickable(businessImpactLabel).click();

	}

	public void provideTheBusinessImpactDetails() throws InterruptedException {
		waitForElementToBeClickable(fyEndDate).sendKeys(getProperty("fYEndDate").toString());
		waitForElementToBeClickable(overSeasSales1).sendKeys(getProperty("overseasSale1").toString());
		waitForElementToBeClickable(overSeasSales2).sendKeys(getProperty("overseasSale2").toString());
		waitForElementToBeClickable(overSeasSales3).sendKeys(getProperty("overseasSale3").toString());
		waitForElementToBeClickable(overSeasSales4).sendKeys(getProperty("overseasSale4").toString());
		waitForElementToBeClickable(overSeasInvestment1).sendKeys(getProperty("ovserSeasInvest1").toString());
		waitForElementToBeClickable(overSeasInvestment2).sendKeys(getProperty("ovserSeasInvest2").toString());
		waitForElementToBeClickable(overSeasInvestment3).sendKeys(getProperty("ovserSeasInvest3").toString());
		waitForElementToBeClickable(overSeasInvestment4).sendKeys(getProperty("ovserSeasInvest4").toString());
		waitForElementToBeClickable(rationalForProjection).sendKeys(getProperty("rationalForProjection").toString());
		waitForElementToBeClickable(nonTangibleBenefits).sendKeys(getProperty("nonTangibleBenefits").toString());
		waitForElementToBeClickable(saveBtn).click();
	}
}
