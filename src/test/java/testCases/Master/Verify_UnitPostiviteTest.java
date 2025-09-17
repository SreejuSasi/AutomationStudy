  package testCases.Master;

import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.UnitMaster;

public class Verify_UnitPostiviteTest extends BaseClass {
	

	@Test
	public void Verify_UnitMaster() throws InterruptedException
	{
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName(p.getProperty("Validusername"));
		Login.input_Password(p.getProperty("Validpassword"));
		Login.login_Click();
		Thread.sleep(5000);
		Homepage HP=new Homepage(driver);
		UnitMaster UM=new UnitMaster(driver);
		HP.click_Masterform();
		Thread.sleep(5000);
		HP.click_EquipmentMaster();
		Thread.sleep(5000);
		HP.click_UnitMaster();
		Thread.sleep(5000);
		UM.click_UnitCreate();
		UM.input_Unitid(RandomNumber());
		UM.input_Unitname(RandomName());
		Thread.sleep(5000);
		UM.click_unitsubmit();
		
		
	}
	
	

}
