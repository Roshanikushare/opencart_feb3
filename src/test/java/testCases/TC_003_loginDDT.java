package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.LoginPage;
import utilities.dataProviders;

public class TC_003_loginDDT extends BaseClass {

	@Test(dataProvider="LoginData", dataProviderClass=dataProviders.class)
	public void test_loginDDT(String email,String pass, String exp) throws InterruptedException
	{
		logger.info("starting tc_003");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPass(pass);
		lp.clickLogin();
		Thread.sleep(3000);
		
		AccountPage mac=new AccountPage(driver);
		mac.clickAccount();
		
		boolean targetpage=mac.isMyAccountExists();
		if(exp.equals("valid")) 
		{
			if(targetpage==true) 
			{
			//	mac.clickAccount();
				mac.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("invalid"))
		{
			if(targetpage==true) 
			{
				mac.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}   
		logger.info("---finished tc_loginDDT--------");
	}
	
	
	
	
	
	
	
	
}
