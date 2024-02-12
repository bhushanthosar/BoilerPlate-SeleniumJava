package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.pages.LoginGBP;
import com.qa.factory.DriverFactory;
import com.qa.utils.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private WebDriver driver;
	Properties prop;

	@Before(order = 0)
	public void loadProperties() {
		PropertiesReader configReader = new PropertiesReader();
		prop = configReader.init_prop();

	}

	@Before(order = 1)
	public void launchBrowser() throws Throwable {
		String browserName = prop.getProperty("browser");
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);

	}

	@Before(order = 2)
	public void loginToApp() throws Throwable {
		LoginGBP loginGBP = new LoginGBP();
		DriverFactory.getDriver().get(prop.getProperty("appURL"));
		loginGBP.enterValueInSearchField(prop.getProperty("userName"), prop.getProperty("passWord"));
		loginGBP.clickOnLoginButton();
		loginGBP.enterCorpDetails(prop.getProperty("entityID"), prop.getProperty("userID"), prop.getProperty("role"),
				prop.getProperty("userFullName"));
		loginGBP.clickOnCorpLoginBtn();
		loginGBP.verifyGetNewGrant();
		loginGBP.clickOnGetNewGrant();
		loginGBP.navigatesToCheckYourEligibility();
	}
	
	@After(order = 0)
    public void takeScreenshot(Scenario scenario) {
		 if (scenario.isFailed()) {
	            try {
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", "Screenshot");
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	}

	@After(order = 1)
    public void quitBrowser() {
       
		driver.quit();
	}

}
