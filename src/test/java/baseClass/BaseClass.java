package baseClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	public static WebDriver driver;
	WebDriverWait wait;
	public Properties p;
	public Logger logger;
	
	
	@Parameters({"browser","os"})
	@BeforeClass
	public void setUp(String br,String os) throws IOException
	{
		logger=LogManager.getLogger(this.getClass());
		
		
		p=new Properties();													
		FileReader file=new FileReader(".\\src\\test\\resources\\config.properties");		
		p.load(file);
			
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		case "Edge": driver=new EdgeDriver();break;
		default: System.out.print("no such browser found");return;
		
		}
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();	
		wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
	}
	@AfterClass
	public void tearDown()
	{
        if (driver != null) {
            driver.quit();
        }
	}
	public String takescreenshot(String name)
	{
		String Timestamp=new SimpleDateFormat("yyyy/mm/dd").format(new Date());
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		
		File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		
		String targetpath=System.getProperty("user.dir")+".\\screenshots\\"+name+Timestamp+".png";
		
		File targetfile=new File(targetpath);
		
		sourcefile.renameTo(targetfile);
		
		return targetpath;
		
		
	}
	
	public static String RandomNumber()
	{
		String randomnumber=RandomStringUtils.randomNumeric(10);
		return randomnumber;
	}
	public static String RandomName()
	{
		String randomname=RandomStringUtils.randomAlphabetic(30);
		return randomname;
	}
	
	

}
