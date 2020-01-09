package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomationFormTest extends BaseTest {

	@Test(priority=0, description= "Try to submit without filling required fields and \"Labels\" of all the required field printed on Console.")
	public void TestCase1() {
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getFname()), "Please fill out this field.");
		automationForm.printLabels();
	}
	
	@Test(priority=1, description= "Verify all input fields using Soft assertions.")
	public void TestCase2() {
		SoftAssert Assert = new SoftAssert();
		automationForm.clickResetButton();
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getFname()), "Please fill out this field.");
		automationForm.setFname("fname1");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getLname()), "Please fill out this field.");
		automationForm.setLname("lname1");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getEmail()), "Please fill out this field.");
		automationForm.setEmail("abc");
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail()).contains("Please include an '@' in the email address."), "Please include an '@' in the email address.");
		automationForm.setEmail("abc@");
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail()).contains("Please enter a part following '@'."), "Please enter a part following '@'.");
		automationForm.setEmail("abc@xyz.com");
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getEmail()), "Entered value is valid");
		
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getCurCompany()), "Please fill out this field.");
		automationForm.setCurCompany("company");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please fill out this field.");
		automationForm.setMobile("company");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please match the requested format.");
		automationForm.setMobile("123456789");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please match the requested format.");
		automationForm.setMobile("78945");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please match the requested format.");
		automationForm.setMobile("8974561234");
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getMobile()), "Entered value is valid");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getDOB()), "Please fill out this field.");
		automationForm.setDOB("05/20/1991");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPosition()), "Please fill out this field.");
		automationForm.setPosition("tester");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio("url");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio("http://url");
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getPortfolio()), "Entered value is valid");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getSalary()), "Please fill out this field.");
		automationForm.setSalary("12");
		
		//Bug: Resume upload section is not marked as mandatory field.
		//automationForm.clickSubmitButton();
		//Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getResume()), "Please select a file.");
		//automationForm.uploadResume();
				
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getRelocateYes()), "Please select one of these options.");
		automationForm.selectRelocateOption("yes");
		automationForm.clickSubmitButton();
		Assert.assertAll();
		}
	
	@Test(priority=2, description= "Verify all input fields using Hard assertions.")
	public void TestCase3() {
		automationForm.clickResetButton();
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getFname()), "Please fill out this field.");
		automationForm.setFname("fname1");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getLname()), "Please fill out this field.");
		automationForm.setLname("lname1");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getEmail()), "Please fill out this field.");
		automationForm.setEmail("abc");
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail()).contains("Please include an '@' in the email address."), "Please include an '@' in the email address.");
		automationForm.setEmail("abc@");
		Assert.assertTrue(automationForm.getFieldErrorMessage(automationForm.getEmail()).contains("Please enter a part following '@'."), "Please enter a part following '@'.");
		automationForm.setEmail("abc@xyz.com");
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getEmail()), "Entered value is valid");
		
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getCurCompany()), "Please fill out this field.");
		automationForm.setCurCompany("company");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please fill out this field.");
		automationForm.setMobile("company");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please match the requested format.");
		automationForm.setMobile("123456789");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please match the requested format.");
		automationForm.setMobile("78945");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getMobile()), "Please match the requested format.");
		automationForm.setMobile("8974561234");
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getMobile()), "Entered value is valid");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getDOB()), "Please fill out this field.");
		automationForm.setDOB("05/20/1991");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPosition()), "Please fill out this field.");
		automationForm.setPosition("tester");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio("url");
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getPortfolio()), "Please enter a URL.");
		automationForm.setPortfolio("http://url");
		Assert.assertTrue(automationForm.verifyEnteredValue(automationForm.getPortfolio()), "Entered value is valid");
		
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getSalary()), "Please fill out this field.");
		automationForm.setSalary("12");
		
		//Bug: Resume upload section is not marked as mandatory field.
		//automationForm.clickSubmitButton();
		//Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getResume()), "Please select a file.");
		//automationForm.uploadResume();
				
		automationForm.clickSubmitButton();
		Assert.assertEquals(automationForm.getFieldErrorMessage(automationForm.getRelocateYes()), "Please select one of these options.");
		automationForm.selectRelocateOption("yes");
		automationForm.clickSubmitButton();
		}
	
	@Test(priority=3, description= "Submit the form after filling all details properly by using XPath only. ")
	public void TestCase4() {
		automationForm.fillCompleteForm();
		automationForm.clickSubmitButton();
	}
}
