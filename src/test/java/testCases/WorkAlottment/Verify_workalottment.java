package testCases.WorkAlottment;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.Workalottment;

public class Verify_workalottment extends BaseClass {
	
	@Test
	public void verify_alottment() throws InterruptedException
	{
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName(p.getProperty("Validusername"));
		Login.input_Password(p.getProperty("Validpassword"));
		Login.login_Click();
		Homepage HP=new Homepage(driver);
		HP.click_workalottmentlnk();
		
		Workalottment WA=new Workalottment(driver);
		Thread.sleep(5000);
		WA.Click_assignmentlnk();
		WA.Input_ServiceEngCount(1);
		WA.Click_proceedbtn();
		WA.Click_assignbtn();
	}

}
