package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(xpath="//input[@id='email']")
	  private WebElement userid;
	@FindBy(xpath="//input[@id='pass']")
	   private WebElement password;
  @FindBy(xpath="//button[@name='login']")
	   private WebElement btnlogin;
  
  public void setEmail(String email) {
	  userid.sendKeys(email);
  }
  
  public void setPass(String pass) {
	  password.sendKeys(pass);
  }
  public void clickLogin() {
	  btnlogin.click();
  }
  
  
  
  
  
  
  

}
