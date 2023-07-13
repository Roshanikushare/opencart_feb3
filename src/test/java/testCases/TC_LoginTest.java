package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LoginPage;

public class TC_LoginTest extends BaseClass {

	@Test(groups= {"master","sanity"})
	public void test_login()
	{
		try
		{
		logger.info("---starting TC_logintest----");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(rb.getString("email"));     //config.properties
		lp.setPass(rb.getString("password"));
		lp.clickLogin();
		
		
		AccountPage ap=new AccountPage(driver);
		boolean targetpage=ap.isMyAccountExists();
		Assert.assertEquals(targetpage,true,"invalid login data");
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("----finished tc_logintest----");
	}
}
