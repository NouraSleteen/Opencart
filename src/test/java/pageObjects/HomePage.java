package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
	
	
	//Constructor
	public HomePage (WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	
	@FindBy(linkText = "My Account") private  WebElement accountlink ;
	@FindBy(linkText = "Register") private  WebElement registerlink;
	@FindBy(linkText = "Login") private  WebElement loginlink;
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	//Methods
	public void account()
	{
		//accountlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(accountlink)).click();

	
	}
	public void  register()
	{
		//registerlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(registerlink)).click();
	}
	
	public void  login()
	{
		//registerlink.click();
		wait.until(ExpectedConditions.elementToBeClickable(loginlink)).click();
	}
	
}
