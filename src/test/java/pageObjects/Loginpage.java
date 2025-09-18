package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Loginpage extends Basepage {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
		public Loginpage(WebDriver driver)
		{
			super(driver);
			
		// TODO Auto-generated constructor stub
	    }
	
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement btn_login;
	
	@FindBy(xpath="//div[text()=' Unauthorized ']")
	WebElement alert_unauthorized;
	

	
		public void input_UserName(String user)
		{
			txt_username.clear();   
			txt_username.sendKeys(user);
		}
		public void input_Password(String pwd)
		{
			txt_password.clear();
			txt_password.sendKeys(pwd);
		}
		public void login_Click()
		{
			btn_login.click();
		}
		public boolean display_Alert()
		{
			
			boolean login_alert= wait.until(ExpectedConditions.visibilityOf(alert_unauthorized)).isDisplayed();
			return login_alert;
		}

	
	
	

}
