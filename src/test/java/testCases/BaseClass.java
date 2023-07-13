package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Logger logger;     //for logging
	
	public ResourceBundle rb;
	
	@BeforeClass(groups= {"master"})
	@Parameters("browser")
 public	void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");  //load config.properties file
		
		logger=LogManager.getLogger(this.getClass());
		
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32 (7)\\chromedriver.exe");
		System.setProperty("webdriver.edge.driver","C:\\Selenium\\edgedriver_win32\\msedgedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		if(br.equals("chrome")) 
		{
			driver=new ChromeDriver(options);
		}else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL"));
	//	driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
	}
	@AfterClass(groups= {"master"})
	public void tearDown()
	{
		driver.quit();
	}
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	public String randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(10);
		return(generatedString2);
	}
	public String randomAlphaNumeric()
	{
		String st=RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(3);
		return(st+"@"+num);
	}
	
	 public String captureScreenShot(String tname) throws IOException
	    {
	    	String timestamp=new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
	    	 File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String Dest=System.getProperty(".//screenshots//" +tname+ "-" +timestamp+".png");
			
	 		FileUtils.copyFile(Source,new File(Dest));
	 		return Dest;
	    }
	
	
	
	
	
	
	

}
