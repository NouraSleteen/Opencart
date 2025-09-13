package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators
	
	@FindBy(xpath="//input[@id='input-email']")  WebElement txt_email; 
	@FindBy(xpath="//input[@id='input-password']")  WebElement txt_password; 
	@FindBy(xpath="//button[normalize-space()='Login']")  WebElement btn_login; 


	
	//Methods
	 public void setUsername (String username)
	 {
		 txt_email.sendKeys(username);	 }
	 
	 public void setPassword (String pwd)
	 {
		 txt_password.sendKeys(pwd);
	 }
	 public void clickLogin ()
	 {
		 btn_login.click();
	 }
	
	
	

}
