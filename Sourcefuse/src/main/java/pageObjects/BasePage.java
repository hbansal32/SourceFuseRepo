package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	public static Properties prop;
	static Connection con;
	public static Statement stmt;

	public static String projectPath = System.getProperty("user.dir");
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(projectPath + "//src//main//java//resources//config.properties/");
		prop.load(fis);
		String browserName = prop.getProperty("browserName");
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", projectPath + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "IE":
			System.setProperty("webdriver.ie.driver", projectPath + "//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		default:
			break;
		}
		return driver;
	}

	public void launchApplication() {
		driver.get(prop.getProperty("applicationUrl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void setupDatabase() throws Exception {
		String db_url = prop.getProperty("db_url");
		String db_user = prop.getProperty("db_user");
		String db_password = prop.getProperty("db_password");

		try {
			//String dbClass = "com.mysql.cj.jdbc.Driver";
			// Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(db_url, db_user, db_password);
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getScreenshotPath(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String path=projectPath + "//target//screenshots//" + result + "_screenshot_" + timeStamp + ".png";
		FileHandler.copy(src,new File(path));
		return path;
	}

	public WebElement waitTillElementClickable(WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		WebElement waitElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return waitElement;
	}
	
	public boolean waitTillElementInvisible(WebElement element, int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime);
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
