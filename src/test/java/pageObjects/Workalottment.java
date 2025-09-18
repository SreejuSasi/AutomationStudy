package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Workalottment extends Basepage{

	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5000));
	public Workalottment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy (xpath="//td[normalize-space()='2']")
	WebElement lnk_row1;
	
	@FindBy(xpath="//input[@id=\"311 - Mechanical\"]")
	WebElement txt_serviceeng;
	
	@FindBy(xpath="//i[@class=\"fa fa-check\"]")
	WebElement btn_proceed;
	
	@FindBy(xpath="//input[@id=\"a131\"]")
	WebElement chk_selectTech;
	
	@FindBy(xpath="//button[text()=' Assign ']")
	WebElement btn_assign;
	
	
	public void Click_assignmentlnk()
	{
		wait.until(ExpectedConditions.visibilityOf(lnk_row1)).click();
	}
	public void Input_ServiceEngCount(int count) throws InterruptedException
	{
		txt_serviceeng.clear();
		wait.until(ExpectedConditions.visibilityOf(txt_serviceeng)).sendKeys(String.valueOf(count));
		Thread.sleep(5000);
	}
	public void Click_proceedbtn()
	{
		wait.until(ExpectedConditions.visibilityOf(chk_selectTech)).click();
	}
	public void Click_assignbtn()
	{
		wait.until(ExpectedConditions.visibilityOf(btn_assign)).click();
	}

}
