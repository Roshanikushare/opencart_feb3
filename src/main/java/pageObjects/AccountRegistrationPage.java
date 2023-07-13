package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage  {
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	//Elements
	@FindBy(name="username")
	WebElement txtUsername;
	@FindBy(name="firstname")
	WebElement txtFirstname;
	@FindBy(name="lastname")
	WebElement txtLastname;
	@FindBy(name="email")
	WebElement txtEmail;
	@FindBy(name="country_id")
	WebElement txtCountry;
	@FindBy(name="password")
	WebElement txtPassword;
	@FindBy(xpath="(//button[text()='Register'])[1]")
			WebElement btnRegister;
	
	@FindBy(xpath="//h3[text()='Register for OpenCart account']")
	WebElement confirmationMsg;
	
	//Action methods
	public void setUsername(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	public void setFirstname(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastname(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setCountry(String country )
	{
		txtCountry.sendKeys(country);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void clickRegister()
	{
		btnRegister.click();
	}
	public String getConfirmationmsg()
	{
		try {
			return(confirmationMsg.getText());
		}catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
