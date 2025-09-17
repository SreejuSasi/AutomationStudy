package testCases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;

public class Verify_login extends BaseClass {


	@Test
	public void loginCheck() throws InterruptedException
	{
		logger.info("---Login Verification Started-----");
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName(p.getProperty("Validusername"));
		Login.input_Password(p.getProperty("Validpassword"));
		Login.login_Click();
		Thread.sleep(5000);
		
		Homepage home=new Homepage(driver);
		
		logger.info("----Login Validation Started----");
		String loginuser=home.label_user();
		if(loginuser.equals("Anurut Rugchum"))
		{
			logger.info("**********Login Successfull*****************");
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.error("**********Login Failed*****************");
			logger.debug("fail");
			Assert.fail();
			
		}

		
		logger.info("---Login Verification completed-----");
		
	}
	

	
}
