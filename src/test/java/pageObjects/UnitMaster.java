package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UnitMaster extends Basepage {

	public UnitMaster(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//img[@class=\"addimage\"]")
	WebElement btn_createunit;
	
	@FindBy(xpath="//input[@name=\"code\"]")
	WebElement txt_unitid;
	
	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement txt_unitname;
	
	@FindBy(xpath="//button[text()=\" Submit\"]")
	WebElement btn_unitsubmit;
	
	
	public void click_UnitCreate() {
		btn_createunit.click();
	}
	
	public void input_Unitid(String Unitid)
	{
		txt_unitid.sendKeys(Unitid);
	}
	public void input_Unitname(String Uname)
	{
		txt_unitname.sendKeys(Uname);
	}
	public void click_unitsubmit()
	{
		btn_unitsubmit.click();
	}
	

}
