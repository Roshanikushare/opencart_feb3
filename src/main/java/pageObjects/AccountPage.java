package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{
	public AccountPage(WebDriver driver) {
		super(driver);
		}
	
	// @FindBy(xpath="//div[@class='xds687c x1pi30zi x1e558r4 xixxii4 x13vifvy xzkaem6']/div/span")
	 @FindBy(xpath="//div[@class='x78zum5 x1n2onr6']")
	   private WebElement account;
	 
	 @FindBy(xpath="//span[text()='Log Out']")
	  private WebElement logout;
	 
	 
	 public boolean isMyAccountExists() {
		 try {
			 //account.click();
			 return(account.isDisplayed());
		 }catch(Exception e)
		 {
			 return(false);
		 }
	 }
	 public void clickAccount()
	 {
		 account.click();
	 }
	 public void clickLogout()
	 {
		 logout.click();
	 }
	
	
	
	

}
