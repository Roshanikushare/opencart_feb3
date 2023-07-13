package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test
	void test_account_Registration()
	{
		logger.debug("application logs...");
		logger.info("***** Starting TC_001_AccountRegistrationTest ****** ");
	   try
	   {
		HomePage hp=new HomePage(driver);
		hp.clickRegister();
		logger.info("Clicked on rigister link");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Provinding customer data");
		
		regpage.setUsername(randomString().toUpperCase());
		Thread.sleep(2000);
		regpage.setFirstname(randomString().toUpperCase());
		Thread.sleep(2000);
		regpage.setLastname("kushare");
		Thread.sleep(2000);
		regpage.setEmail(randomString()+"@gmail.com");   //randomley generated the email (work for one time)
		Thread.sleep(2000);
		regpage.setCountry("india");
		Thread.sleep(2000);
		regpage.setPassword(randomAlphaNumeric());
		Thread.sleep(2000);
		regpage.clickRegister();
		logger.info("Clicked on rigister link");
		
		String confmsg=regpage.getConfirmationmsg();
		logger.info("Validating expected msg");
		Assert.assertEquals(confmsg,"Register for OpenCart account","test failed");
	   }
	   catch(Exception e)
	   {
		   logger.error("test failed");
		   Assert.fail();
	   }
	   logger.info("Finished");
  }
}
