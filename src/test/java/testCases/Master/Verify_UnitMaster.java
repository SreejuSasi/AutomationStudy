  package testCases.Master;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.UnitMaster;

public class Verify_UnitMaster extends BaseClass {
	
	


	@Test(priority=1)
	public void Verify_UnitwithData() throws InterruptedException
	{
		Loginpage Login=new Loginpage(driver);
		Login.input_UserName(p.getProperty("Validusername"));
		Login.input_Password(p.getProperty("Validpassword"));
		Login.login_Click();
		Homepage HP=new Homepage(driver);
		UnitMaster UM=new UnitMaster(driver);
		HP.click_Masterform();
		HP.click_EquipmentMaster();
		HP.click_UnitMaster();
		UM.click_UnitCreate();
		UM.input_Unitid(RandomNumber());
		UM.input_Unitname(RandomName());
		UM.click_unitsubmit();

		
		Assert.assertTrue(UM.alert_UnitSuccess());
		
		
	}
	
	@Test(priority=2)
	public void verify_UnitwithBlankData() {
		UnitMaster UM=new UnitMaster(driver);
		UM.input_Unitid("406");
		UM.input_Unitname("Fork Lift & Hand Jack");
		UM.click_unitsubmit();
		
		Assert.assertTrue(UM.alert_UnitDuplicate());
	}
	
	

}
