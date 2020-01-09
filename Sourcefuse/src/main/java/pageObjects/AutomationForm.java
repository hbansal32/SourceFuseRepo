package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomationForm extends BasePage {
	WebDriver driver;

	public AutomationForm(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath = "//div[@id='fnameInput']/input")
	private WebElement fname;

	@FindBy(xpath = "//div[@id='lnameInput']/input")
	private WebElement lname;

	@FindBy(xpath = "//div[@id='emailInput']/input")
	private WebElement email;

	@FindBy(xpath = "//div[@id='curCompanyInput']/input")
	private WebElement curCompany;

	@FindBy(xpath = "//div[@id='mobInput']/input")
	private WebElement mobile;

	@FindBy(xpath = "//div[@id='DOBInput']//input")
	private WebElement DOB;

	@FindBy(xpath = "//div[@id='positionInput']/input")
	private WebElement position;

	@FindBy(xpath = "//div[@id='portfolioInput']/input")
	private WebElement portfolio;

	@FindBy(xpath = "//div[@id='salaryInput']/input")
	private WebElement salary;

	@FindBy(xpath = "//div[@id='whenStartInput']/input")
	private WebElement whenStart;

	@FindBy(xpath = "//div[@id='addressInput']/textarea")
	private WebElement address;

	@FindBy(xpath = "//input[@id='resume']")
	private WebElement resume;

	@FindBy(xpath = "//input[@class='form-check-input' and @id='yes']")
	private WebElement relocateYes;
	
	@FindBy(xpath = "//input[@class='form-check-input' and @id='no']")
	private WebElement relocateNo;
	
	@FindBy(xpath = "//input[@class='form-check-input' and @id='notSure']")
	private WebElement relocateNotSure;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;
	
	@FindBy(xpath = "//button[@type='reset']")
	private WebElement reset;
	
	@FindBy(xpath = "//label")
	private List<WebElement> labels;
	
	public WebElement getFname() {		
		return fname;
	}

	public WebElement setFname(String firstName) {
		fname.clear();
		fname.sendKeys(firstName);
		return this.fname ;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement setLname(String lastName) {
		lname.clear();
		lname.sendKeys(lastName);
		return this.lname;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement setEmail(String mail) {
		email.clear();
		email.sendKeys(mail);
		return this.email;
	}

	public WebElement getCurCompany() {
		return curCompany;
	}

	public WebElement setCurCompany(String s) {
		curCompany.clear();
		curCompany.sendKeys(s);
		return this.curCompany;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement setMobile(String s) {
		mobile.clear();
		mobile.sendKeys(s);
		return this.mobile;
	}

	public WebElement getDOB() {
		return DOB;
	}

	public WebElement setDOB(String s) {
		DOB.clear();
		DOB.sendKeys(s);
		return this.DOB;
	}

	public WebElement getPosition() {
		return position;
	}

	public WebElement setPosition(String s) {
		position.clear();
		position.sendKeys(s);
		return this.position;
	}

	public WebElement getPortfolio() {
		return portfolio;
	}

	public WebElement setPortfolio(String s) {
		portfolio.clear();
		portfolio.sendKeys(s);
		return this.portfolio;
	}

	public WebElement getSalary() {
		return salary;
	}

	public WebElement setSalary(String s) {
		salary.clear();
		salary.sendKeys(s);
		return this.salary;
	}

	public WebElement getWhenStart() {
		return whenStart;
	}

	public WebElement setWhenStart(String s) {
		whenStart.clear();
		whenStart.sendKeys(s);
		return this.whenStart;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement setAddress(String s) {
		address.clear();
		address.sendKeys(s);
		return this.address;
	}
	
	public WebElement getResume() {
		return resume;
	}
	
	public void uploadResume(){
		resume.click();
		try {
			Thread.sleep(3000);		
			Runtime.getRuntime().exec(projectPath+"//src//main//java//resources//fileUploadAutoItScript.exe");
		} catch (IOException | InterruptedException e) {
		}
	}
	public WebElement getRelocateYes() {
		return relocateYes;
	}

	public void selectRelocateOption(String s) {
		if(s.equals("yes"))
				relocateYes.click();
		if(s.equals("no"))
			relocateNo.click();
		if(s.equals("notSure"))
			relocateNotSure.click();
	}
	
	public void clickSubmitButton() {
		submit.click();
	}
	
	public void clickResetButton() {
		reset.click();
	}
	
	public void printLabels() {
		for(WebElement label : labels)
			System.out.println(label.getText());		
	}
	
	public void fillCompleteForm() {
		clickResetButton();
		setFname("Himanshu");
		setLname("Bansal");
		setEmail("him.20may@gmail.com");
		setCurCompany("Cognizant Technology Solution");
		setMobile("8447064950");
		setDOB("05/20/1991");
		setPosition("Senior Quality Engineer");
		setPortfolio("https://www.linkedin.com/in/hbansal32/");
		setSalary("636000");
		setWhenStart("20 Jan 2020");
		setAddress("Wagholi, Pune");
		uploadResume();
		selectRelocateOption("yes");
	}
	
	public String getFieldErrorMessage(WebElement element) {
		return element.getAttribute("validationMessage");
	}
	
	public boolean verifyEnteredValue(WebElement element) {
		return (Boolean)((JavascriptExecutor)driver).executeScript("return arguments[0].checkValidity();", element);
	}	
}