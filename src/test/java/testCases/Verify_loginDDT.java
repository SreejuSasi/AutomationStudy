package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import utilities.Dataproviders;

public class Verify_loginDDT extends BaseClass {


@Test(dataProvider="LoginData", dataProviderClass=Dataproviders.class)
	public void loginCheck(String user,String pwd, String exp) throws InterruptedException
	{
	try {
		logger.info("---Login Verification Started-----");
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName(user);
		Login.input_Password(pwd);
		Login.login_Click();
//		boolean alert_unautorized=Login.display_Alert();
		Thread.sleep(5000);
		
		Homepage home=new Homepage(driver);	
		logger.info("----Login Validation Started----");
		boolean homeicon=home.icon_check();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(homeicon==true)
			{
				home.click_Usericon();
				home.click_Logout();
				Assert.assertTrue(true);
			}
			else
			{
				
				Assert.assertTrue(false);
			
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			
			if(homeicon==true)
			{
				home.click_Usericon();
				home.click_Logout();
				Assert.assertTrue(false);
			}
			else
			{
				
				Assert.assertTrue(true);
			
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	
}
