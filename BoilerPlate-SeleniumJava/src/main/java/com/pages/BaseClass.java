package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;
import com.qa.utils.PropertiesReader;

public class BaseClass {

	Properties qProperties = new PropertiesReader().getProperties("./src/test/resources/config/Config.properties");

	public WebDriver driver;

	public BaseClass() {
		this.driver = DriverFactory.getDriver();
	}

	public WebDriverWait getWebDriverWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(Integer.valueOf(qProperties.getProperty("maxTimeout"))));
	}

	public WebElement waitForElementToBeClickable(By locator) {

		return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
	}

	public List<WebElement> waitForAllElementsToBeVisible(By locator) {
		return getWebDriverWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public WebElement waitForElementToBeVisible(By locator) {
		return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementTextToBePresent(By locator) {
		getWebDriverWait().until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
				WebElement ele = driver.findElement(locator);
				return ele.getAttribute("value").length() != 0 || ele.getText().length() != 0;
			}
		});
		return getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public String getProperty(String key) {
		return qProperties.getProperty(key).toString();
	}

}
