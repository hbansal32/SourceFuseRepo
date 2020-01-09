package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageObjects.BasePage;
import pageObjects.AutomationForm;

public class BaseTest extends BasePage {
	AutomationForm automationForm;

	@BeforeTest
	public void initialize() throws Exception {
		driver = initializeDriver();
		automationForm = new AutomationForm(driver);
		launchApplication();
	}

	@AfterTest
	public void tearDown() {
		driver.navigate().to(projectPath+"/target/surefire-reports/ExtentReportsTestNG.html");
		//driver.quit();
		driver = null;
	}
}
