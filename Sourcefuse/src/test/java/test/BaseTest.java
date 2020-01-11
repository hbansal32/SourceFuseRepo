package test;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pageObjects.BasePage;
import pageObjects.AutomationForm;

public class BaseTest extends BasePage {
	AutomationForm automationForm;

	@BeforeTest
	public void initialize() throws Exception {
		initializeDriver();
		automationForm = new AutomationForm(driver);
		launchApplication();		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		driver = null;
	}
	
	@AfterSuite
	public void generateReport() throws IOException, InterruptedException {
		Thread.sleep(10000);
		File htmlFile = new File(projectPath+"/target/surefire-reports/ExtentReportsTestNG.html");
		Desktop.getDesktop().browse(htmlFile.toURI());		
	}
}
