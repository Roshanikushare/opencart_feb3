package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class extentReport implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repname;
	public void onStart(ITestContext testContext)
	{
		String timestamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
		repname="Test-Report-"+timestamp+".html";
		sparkReporter=new ExtentSparkReporter(".\\reports\\"+repname); //specify location of the report
		
		sparkReporter.config().setDocumentTitle("opencart automation report");
		sparkReporter.config().setReportName("opencart functional testing");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application","opencart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("Sub Module","customers");
		extent.setSystemInfo("Operating system",System.getProperty("os.name"));
		extent.setSystemInfo("User name",System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
		
	}
	public void onTestSuccess(ITestResult result) 
	{
		test=extent.createTest(result.getName());
		test.log(Status.PASS,"Test passed");
	}
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.FAIL,"Test failed");
		test.log(Status.FAIL,result.getThrowable().getMessage());
		
		try {
			String imgpath=new BaseClass().captureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}catch(IOException e1) 
		{
		e1.printStackTrace();		
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.log(Status.SKIP,"Test skipped");
		test.log(Status.SKIP,result.getThrowable().getMessage());
	}
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}

}
