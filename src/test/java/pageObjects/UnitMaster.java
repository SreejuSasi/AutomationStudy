package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnitMaster extends Basepage {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5000));

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
	
	@FindBy(xpath="//div[text()=' Saved Successfully ']")
	WebElement alert_success;
	
	@FindBy(xpath="//div[text()=' Duplicate Name Found! ']")
	WebElement alert_duplicate;
	
	
	public void click_UnitCreate() {
		wait.until(ExpectedConditions.visibilityOf(btn_createunit)).click();
	}
	
	public void input_Unitid(String Unitid)
	{
		wait.until(ExpectedConditions.visibilityOf(txt_unitid)).sendKeys(Unitid); 
	}
	public void input_Unitname(String Uname)
	{
		wait.until(ExpectedConditions.visibilityOf(txt_unitname)).sendKeys(Uname);
	}
	public void click_unitsubmit()
	{
		wait.until(ExpectedConditions.visibilityOf(btn_unitsubmit)).click();   
	}
	public boolean alert_UnitSuccess()
	{
		return wait.until(ExpectedConditions.visibilityOf(alert_success)).isDisplayed(); 
	}
	public boolean alert_UnitDuplicate()
	{
	 return	wait.until(ExpectedConditions.visibilityOf(alert_duplicate)).isDisplayed();  
	}
	

}
