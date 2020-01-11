package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utilities.DatabaseConnector;
import utilities.ExcelUtil;

public class AutomationFormTest extends BaseTest {
	ArrayList<String> formFieldValues;
	String PrimaryKey;

	@Test(priority = 0, description = "Try to submit without filling required fields and \"Labels\" of all the required field printed on Console.")
	public void TestCase1() {
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getFname()),
				"Please fill out this field.");
		automationForm.printLabels();
	}

	@Test(priority = 1, description = "Verify all input fields using Soft assertions.", dataProvider = "getData", dataProviderClass = ExcelUtil.class)
	public void TestCase2(Map<String, String> map) {
		SoftAssert Assert = new SoftAssert();
		automationForm.clickResetButton();
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getFname()),
				"Please fill out this field.");
		automationForm.setFname(map.get("fname"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getLname()),
				"Please fill out this field.");
		automationForm.setLname(map.get("lname"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getEmail()),
				"Please fill out this field.");
		automationForm.setEmail(map.get("wrongEmail1"));
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail()).contains(
				"Please include an '@' in the email address."), "Please include an '@' in the email address.");
		automationForm.setEmail(map.get("wrongEmail2"));
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail())
				.contains("Please enter a part following '@'."), "Please enter a part following '@'.");
		automationForm.setEmail(map.get("email"));
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getEmail()), "Entered value is valid");

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getCurCompany()),
				"Please fill out this field.");
		automationForm.setCurCompany(map.get("curCompany"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please fill out this field.");
		automationForm.setMobile(map.get("wrongMobile1"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please match the requested format.");
		automationForm.setMobile(map.get("wrongMobile2"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please match the requested format.");
		automationForm.setMobile(map.get("wrongMobile3"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please match the requested format.");
		automationForm.setMobile(map.get("mobile"));
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getMobile()), "Entered value is valid");

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getDOB()),
				"Please fill out this field.");
		automationForm.setDOB(map.get("dob"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPosition()),
				"Please fill out this field.");
		automationForm.setPosition(map.get("position"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio(map.get("wrongPortfolio"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio(map.get("portfolio"));
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getPortfolio()), "Entered value is valid");

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getSalary()),
				"Please fill out this field.");
		automationForm.setSalary(map.get("salary"));

		// Bug: Resume upload section is not marked as mandatory field.
		// automationForm.clickSubmitButton();
		// Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getResume()),
		// "Please select a file.");
		// automationForm.uploadResume();

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getRelocateElement()),
				"Please select one of these options.");
		automationForm.selectRelocateOption(map.get("relocate"));
		automationForm.clickSubmitButton();
		Assert.assertAll();
	}

	@Test(priority = 2, description = "Verify all input fields using Hard assertions.", dataProvider = "getData", dataProviderClass = ExcelUtil.class)
	public void TestCase3(Map<String, String> map) {
		automationForm.clickResetButton();
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getFname()),
				"Please fill out this field.");
		automationForm.setFname(map.get("fname"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getLname()),
				"Please fill out this field.");
		automationForm.setLname(map.get("lname"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getEmail()),
				"Please fill out this field.");
		automationForm.setEmail(map.get("wrongEmail1"));
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail()).contains(
				"Please include an '@' in the email address."), "Please include an '@' in the email address.");
		automationForm.setEmail(map.get("wrongEmail2"));
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail())
				.contains("Please enter a part following '@'."), "Please enter a part following '@'.");
		automationForm.setEmail(map.get("email"));
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getEmail()), "Entered value is valid");

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getCurCompany()),
				"Please fill out this field.");
		automationForm.setCurCompany(map.get("curCompany"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please fill out this field.");
		automationForm.setMobile(map.get("wrongMobile1"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please match the requested format.");
		automationForm.setMobile(map.get("wrongMobile2"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please match the requested format.");
		automationForm.setMobile(map.get("wrongMobile3"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()),
				"Please match the requested format.");
		automationForm.setMobile(map.get("mobile"));
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getMobile()), "Entered value is valid");

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getDOB()),
				"Please fill out this field.");
		automationForm.setDOB(map.get("dob"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPosition()),
				"Please fill out this field.");
		automationForm.setPosition(map.get("position"));

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio(map.get("wrongPortfolio"));
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio(map.get("portfolio"));
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getPortfolio()), "Entered value is valid");

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getSalary()),
				"Please fill out this field.");
		automationForm.setSalary(map.get("salary"));

		// Bug: Resume upload section is not marked as mandatory field.
		// automationForm.clickSubmitButton();
		// Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getResume()),
		// "Please select a file.");
		// automationForm.uploadResume();

		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getRelocateElement()),
				"Please select one of these options.");
		automationForm.selectRelocateOption(map.get("relocate"));
		automationForm.clickSubmitButton();
	}

	@Test(priority = 3, description = "Submit the form after filling all details properly by using XPath only. ", dataProvider = "getData", dataProviderClass = ExcelUtil.class)
	public void TestCase4(Map<String, String> map) {
		automationForm.fillCompleteForm(map);
		formFieldValues = automationForm.getAllFieldValues();
		PrimaryKey = automationForm.getEmail().getAttribute("value");
		automationForm.getAllFieldValues().clear();
		automationForm.clickSubmitButton();
	}

	@Test(priority = 4, dependsOnMethods = "TestCase4", description = "Verify DB entry after submitting the form using JDBC connection.")
	public void TestCase5() throws SQLException {
		ArrayList<String> dbEnteredValues = DatabaseConnector.executeSQLQuery_List("select * from automationForm where email='"+PrimaryKey+"'");
		Assert.assertTrue(formFieldValues.equals(dbEnteredValues),"Entered form value is correctly entered in database");
	}
}
