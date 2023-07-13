package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	//Elements
	@FindBy(xpath="(//a[text()='Register'])[2]")
	WebElement lnkRegister;
	
	//Action methods
	public void clickRegister()
	{
		lnkRegister.click();
	}

}
