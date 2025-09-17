package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseClass;

public class ExtentReportManager implements ITestListener {
	

		public ExtentSparkReporter reporter;
		public ExtentReports extent;
		public ExtentTest test;
		
		  public void onStart(ITestContext context) {
			    // not implemented
			  
			  String DateTime= new SimpleDateFormat("yyyy/mm/dd").format(new Date());
			  reporter =new ExtentSparkReporter(".\\reports\\"+"Test Result"+DateTime+".html");
			  
			  reporter.config().setDocumentTitle("Automation test");
			  reporter.config().setReportName("MacMan Automation");
			  reporter.config().setTheme(Theme.DARK);
			  
			  extent =new ExtentReports();
			  extent.attachReporter(reporter);
			  
			  extent.setSystemInfo("Tester", "Sreeju");
			  String browser=context.getCurrentXmlTest().getParameter("browser");
			  extent.setSystemInfo("Browser", browser);
			  
			  String os=context.getCurrentXmlTest().getParameter("os");
			  extent.setSystemInfo("OS", os);
			  
			  }
		  
		  public void onTestSuccess(ITestResult result) {
			  test=extent.createTest(result.getTestClass().getName());
			  test.assignCategory(result.getMethod().getGroups());
			  test.log(Status.PASS, result.getName());
			  }
		  public void onTestFailure(ITestResult result) {
			    test=extent.createTest(result.getTestClass().getName());
			    test.assignCategory(result.getMethod().getGroups());
			    test.log(Status.FAIL, result.getThrowable());
			    try {
			    String capturescreenshot=new BaseClass().takescreenshot(result.getName());
			    test.addScreenCaptureFromPath(capturescreenshot);
			    }
			    catch(Exception e)
			    {
			    	e.printStackTrace();
			    }
			    
			  
			  }
		  public void onTestSkipped(ITestResult result) {

			    test=extent.createTest(result.getTestClass().getName());
			    test.assignCategory(result.getMethod().getGroups());
			    test.log(Status.SKIP, result.getName());
			  
			  }
		  public void onFinish(ITestContext context) {
			    // not implemented
			  extent.flush();
			  }
		
		
	

}
