package testCases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.Loginpage;

public class Verify_loginNegative extends BaseClass {

	@Test
	public void WrongCredential() throws InterruptedException
	{
		
		logger.info("---Login Verification Started-----");
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName(p.getProperty("Wrongusername"));
		Login.input_Password(p.getProperty("Wrongpassword"));
		Login.login_Click();
		Thread.sleep(1000);
		Assert.assertTrue(Login.display_Alert());
	}

	@Test
	public void BlankCredential() throws InterruptedException
	{
		
		logger.info("---Login Verification Started-----");
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName("");
		Login.input_Password("");
		Login.login_Click();
		Thread.sleep(1000);
		Assert.assertTrue(Login.display_Alert());
	}
	@Test
	public void BlankPassword() throws InterruptedException
	{
		
		logger.info("---Login Verification Started-----");
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName(p.getProperty("Wrongusername"));
		Login.input_Password("");
		Login.login_Click();
		Thread.sleep(1000);
		Assert.assertTrue(Login.display_Alert());
	}
	@Test
	public void BlankUsername() throws InterruptedException
	{
		
		logger.info("---Login Verification Started-----");
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName("");
		Login.input_Password(p.getProperty("Wrongpassword"));
		Login.login_Click();
		Thread.sleep(1000);
		Assert.assertTrue(Login.display_Alert());
		
	}


	

	
}
