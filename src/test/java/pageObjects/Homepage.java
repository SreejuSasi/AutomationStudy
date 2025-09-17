package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{

	public Homepage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[text()=\" Anurut Rugchum \"]")
	WebElement label_username;
	
	@FindBy(xpath="//img[@src='assets/images/macman-logo.png']")
	WebElement logo_home;
	
	@FindBy(xpath="//img[@class=\"rounded-circle\"]")
	WebElement icon_user;
	
	@FindBy(xpath="//button[text()=\"Logout\"]")
	WebElement link_logout;
	
	@FindBy(xpath="//a[text()=\" Master \"] ")
	WebElement lnk_Masterform;
	
	@FindBy(xpath="//a[text()=\" Equipment \"] ")
	WebElement lnk_EquipmentMaster;
	
	@FindBy(xpath="//a[text()=\" Unit \"] ")
	WebElement lnk_UnitMaster;
	
	
	public String label_user()
	{
		String username=label_username.getText();
		return username;
	}
	
	public boolean icon_check()
	{
		boolean logo=logo_home.isDisplayed();
		return logo;
	}
	
	public void click_Usericon() 
	{
		icon_user.click();
		
	}
	
	public void click_Logout()
	{
		link_logout.click();
	}
	public void click_Masterform()
	{
		lnk_Masterform.click();
	}
	public void click_EquipmentMaster()
	{
		lnk_EquipmentMaster.click();
	}
	public void click_UnitMaster()
	{
		lnk_UnitMaster.click();
	}
}
